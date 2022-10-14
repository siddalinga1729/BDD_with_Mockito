package com.mockito_junit_05.mockito.test_doubles.dummy;

public class DummyEmailService implements EmailService{

	@Override
	public void sendEmail(String message) {
		throw new AssertionError("Method not implmented");
	}
}
