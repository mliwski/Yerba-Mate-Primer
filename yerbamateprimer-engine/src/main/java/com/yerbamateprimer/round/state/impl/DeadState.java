package com.yerbamateprimer.round.state.impl;

/**
 * This class represent the state
 * when the mate is dead.
 * 
 * @author Matias Liwski
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yerbamateprimer.action.system.SystemAction;
import com.yerbamateprimer.round.state.State;
import com.yerbamateprimer.round.state.StateName;
import com.yerbamateprimer.round.state.exit.StateExit;

public class DeadState extends StateTemplate implements State {
	private final static transient Logger LOGGER = LoggerFactory.getLogger(DeadState.class);
	private final static StateName STATE_NAME = StateNameImpl.DEAD;
	private List<SystemAction> getInActions;

	@Override
	public void addExit(StateExit exit) {
		throw new IllegalStateException("There is no exit after dead");
	}

	@Override
	public void addGetInAction(SystemAction action) {
		this.getInActions.add(action);
	}

	@Override
	public Long getAutoGetOutDelay() {
		return 0L;
	}

	@Override
	public StateName getName() {
		return STATE_NAME;
	}

	@Override
	public List<StateExit> getExits() {
		return Collections.<StateExit>emptyList();
	}

	@Override
	public List<SystemAction> getGetInActions() {
		return new ArrayList<SystemAction>(getInActions);
	}

	@Override
	public void setAutoGetOutDelay(Long delay) {
		throw new IllegalStateException("The dead haven't mercy she will not wait.");
	}
	
	@Override
	public void getIn() {
		LOGGER.debug("Get into state {}, the last state.", getName());
		executeGetInActions();
		LOGGER.debug("The round is finished.");
	}

	@Override
	public State getOut() {
		throw new IllegalStateException("Cannot get out of dead.");
	}
}