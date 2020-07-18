package com.test.api.exception_handler;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.test.api.exception.MockTestObjectNotFoundException;
import com.test.api.model.ErrorResponse;

@ControllerAdvice
public class MockTestExceptionHandler {
	
	@ExceptionHandler(MockTestObjectNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleObjectNotFoundException(MockTestObjectNotFoundException ex,WebRequest wr){
		 ErrorResponse error = new ErrorResponse("INCORRECT_REQUEST", Arrays.asList(ex.getLocalizedMessage()));
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
	
	
}
