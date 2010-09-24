package com.yerbamateprimer.action;

import java.io.Serializable;

/**
 * This interface defines an action
 * to execute.
 * 
 * @author Matias Liwski
 * @version 1.0
 */
public interface Action extends Serializable {
	/**
	 * @return The code for this action.
	 */
	ActionCode getCode();
	
	/**
	 * Executes this action.
	 */
	void execute();
}
