package com.yerbamateprimer.action.impl;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yerbamateprimer.action.Action;
import com.yerbamateprimer.action.ActionCode;

public class NotifyEventToCurrentAction implements Action {
	private final static transient Logger LOGGER = LoggerFactory.getLogger(NotifyEventToCurrentAction.class);
	private final static ActionCode ACTION_CODE = ActionCode.NOTIFY_EVENT_TO_CURRENT;

	@Override
	public void execute() {
		LOGGER.debug("Executing {}.", ACTION_CODE);
	}

	@Override
	public ActionCode getCode() {
		return ACTION_CODE;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE, false, true);
	}
}