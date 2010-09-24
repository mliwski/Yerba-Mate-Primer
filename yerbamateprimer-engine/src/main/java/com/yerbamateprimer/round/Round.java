package com.yerbamateprimer.round;

import java.util.List;

import com.yerbamateprimer.model.Mate;
import com.yerbamateprimer.model.Person;
import com.yerbamateprimer.round.state.State;

/**
 * This interface represents
 * a yerba mate round.
 * 
 * @author Matias Liwski
 */
public interface Round {
	/**
	 * @return The list of participants that are at penance for this round.
	 */
	List<Person> getPenanceParticipants();
	
	/**
	 * @param person A person to add to the penance list.
	 */
	void addPenancePerson(Person person);
	
	/**
	 * @param person A person to remove from penance list.
	 */
	void removePenancePerson(Person person);

	/**
	 * @return The people participating on this round.
	 */
	List<Person> getParticipantPeople();
	
	/**
	 * @param person A person to add to this round.
	 */
	void addParticipantPerson(Person person);

	/**
	 * @param person A person to remove from this round.
	 */
	void removeParticipantPerson(Person person);

	/**
	 * @param person Set the current drinker of the mate.
	 */
	void setCurrentDrinker(Person person);

	/**
	 * @return The current drinker of the mate, or null if none.
	 */
	Person getCurrentDrinker();

	/**
	 * @param primer The current primer of the mate for this round.
	 */
	void setCurrentPrimer(Person primer);

	/**
	 * @return The current primer of the mate for this round.
	 */
	Person getCurrentPrimer();

	/**
	 * @param mate The mate to use in this round.
	 */
	void setMate(Mate mate);

	/**
	 * @return The mate in use for this round.
	 */
	Mate getMate();

	/**
	 * @return The state of this round.
	 */
	State getState();

	/**
	 * Start the round.
	 */
	void start();

	/**
	 * Stop the round.
	 */
	void stop();

	/**
	 * Pause the round.
	 */
	void pause();

	/**
	 * Restart the round. 
	 */
	void restart();
}
