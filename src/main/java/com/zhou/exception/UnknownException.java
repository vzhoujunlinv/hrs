package com.zhou.exception;

public class UnknownException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnknownException() {
		super();
	}

	public UnknownException(String message, Throwable cause,
							boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnknownException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownException(String message) {
		super(message);
	}

	public UnknownException(Throwable cause) {
		super(cause);
	}

}
 