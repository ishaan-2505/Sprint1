package com.capgemini.exceptions;

public class InsufficientBalance extends RuntimeException {
	public InsufficientBalance(String mssg) {
		super(mssg);
	}
}
