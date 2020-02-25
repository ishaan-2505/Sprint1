package com.capgemini.dao;

import java.sql.SQLException;

import com.capgemini.entities.Transaction;

public interface Dao {
	public Transaction searchCustomer(String AccountId) throws SQLException;
	public boolean credit(String accountId,Double amount) throws SQLException;
	public boolean debit(String accountId,Double amount) throws SQLException;
	public double getbal(String accountid) throws SQLException;
	public String validate(String accountid) throws SQLException;

}
