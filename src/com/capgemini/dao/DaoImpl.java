package com.capgemini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.capgemini.entities.Transaction;
import com.capgemini.util.DatabaseUtil;

public class DaoImpl implements Dao {
	Transaction transaction;
	Connection connection;
	PreparedStatement pst;
	ResultSet rs;

	Transaction b = new Transaction();
	Double balance;
	String ch;
	Scanner sc = new Scanner(System.in);

	public DaoImpl() throws SQLException {
		connection = DatabaseUtil.myconnection();
		connection.setAutoCommit(false);
		transaction = new Transaction();
	}

	public Transaction searchCustomer(String AccountId) throws SQLException {
		pst = connection.prepareStatement("select * from transaction where accountid=?");
		pst.setString(1, AccountId);
		rs = null;
		rs = pst.executeQuery();

		if (rs.next()) {
			System.out.println("Search found");

			transaction.setAccountid(rs.getString(1));
			transaction.setTransid(rs.getString(2));
			transaction.setAmount(rs.getDouble(3));
			transaction.setDate(rs.getString(4));
			transaction.setType(rs.getString(5));
			transaction.setBalance(rs.getDouble(6));

		}
		return transaction;
	}

	@Override
	public boolean credit(String accountid, Double amount) throws SQLException {
		transaction = searchCustomer(accountid);
		balance = 0.0;

		balance = getbal(accountid) + amount;
		if (transaction != null)
			pst = null;
		pst = connection.prepareStatement("Update transaction set balance=? where accountid=?");
		pst.setDouble(1, balance);
		pst.setString(2, accountid);
		int res = pst.executeUpdate();
		if (res == 1) {
			System.out.println("credit it into database press y");
			ch = sc.next();
			if (ch.equalsIgnoreCase("y")) {
				connection.commit();
				return true;
			} else {
				connection.rollback();
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean debit(String accountid, Double amount) throws SQLException {
		transaction = searchCustomer(accountid);
		balance = 0.0;
		balance = getbal(accountid) - amount;

		if (transaction != null)
			pst = null;
		pst = connection.prepareStatement("Update transaction set balance=? where accountid=?");
		pst.setDouble(1, balance);
		pst.setString(2, accountid);
		int res = pst.executeUpdate();
		if (res == 1) {
			System.out.println("debit it into database y\\n");
			ch = sc.next();
			if (ch.equalsIgnoreCase("y")) {
				connection.commit();
				return true;
			} else {
				connection.rollback();
				return false;
			}
		}
		return false;
	}

	public double getbal(String accountid) throws SQLException {
		pst = null;
		pst = connection.prepareStatement("Select balance from transaction where accountid=?");
		pst.setString(1, accountid);
		ResultSet rs = pst.executeQuery();
		if(rs.next())
			return rs.getDouble(1);
		return (Double) null;
	}

	public String validate(String accountid) throws SQLException {
		pst = null;
		pst = connection.prepareStatement("Select accountid from transaction where accountid=?");
		pst.setString(1, accountid);
		ResultSet rs = pst.executeQuery();
		if (rs.next())
			return rs.getString(1);
		return null;
	}
}