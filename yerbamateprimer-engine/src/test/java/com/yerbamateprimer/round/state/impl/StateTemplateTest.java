package com.yerbamateprimer.round.state.impl;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yerbamateprimer.action.system.SystemAction;
import com.yerbamateprimer.round.state.State;
import com.yerbamateprimer.round.state.StateName;
import com.yerbamateprimer.round.state.exit.StateExit;

public class StateTemplateTest {

	@Test
	public void testTimeOutGetOut() throws Exception {
		State dummyState = new SpyState();
		State mockState = Mockito.spy(dummyState);

//		Mockito.when(mockState.getAutoGetOutDelay()).thenReturn(5L);
//		
//		Mockito.when(mockState.getGetOutActions(StateExitCauseImpl.TIMEOUT)).thenReturn(new ArrayList<SystemAction>());
//		Mockito.when(mockState.getGetOutDelay(StateExitCauseImpl.TIMEOUT)).thenReturn(1L);
//		Mockito.when(mockState.getNextState(StateExitCauseImpl.TIMEOUT)).thenReturn(dummyState);
//
//		mockState.getIn();
//		Thread.sleep(10L);
//		Mockito.verify(mockState).getNextState(StateExitCauseImpl.TIMEOUT);
	}

	@Test
	public void testInterruptedGetOut() throws Exception {
		State dummyState = new SpyState();
		State mockState = Mockito.spy(dummyState);

		Mockito.when(mockState.getAutoGetOutDelay()).thenReturn(10L);
		
//		Mockito.when(mockState.getGetOutActions(StateExitCauseImpl.TIMEOUT)).thenReturn(new ArrayList<SystemAction>());
//		Mockito.when(mockState.getGetOutDelay(StateExitCauseImpl.TIMEOUT)).thenReturn(1L);
//		Mockito.when(mockState.getNextState(StateExitCauseImpl.TIMEOUT)).thenReturn(dummyState);
//		
//		
//		Mockito.when(mockState.getGetOutActions(StateExitCauseImpl.INTERRUPTED)).thenReturn(new ArrayList<SystemAction>());
//		Mockito.when(mockState.getGetOutDelay(StateExitCauseImpl.INTERRUPTED)).thenReturn(1L);
//		Mockito.when(mockState.getNextState(StateExitCauseImpl.INTERRUPTED)).thenReturn(dummyState);
//
//		mockState.getIn();
//		Thread.sleep(8L);
//		mockState.getOut();
//		Mockito.verify(mockState).getNextState(StateExitCauseImpl.INTERRUPTED);
	}	

	@Test
	public void testWithoutGetInDelay() {
		fail("Not yet implemented");
	}

	@Test
	public void testWithoutGetOutDelay() {
		fail("Not yet implemented");
	}

	@Test
	public void testWithoutAutoGetOutDelay() {
		fail("Not yet implemented");
	}
	
	private class SpyState extends StateTemplate {
		private final Logger LOGGER = LoggerFactory.getLogger(SpyState.class);
		private List<SystemAction> getInActions;
		private Long autoGetOutDelay;

		public SpyState() {
			this.getInActions = new ArrayList<SystemAction>();
		}

		@Override
		public void addGetInAction(SystemAction action) {
			this.getInActions.add(action);
		}

		@Override
		public StateName getName() {
			return Mockito.mock(StateName.class);
		}

		@Override
		public List<SystemAction> getGetInActions() {
			return new ArrayList<SystemAction>(this.getInActions);
		}

		@Override
		public Long getAutoGetOutDelay() {
			return this.autoGetOutDelay;
		}

		@Override
		public void setAutoGetOutDelay(Long delay) {
			this.autoGetOutDelay = delay;
		}
		
		@Override
		public String toString() {
			return "SPY_STATE";
		}

		@Override
		public void addExit(StateExit exit) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<StateExit> getExits() {
			// TODO Auto-generated method stub
			return null;
		}
	}
}