package com.epam.json.exception;

public class ProjectException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = -3737916987951666771L;

	public ProjectException() {
	}

	public ProjectException(String message) {
		super(message);
	}

	public ProjectException(Throwable cause) {
		super(cause);
	}

	public ProjectException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProjectException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
