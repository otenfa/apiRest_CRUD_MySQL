package com.sumauma.springComMySQL.controllers.handlerExceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sumauma.springComMySQL.dto.BodyRequestError;
import com.sumauma.springComMySQL.services.handlerExceptions.RessourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(RessourceNotFoundException.class)
	public ResponseEntity<BodyRequestError> customName(RessourceNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		BodyRequestError errMsgRequest = new BodyRequestError(Instant.now(), 
				status.value(), 
				e.getMessage(), 
				request.getRequestURI());
		return ResponseEntity.status(status).body(errMsgRequest);
	}
	
}
