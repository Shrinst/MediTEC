package org.meditec.meditecserver.exception;

public class DataNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 5949772200398795860L;
	
	public DataNotFoundException(String message) {
		super(message);
	}
}
