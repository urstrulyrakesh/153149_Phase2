package com.cg.mypaymentapp.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.repo.WalletRepo;
import com.cg.mypaymentapp.repo.WalletRepoImpl;

public class WalletServiceImpl implements WalletService {
	private Map<String, Customer> data = new HashMap<String, Customer>();
	Scanner sc = new Scanner(System.in);

	WalletRepo serviceDao;
	{
		serviceDao = new WalletRepoImpl();
	}

	public WalletServiceImpl() {
	}

	public Customer createAccount(String name, String mobileNo,
			BigDecimal amount) {

		try {
			if (validatePhone(mobileNo)) {
				Customer cu = new Customer(name, mobileNo, new Wallet(amount));
				serviceDao.save(cu);
				data.put(mobileNo, cu);
				return cu;
			} else {
				System.err.println("Invalid Phone Number!!");
				System.out.println("Enter Phone Number Again :");
				String newPh = sc.next();
				return createAccount(name, newPh, amount);

			}

		} catch (Exception e) {
			System.out.println("Invalid Inputs");
		}
		return null;
	}

	@Override
	public boolean validatePhone(String str) {
		String patterns = "[1-9][0-9]{9}";
		if (str.matches(patterns)) {
			return true;
		} else {
			return false;
		}
	}

	public Customer showBalance(String mobileNo) {
		Customer customer = serviceDao.findOne(mobileNo);
		if (customer != null)
			return customer;
		else
			throw new InvalidInputException("Invalid mobile no ");
	}

	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo,
			BigDecimal amount) {

		Customer cust1 = serviceDao.findOne(sourceMobileNo);
		Customer cust2 = serviceDao.findOne(targetMobileNo);
		try {

			Wallet wal1 = cust1.getWallet();
			Wallet wal2 = cust2.getWallet();
			BigDecimal bal1 = wal1.getBalance();
			BigDecimal bal2 = wal2.getBalance();
			BigDecimal upbal2 = bal1.subtract(amount);
			BigDecimal upbal3 = bal2.add(amount);
			cust1.setWallet(new Wallet(upbal2));
			cust2.setWallet(new Wallet(upbal3));
			Customer cus1 = serviceDao.update(cust1);
			Customer cus2 = serviceDao.update(cust2);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new InsufficientBalanceException("Insufficient Balance! " + e);
		}
		return cust1;
	}

	public Customer depositAmount(String mobileNo, BigDecimal amount) {
		/*Customer cu2 = data.get(mobileNo)*/;
		Customer cu2 = serviceDao.findOne(mobileNo);
		Wallet w = cu2.getWallet();
		BigDecimal bal = w.getBalance();
		BigDecimal upbal = bal.add(amount);

		
		cu2.setWallet(new Wallet(upbal));
		Customer cus = serviceDao.update(cu2);
		return cu2;
	}

	public Customer withdrawAmount(String mobileNo, BigDecimal amount) {
		Customer cu3 =  serviceDao.findOne(mobileNo);
		Wallet w1 = cu3.getWallet();
		BigDecimal bal = w1.getBalance();
		BigDecimal upbal1 = bal.subtract(amount);

		cu3.setWallet(new Wallet(upbal1));
		Customer cus = serviceDao.update(cu3);
		return cu3;
		// TODO Auto-generated method stub
	}

}
