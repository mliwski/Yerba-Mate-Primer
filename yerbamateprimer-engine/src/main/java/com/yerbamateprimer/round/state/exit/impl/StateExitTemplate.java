package com.yerbamateprimer.round.state.exit.impl;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yerbamateprimer.action.system.SystemAction;
import com.yerbamateprimer.round.state.State;
import com.yerbamateprimer.round.state.exit.StateExit;
import com.yerbamateprimer.round.state.exit.StateExitCause;

public abstract class StateExitTemplate implements StateExit {
	private final static transient Logger LOGGER = LoggerFactory.getLogger(StateExit.class);
	private final static transient ScheduledExecutorService EXECUTOR = Executors.newScheduledThreadPool(5);

	@Override
	abstract public void addAction(SystemAction action);
	@Override
	abstract public void addAction(SystemAction action, Long delay);
	@Override
	abstract public StateExitCause getCause();
	@Override
	abstract public Map<Long, Collection<SystemAction>> getGetOutActions();
	@Override
	abstract public State getNextState();
	@Override
	abstract public boolean isThisExit(State state);
	@Override
	abstract public void setCause(StateExitCause cause);
	@Override
	abstract public void setNextState(State nextState);

	/**
	 * This method follow the next steps:
	 * <ul>
	 * 		<li>Launch each action with his delay.</li>
	 * 		<li>After the longest delay action get into next state.</li>
	 * 		<li>Return the next state.</li>
	 * </ul>
	 * @see com.yerbamateprimer.round.state.exit.StateExit#apply()
	 */
	@Override
	public State apply() {
		for (Entry<Long, Collection<SystemAction>> delayedActions : getGetOutActions().entrySet()) {
			Long delay = delayedActions.getKey();
			final Collection<SystemAction> actions = delayedActions.getValue();

			LOGGER.debug("The actions {} will be executed after {} millis, from now.", actions, delay);
			Runnable executeActions = new Runnable() {
				public void run() {
					for (SystemAction action : actions) {
						action.execute();
					}
				}
			};
			EXECUTOR.schedule( executeActions, delay, TimeUnit.MILLISECONDS);
		}
		Long getInDelay = getGetOutActions().keySet().iterator().next();
		
		Runnable executeGetIn = new Runnable() {
			public void run() {
				getNextState().getIn();
			}
		};
		EXECUTOR.schedule( executeGetIn, getInDelay, TimeUnit.MILLISECONDS);
		
		return getNextState();
	}
}
