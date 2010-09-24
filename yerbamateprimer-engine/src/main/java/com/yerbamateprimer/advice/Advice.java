package com.yerbamateprimer.advice;

import com.yerbamateprimer.client.Client;

/**
 * This interface defines an Advice
 * to the clients that are subscribes
 * client.
 * 
 * @author Matias Liwski
 */
public interface Advice {
	/**
	 * @return The code for this advice.
	 */
	AdviceCode getCode();

	/**
	 * @param client The client to subscribe to this advice.
	 */
	void subscribe(Client client);

	/**
	 * Send the advice to the clients subscribed.
	 */
	void send();
}
