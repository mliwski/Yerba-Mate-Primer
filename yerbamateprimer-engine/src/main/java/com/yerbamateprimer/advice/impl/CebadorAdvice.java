package com.yerbamateprimer.advice.impl;

import java.util.List;

import com.yerbamateprimer.advice.Advice;
import com.yerbamateprimer.advice.AdviceCode;
import com.yerbamateprimer.client.Client;

public class CebadorAdvice implements Advice {
	private List<Client> clients;

	@Override
	public AdviceCode getCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void send() {
		// TODO Auto-generated method stub
	}

	@Override
	public void subscribe(Client client) {
		this.clients.add(client);
	}
}