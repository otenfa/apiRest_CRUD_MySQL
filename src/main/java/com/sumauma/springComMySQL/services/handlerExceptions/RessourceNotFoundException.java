package com.sumauma.springComMySQL.services.handlerExceptions;

public class RessourceNotFoundException extends RuntimeException {

	public RessourceNotFoundException(String msg) {
		super(msg);
	}
}
