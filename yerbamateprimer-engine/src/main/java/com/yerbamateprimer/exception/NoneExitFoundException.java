package com.yerbamateprimer.exception;

public class NoneExitFoundException extends RuntimeException {
	private static final long serialVersionUID = 5400483144909437895L;

	/** 
	 * Constructs a new exception with <code>null</code> as its detail message. 
	 */
	public NoneExitFoundException() {
		super();
	}

	/**
	 * @param message The message to set.
	 */
	public NoneExitFoundException(String message) {
		super(message);
    }

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
