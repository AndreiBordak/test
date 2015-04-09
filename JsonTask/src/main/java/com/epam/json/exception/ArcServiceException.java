package com.epam.json.exception;

public class ArcServiceException extends ProjectException {

	/**
	 *
	 */
	private static final long serialVersionUID = -7985500442239309686L;

	public ArcServiceException() {
	}

	public ArcServiceException(String message) {
		super(message);
	}

	public ArcServiceException(Throwable cause) {
		super(cause);
	}

	public ArcServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ArcServiceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
