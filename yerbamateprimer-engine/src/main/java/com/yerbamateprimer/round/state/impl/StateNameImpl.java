package com.yerbamateprimer.round.state.impl;

import com.yerbamateprimer.round.state.StateName;

/**
 * The possible names of a 
 * yerba mate round.
 * 
 * @author Matias Liwski
 * @version 1.0
 */
public enum StateNameImpl implements StateName{
	BUILDING 	// Building the mate.
	, RESTING 	// Resting between primes.
	, PRIMING 	// Priming the mate.
	, DRINKING 	// Someone is drinking the mate.
	, DEAD; 	// The mate is dead (washed).
}
