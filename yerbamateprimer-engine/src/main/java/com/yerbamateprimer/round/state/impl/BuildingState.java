package com.yerbamateprimer.round.state.impl;

import java.util.ArrayList;
import java.util.List;

import com.yerbamateprimer.action.system.SystemAction;
import com.yerbamateprimer.round.state.State;
import com.yerbamateprimer.round.state.StateName;
import com.yerbamateprimer.round.state.exit.StateExit;

/**
 * This class represent the state
 * when the mate is on build.
 * 
 * @author Matias Liwski
 * @version 1.0
 */
public class BuildingState extends StateTemplate implements State {
	private final static StateName STATE_NAME = StateNameImpl.BUILDING;
	private List<StateExit> exits;
	private List<SystemAction> getInActions;
	private Long autoGetOutDelay;

	@Override
	public void addExit(StateExit exit) {
		this.exits.add(exit);
	}

	@Override
	public void addGetInAction(SystemAction action) {
		this.getInActions.add(action);
	}

	@Override
	public Long getAutoGetOutDelay() {
		return this.autoGetOutDelay;
	}

	@Override
	public StateName getName() {
		return STATE_NAME;
	}

	@Override
	public List<StateExit> getExits() {
		return new ArrayList<StateExit>(exits);
	}

	@Override
	public List<SystemAction> getGetInActions() {
		return new ArrayList<SystemAction>(getInActions);
	}

	@Override
	public void setAutoGetOutDelay(Long delay) {
		this.autoGetOutDelay = delay;
	}
}