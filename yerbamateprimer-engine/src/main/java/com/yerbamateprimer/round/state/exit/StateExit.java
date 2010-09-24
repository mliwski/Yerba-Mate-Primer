package com.yerbamateprimer.round.state.exit;

import java.util.Collection;
import java.util.Map;

import com.yerbamateprimer.action.system.SystemAction;
import com.yerbamateprimer.round.state.State;

public interface StateExit {
	/**
	 * @param cause The cause to set.
	 */
	void setCause(StateExitCause cause);
	/**
	 * @return The cause of this exit.
	 */
	StateExitCause getCause();
	/**
	 * Add an immediate execution system action.
	 * @param action The system action to add.
	 */
	void addAction(SystemAction action);
	/**
	 * Add a system action with a delay on his execution.
	 * @param action The system action to add.
	 * @param delay The delay to wait before execute the action.
	 */
	void addAction(SystemAction action, Long delay);
	/**
	 * @return The relation of delay / system actions.
	 */
	Map<Long, Collection<SystemAction>> getGetOutActions();
	/**
	 * @return The next state to get into. 
	 */
	State getNextState();
	/**
	 * Set the state to get into. 
	 * @param nextState The next state for this state to set.
	 */
	void setNextState(State nextState);
	/**
	 * @param state The state to evaluate.
	 * @return true if this is the exit of the provided {@link State}.
	 */
	boolean isThisExit(State state);
	
	/**
	 * Apply this exit. This involves the following steps:
	 * <ul>
	 * 		<li>Execute each action in his delay.</li>
	 * 		<li>Get into the next state.</li>
	 * 		<li>Return the state where are getting in.</li>
	 * </ul>
	 * @return The state where are getting in.
	 */
	State apply();
}