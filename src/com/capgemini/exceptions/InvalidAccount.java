package com.capgemini.exceptions;

public class InvalidAccount extends RuntimeException{
	public InvalidAccount(String mssg) {
		super(mssg);
	}
}
