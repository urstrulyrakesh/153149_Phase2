package com.cg.mypaymentapp.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.service.WalletService;
import com.cg.mypaymentapp.service.WalletServiceImpl;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.service.WalletService;
import com.cg.mypaymentapp.service.WalletServiceImpl;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.exception.InvalidInputException;
public class TestClass {

WalletService service;
{
service= new WalletServiceImpl();
}
Customer cust1,cust2,cust3;
	@Before
	public void initData(){
		 Map<String,Customer> data= new HashMap<String, Customer>();
		 Customer cust1=new Customer("Amit", "9900112212",new Wallet(new BigDecimal(9000)));
		 Customer cust2=new Customer("Ajay", "9963242422",new Wallet(new BigDecimal(6000)));
		 Customer cust3=new Customer("Yogini", "9922950519",new Wallet(new BigDecimal(7000)));
				
		 data.put("9900112212", cust1);
		 data.put("9963242422", cust2);	
		 data.put("9922950519", cust3);	
		
			
			
	}
	@Test
	public void inittData(){
		 Map<String,Customer> data= new HashMap<String, Customer>();
		 Customer cust1=new Customer("Amit", "9900112212",new Wallet(new BigDecimal(9000)));
		 data.put("9900112212", cust1);	
		 service= new WalletServiceImpl();
		 //service.createAccount(cust1.getName(), cust1.getMobileNo(), cust1.getWallet());
			assertEquals(cust1.getName(),"Amit");
	}
	
	@Test 
	public void TestData(){
		 Map<String,Customer> data= new HashMap<String, Customer>();
		 Customer cust2=new Customer("Ajay", "9963242422",new Wallet(new BigDecimal(6000)));
		 data.put("9963242422", cust2);	
		 service= new WalletServiceImpl();
		 //service.createAccount(cust1.getName(), cust1.getMobileNo(), cust1.getWallet());
			assertEquals(cust2.getMobileNo(),"9963242422");
	}
	
	@Test
	public void TestData1(){
		 Map<String,Customer> data= new HashMap<String, Customer>();
		 Customer cust3=new Customer("Yogini", "9922950519",new Wallet(new BigDecimal(7000)));
		 data.put("9922950519", cust3);	;	
		 service= new WalletServiceImpl();
		 
			Wallet w = cust3.getWallet();
			BigDecimal bd = w.getBalance();
			
		 assertEquals(bd, new BigDecimal(7000));
	}
	
	@Test
	public void TestData2(){
		Map<String,Customer> data= new HashMap<String, Customer>();
		Customer cust3=new Customer("Yogini", "9922950519",new Wallet(new BigDecimal(7000)));
	}

	
	@Test 
	public void TestData3(){
		 Map<String,Customer> data= new HashMap<String, Customer>();
		 Customer cust2=new Customer("Ajay", "9963242422",new Wallet(new BigDecimal(6000)));
		 data.put("9963242422", cust2);	
		 service= new WalletServiceImpl();
		 //service.createAccount(cust1.getName(), cust1.getMobileNo(), cust1.getWallet());
			assertNotNull(cust2.getMobileNo());
	}
	
	@Test 
	public void TestData4(){
		 Map<String,Customer> data= new HashMap<String, Customer>();
		 Customer cust2=new Customer("Ajay", null,new Wallet(new BigDecimal(6000)));
		 data.put("9963242422", cust2);	
		 service= new WalletServiceImpl();
		 //service.createAccount(cust1.getName(), cust1.getMobileNo(), cust1.getWallet());
			assertNull(cust2.getMobileNo());
	}
	
	@Test
	public void TestData5(){
		 Map<String,Customer> data= new HashMap<String, Customer>();
		 Customer cust3=new Customer("Yoni", "9922950519",new Wallet(new BigDecimal(9000)));
		 data.put("9922950519", cust3);	;	
		 service= new WalletServiceImpl();
		 
			Wallet w = cust3.getWallet();
			BigDecimal bd = w.getBalance();
			
		 assertEquals(bd, new BigDecimal(9000));
	}
	
	@Test 
	public void TestData6(){
		 Map<String,Customer> data= new HashMap<String, Customer>();
		 Customer cust2=new Customer(null, null,new Wallet(new BigDecimal(6000)));
		 data.put("9963242422", cust2);	
		 service= new WalletServiceImpl();
		 //service.createAccount(cust1.getName(), cust1.getMobileNo(), cust1.getWallet());
			assertNull(cust2.getName());
	}
	@Test(expected = InvalidInputException.class)
	public void TestData10()
	{
		service.showBalance("9056456454");
	}
	@Test 
	public void TestData7(){
		 Map<String,Customer> data= new HashMap<String, Customer>();
		 Customer cust2=new Customer("Rakesh", null,new Wallet(new BigDecimal(6000)));
		 data.put("9963242422", cust2);	
		 service= new WalletServiceImpl();
		 //service.createAccount(cust1.getName(), cust1.getMobileNo(), cust1.getWallet());
			assertNotNull(cust2.getName());
	}
	@Test
	public void TestData8(){
		 Map<String,Customer> data= new HashMap<String, Customer>();
		 Customer cust3=new Customer("Yoni", "9922950519",new Wallet(null));
		 data.put("9922950519", cust3);	;	
		 service= new WalletServiceImpl();
		 
			Wallet w = cust3.getWallet();
			BigDecimal bd = w.getBalance();
			
		 assertNull(bd);
	}
	@Test(expected = InvalidInputException.class)
	public void TestData9()
	{
		service.showBalance("9000000000");
	}
	@Test
	public void TestData11(){
		Map<String,Customer> data= new HashMap<String, Customer>();
		Customer cust3=new Customer("Sangu", "9976950519",new Wallet(new BigDecimal(17000)));
	}
	@Test 
	public void TestData12(){
		 Map<String,Customer> data= new HashMap<String, Customer>();
		 Customer cust2=new Customer("Mani", "9955642422",new Wallet(new BigDecimal(16000)));
		 data.put("9955642422", cust2);	
		 service= new WalletServiceImpl();
		 //service.createAccount(cust1.getName(), cust1.getMobileNo(), cust1.getWallet());
			assertEquals(cust2.getMobileNo(),"9955642422");
	}
	

	@Test 
	public void TestData13(){
		 Map<String,Customer> data= new HashMap<String, Customer>();
		 Customer cust2=new Customer("Narasimha", "9963242121",new Wallet(new BigDecimal(6000)));
		 data.put("9963242121", cust2);	
		 service= new WalletServiceImpl();
		 //service.createAccount(cust1.getName(), cust1.getMobileNo(), cust1.getWallet());
			assertNotNull(cust2.getMobileNo());
	}
	
}
