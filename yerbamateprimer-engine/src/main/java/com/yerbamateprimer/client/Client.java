package com.yerbamateprimer.client;

import com.yerbamateprimer.action.system.advice.Advice;

/**
 * This interface define a client
 * to use to connect with the 
 * mate cebador.
 * 
 * @author Matias Liwski
 */
public interface Client {
	void send(Advice advice);

}
