package com.yerbamateprimer.action.system.advice.impl;

import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yerbamateprimer.action.ActionCode;
import com.yerbamateprimer.action.system.advice.Advice;
import com.yerbamateprimer.client.Client;

/**
 * This class models an advice to the
 * 
 * @author Matias Liwski
 * @version 1.0
 */
public class RoundStartedAdvice implements Advice {
	private static final long serialVersionUID = 2023167993968356719L;
	private static final transient Logger LOGGER = LoggerFactory.getLogger(RoundStartedAdvice.class);
	private static final ActionCode ACTION_CODE = ActionCode.ROUND_STARTED_ADVICE;
	private List<Client> clients;

	@Override
	public ActionCode getCode() {
		return ACTION_CODE;
	}

	@Override
	public void suscribe(Client client) {
		LOGGER.info("Client {} suscribed to this action.", client);
		this.clients.add(client);
	}

	@Override
	public void execute() {
		for (Client client : clients) {
			client.send(this);
		}
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE, false, true);
	}
}