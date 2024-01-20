package com.dollop.app.exception;

public class PasswordNotMatchException extends RuntimeException

{
	private static final long serialVersionUID = 1L;

	public PasswordNotMatchException() {
		super("Password Not Match ");
		// TODO Auto-generated constructor stub
	}
	public PasswordNotMatchException(String Message) {
		super(Message);
		// TODO Auto-generated constructor stub
	}


	}
