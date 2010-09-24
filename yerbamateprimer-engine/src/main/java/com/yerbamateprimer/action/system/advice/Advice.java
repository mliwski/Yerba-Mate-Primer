package com.yerbamateprimer.action.system.advice;

import com.yerbamateprimer.action.system.SystemAction;
import com.yerbamateprimer.client.Client;

/**
 * This interface defines an advice
 * to send to a client.
 * 
 * @author Matias Liwski
 * @version 1.0
 */
public interface Advice extends SystemAction {
	/**
	 * Subscribe a client to this
	 * advice.
	 * 
	 * @param client The client to subscribe.
	 */
	void suscribe(Client client);
}
