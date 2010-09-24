package com.yerbamateprimer.round.state.exit.impl;

import com.yerbamateprimer.round.state.exit.StateExitCause;

/**
 * This enumeration is useful
 * to implement the cause of 
 * exit from the state.
 * 
 * @author Matias Liwski
 * @version 1.0
 */
public enum StateExitCauseImpl implements StateExitCause{
	UNIQUE,	// The unique cause of exit from the state.
	TIMEOUT,// The state reached the delay time.
	DONE,	// For some reason the state ends before time out is reached.
	UNKNOWN;// An unknown or generic cause of exit.
}
