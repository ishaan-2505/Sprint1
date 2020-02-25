package com.capgemini.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.dao.Dao;
import com.capgemini.dao.DaoImpl;

public class DaoImplTest {
	Dao dao;
	@Before
	public void setUp() throws Exception {
		dao=new DaoImpl();
	}

	@After
	
	public void tearDown() throws Exception {
		dao=null;
	}

	@Test
	public void testCredit() throws SQLException{
		assertTrue(dao.credit("123456",1500.00));
	}

	@Test
	public void testDebit() throws SQLException {
		assertTrue(dao.debit("1486973", 1000.00));
	}


}
