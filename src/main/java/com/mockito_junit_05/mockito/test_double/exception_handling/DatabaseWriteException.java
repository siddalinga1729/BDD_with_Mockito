package com.mockito_junit_05.mockito.test_double.exception_handling;

public class DatabaseWriteException extends RuntimeException {
	public DatabaseWriteException(String message) {
		super(message);
	}
}
