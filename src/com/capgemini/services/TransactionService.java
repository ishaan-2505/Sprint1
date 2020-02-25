package com.capgemini.services;

import java.sql.SQLException;

import com.capgemini.exceptions.InsufficientBalance;
import com.capgemini.exceptions.InvalidAccount;

public interface TransactionService {
	public void creditAmount() throws SQLException,InvalidAccount;
	public void debitAmount() throws SQLException,InsufficientBalance;

}
