package com.test.api.exception;

public class MockTestObjectNotFoundException extends Exception {

	public MockTestObjectNotFoundException(String s) {
		super(s);
	}

	public MockTestObjectNotFoundException(String s, Exception e) {
		super(s, e);
	}

}

