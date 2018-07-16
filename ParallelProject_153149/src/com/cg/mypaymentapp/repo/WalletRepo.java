package com.cg.mypaymentapp.repo;

import java.math.BigDecimal;

import com.cg.mypaymentapp.beans.Customer;

public interface WalletRepo {

public boolean save(Customer customer);
	
	public Customer findOne(String mobileNo);

	

	public Customer update(Customer cu2);

	/*public Customer createAccount(String name, String mobileNo,
			BigDecimal amount);

	public Customer depositAmount(String mobileNo, BigDecimal amount);

	public Customer withdrawAmount(String mobileNo, BigDecimal amount);

	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo,
			BigDecimal amount);*/
}
