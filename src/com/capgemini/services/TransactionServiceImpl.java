package com.capgemini.services;

import java.sql.SQLException;
import java.util.*;
import com.capgemini.exceptions.*;
import com.capgemini.dao.*;
import com.capgemini.entities.*;

public class TransactionServiceImpl implements TransactionService {
	Dao TransactionDao;
	Scanner scanner=new Scanner(System.in);
	String accountid; 
	Double amount;
	Double balance;
	Transaction transaction= new Transaction();
	
	public TransactionServiceImpl() throws SQLException{
		TransactionDao= new DaoImpl();
	}


	@Override
	public void creditAmount() throws SQLException, InvalidAccount {
		System.out.println("Enter Account id");
		transaction=null;
		transaction=new Transaction();
		accountid=scanner.next();
		boolean result= accountid.equals(TransactionDao.validate(accountid));
		if(result) {
			transaction.setAccountid(accountid);
		}
		else 
			throw new InvalidAccount("Invalid Account Number");
		System.out.println("Enter amount to be credit");
		amount=scanner.nextDouble();
		//double bal=TransactionDao.getbal(accountid);
		//bal=bal+amount;
		//scanner.nextLine();
		//System.out.println("balance after credit is "+bal);
		if(TransactionDao.credit(accountid,amount)) {
			System.out.println("amount credit");
			System.out.println("balance after credit is " + TransactionDao.getbal(accountid) );}
		else
			System.out.println("something wrong");
	}
	
	@Override
	public void debitAmount() throws SQLException, InsufficientBalance {
		System.out.println("Enter id");
		transaction=null;
		transaction=new Transaction();
		accountid=scanner.next();
		boolean result= accountid.equals(TransactionDao.validate(accountid));
		
		if(result) {
			transaction.setAccountid(accountid);
		}
		else
			throw new InvalidAccount("Invalid Account Number");
		
		System.out.println("Enter amount to be debit");
		amount=scanner.nextDouble();
		balance=TransactionDao.getbal(accountid);
		//System.out.println("balance is "+balance);
		if(balance<=0 || amount>TransactionDao.getbal(accountid)) {
			throw new InsufficientBalance("Insufficient Balance for debit");}
		//scanner.nextLine();
	
		
		if(TransactionDao.debit(accountid,amount)) { 
			
			System.out.println("amount debited");
			System.out.println("balance after debit is " + TransactionDao.getbal(accountid) );}
		else
			System.out.println("something went wrong");
	}
}
	

	
