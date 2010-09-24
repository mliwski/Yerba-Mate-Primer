package com.yerbamateprimer.round.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yerbamateprimer.model.Mate;
import com.yerbamateprimer.model.Person;
import com.yerbamateprimer.round.Round;
import com.yerbamateprimer.round.state.State;
import com.yerbamateprimer.round.state.impl.BuildingState;
import com.yerbamateprimer.round.state.impl.RestingState;

/**
 * This class models a regular round
 * of yerba mate, without penalties.
 * 
 * @author Matias Liwski
 */
public class RegularRound implements Round {
	private final static transient Logger LOGGER = LoggerFactory.getLogger(BuildingState.class);
	private List<Person> participantDrinkers;
	private Person cebador;
	private Person currentDrinker;
	private Mate mate;
	private State state;

	/**
	 * @param participantDrinkers A participant drinkers for this round.
	 * @param mate The mate in use for this round.
	 */
	public RegularRound(List<Person> participantDrinkers, Mate mate) {
		this.participantDrinkers = participantDrinkers;
		this.mate = mate;

//		State buildingState = new BuildingState(nu, )
//		State cebatingState = new BuildingState(null, buildingState, mate.getCebadaTime());
//		State DrinkingState = new BuildingState(null, buildingState, mate.getDrinkTime());
//		State restingState = new RestingState(null, buildingState, mate);
	}

	@Override
	public void addParticipantPerson(Person drinker) {
		this.participantDrinkers.add(drinker);
	}

	/**
	 * This round doesn't have penance.
	 * @see com.yerbamateprimer.round.Round#addPenancePerson(com.yerbamateprimer.model.Person)
	 */
	@Override
	public void addPenancePerson(Person drinker) {
		LOGGER.warn("The method addPenanceDrinker was invoked");
	}

	@Override
	public Person getCurrentPrimer() {
		return this.cebador;
	}

	@Override
	public Person getCurrentDrinker() {
		return this.currentDrinker;
	}

	@Override
	public Mate getMate() {
		return this.mate;
	}

	@Override
	public List<Person> getParticipantPeople() {
		return new ArrayList<Person>(this.participantDrinkers);
	}

	/**
	 * This round doesn't have penance.
	 * @see com.yerbamateprimer.round.Round#getPenanceParticipants()
	 */
	@Override
	public List<Person> getPenanceParticipants() {
		LOGGER.warn("The method getPenanceDrinkers was invoked");
		return Collections.emptyList();
	}

	@Override
	public void removeParticipantPerson(Person drinker) {
		this.participantDrinkers.remove(drinker);
	}

	/**
	 * This round doesn't have penance.
	 * @see com.yerbamateprimer.round.Round#removePenancePerson(com.yerbamateprimer.model.Person)
	 */
	@Override
	public void removePenancePerson(Person drinker) {
		LOGGER.warn("The method removePenanceDrinker was invoked");
	}

	@Override
	public void setCurrentPrimer(Person drinker) {
		this.cebador = drinker;
	}

	@Override
	public void setCurrentDrinker(Person drinker) {
		this.currentDrinker = drinker;
	}

	@Override
	public void setMate(Mate mate) {
		this.mate = mate;
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public State getState() {
		return this.state;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
