package com.yerbamateprimer.round.state;

import java.util.List;

import com.yerbamateprimer.action.system.SystemAction;
import com.yerbamateprimer.round.state.exit.StateExit;

/**
 * This interface defines an state
 * of a yerba mate round.
 * 
 * @author Matias Liwski
 * @version 1.0
 */
public interface State {
	/**
	 * @return The name of this state.
	 */
	StateName getName();
	/**
	 * @param action The system action to add when get into the action.
	 */
	void addGetInAction(SystemAction action);
	/**
	 * @return The list of actions to execute when get in the state. 
	 */
	List<SystemAction> getGetInActions();
	/**
	 * @param delay The delay to set before auto get out of state.
	 */
	void setAutoGetOutDelay(Long delay);
	/**
	 * @return The delay set before auto get out of state.
	 */
	Long getAutoGetOutDelay();
	/**
	 * @param exit The {@link StateExit exit} to add to this state.
	 */
	void addExit(StateExit exit);
	/**
	 * @return All the {@link StateExit exits} of this state.
	 */
	public List<StateExit> getExits();
	/**
	 * Get into this state.
	 */
	void getIn();
	/**
	 * Force the get out of this state.
	 */
	State getOut();
}