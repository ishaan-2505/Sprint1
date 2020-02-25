package com.capgemini.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.capgemini.exceptions.InsufficientBalance;
import com.capgemini.exceptions.InvalidAccount;
import com.capgemini.services.TransactionService;
import com.capgemini.services.TransactionServiceImpl;

public class TransactionUi {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String ch="yes";
		TransactionService service=null;
		
		try {
			service=new TransactionServiceImpl();
		}
		catch(SQLException e1) {
			System.err.println(e1.getMessage());
		}
		
		while(ch.equalsIgnoreCase("yes")) {
			System.out.println("***Select Operation***");
			System.out.println("1. Credit amount");
			System.out.println("2. Debit amount");
			
			int op=scanner.nextInt();
			switch(op) {
			case 1:
				try {
					service.creditAmount();
				}
				catch(SQLException | InvalidAccount e1) {
					//e1.printStackTrace();
					System.err.println(e1.getMessage());
				}
				break;
			
		case 2:
			try {
				service.debitAmount();
			}
			catch(SQLException | InsufficientBalance | InvalidAccount e2) {
				System.err.println(e2.getMessage());
				System.out.println(" ");
				//e2.printStackTrace();
			}
			break;
		default:
			break;
		}
		}
			System.out.println("Continue yes\\not");
			ch=scanner.next();
		}
	}


