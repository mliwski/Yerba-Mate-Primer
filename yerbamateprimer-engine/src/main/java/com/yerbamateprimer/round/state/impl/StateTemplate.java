package com.yerbamateprimer.round.state.impl;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.yerbamateprimer.action.system.SystemAction;
import com.yerbamateprimer.exception.NoneExitFoundException;
import com.yerbamateprimer.round.state.State;
import com.yerbamateprimer.round.state.StateName;
import com.yerbamateprimer.round.state.exit.StateExit;

/**
 * This abstract method is useful to comply
 * with the get in / get out, behaviors.<br/>
 * It's based in the template design pattern.
 * 
 * @author Matias Liwski
 * @version 1.0
 */
public abstract class StateTemplate implements State {
	private final static transient Logger LOGGER = LoggerFactory.getLogger(StateTemplate.class);
	private final static transient ScheduledExecutorService EXECUTOR = Executors.newScheduledThreadPool(5);
	private ScheduledFuture<?> autoGetOutSchedule = null;
	private Object monitor = new Object();
	
	@Override
	abstract public StateName getName();
	@Override
	abstract public void addGetInAction(SystemAction action);
	@Override
	abstract public List<SystemAction> getGetInActions();
	@Override
	abstract public void setAutoGetOutDelay(Long delay);
	@Override
	abstract public Long getAutoGetOutDelay();
	@Override
	abstract public void addExit(StateExit exit);
	@Override
	abstract public List<StateExit> getExits();

	/**
	 * Execute the get in actions.
	 */
	final protected void executeGetInActions() {
		for (SystemAction action : getGetInActions()) {
			action.execute();
		}
	}

	/**
	 * Get into this state. This involves these steps in order:
	 * <ul>
	 * 		<li>Execute the get in system actions.</li>
	 * 		<li>Wait until auto time out is reached or getOut() method is executed.</li>
	 * </ul>
	 * @see com.yerbamateprimer.round.state.State#getIn()
	 */
	@Override
	public void getIn() {
		LOGGER.debug("Get into state {}.", getName());
		executeGetInActions();
		waitBeforeAutoGetOut();
	}

	/**
	 * Wait in the current state until some of this hints happen:
	 * <ul>
	 * 		<li>getOut() method is executed.</li>
	 * 		<li>Time out because </li>
	 * </ul>
	 */
	protected void waitBeforeAutoGetOut(){
		final StateName stateCode = getName();
		final Long autoGetOutDelay = getAutoGetOutDelay();
		Preconditions.checkState(autoGetOutDelay != null, "The auto get out delay, can't be null.");
		Preconditions.checkState(autoGetOutDelay.longValue() >= 0, "The auto get out delay, can't be lower than zero.");

		LOGGER.debug("Sleeping for {} millis, on waiting before get out of state {}.", autoGetOutDelay, stateCode);
		Runnable executeGetOut = new Runnable() {
			public void run() {
				LOGGER.debug("Waked up after {} millis, on wait before auto get out of {} state.", autoGetOutDelay, stateCode);
				synchronized (monitor) {
					if(!autoGetOutSchedule.isCancelled()) {
						getOut(StateStatus.TIMED_OUT);
					}
				}
			}
		};
		autoGetOutSchedule = EXECUTOR.schedule( executeGetOut, autoGetOutDelay, TimeUnit.MILLISECONDS);
	}

	/**
	 * Force the get out of this state. This involves these steps in order:
	 * <ul>
	 * 		<li>Execute the get out system actions, corresponding to the exit cause.</li>
	 * 		<li>Sleep the corresponding get out delay time.</li>
	 * </ul>
	 * @return The next {@link State} where are getting into.
	 */
	@Override
	public State getOut() {
		Preconditions.checkState(this.autoGetOutSchedule != null
				, "Couldn't interrupt a state that have a null auto get out schedule delay.");
		Preconditions.checkState(!this.autoGetOutSchedule.isCancelled()
				, "Couldn't interrupt a state that has been already interrupted.");

		synchronized (monitor) {
			if (!this.autoGetOutSchedule.isDone()) {
				autoGetOutSchedule.cancel(true);
				return getOut(StateStatus.INTERRUPTED);	
			} else {
				return null;
			}
		}
	}
	
	/**
	 * Method useful to know execute the corresponding
	 * get out actions and after the corresponding 
	 * get out delay, get into the corresponding next
	 * state.
	 * 
	 * @param exitCause The exit cause of this state.
	 * @return The next state according to the exit cause.
	 */
	synchronized protected final State getOut(final StateStatus status) {
		final StateName stateCode = getName();
		final List<StateExit> exits = getExits();

		Preconditions.checkState(status != null, "Null status detected at " + stateCode + ".");
		Preconditions.checkState(!StateStatus.UNKNOWN.equals(status), "Unknown status, this method shouldn't be call before know status of the state " + stateCode + ".");
		Preconditions.checkState(!exits.isEmpty(), "None exit found at " + stateCode + ".");

		LOGGER.debug("Get out of state {}, with status of {}.", stateCode, status);

		for (StateExit exit : exits ) {
			if (exit.isThisExit(this)) {
				return exit.apply();
			}
		}
		throw new NoneExitFoundException();
	}
}