package com.raza.inventory.exceptions;

@SuppressWarnings("serial")
public class MicroServiceException extends Exception{
	public MicroServiceException() {
		super("Service is not up and running. Please contact your administrator.");
	}
}
