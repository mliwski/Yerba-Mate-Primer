package com.yerbamateprimer.round.state.impl;

/**
 * The possible status of a 
 * yerba mate round.
 * 
 * @author Matias Liwski
 * @version 1.0
 */
public enum StateStatus{
	TIMED_OUT,	// The delay time is reached.
	INTERRUPTED,// An interruption happen earlier than the delay time.
	UNKNOWN; 	// The status is unknown.

}
