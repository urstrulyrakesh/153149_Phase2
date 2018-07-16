package com.cg.mypaymentapp.repo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;

public class WalletRepoImpl implements WalletRepo {
	Connection con;

	public WalletRepoImpl() {
		String url = "jdbc:mysql://localhost:3306/test";
		String uid = "root";
		String pwd = "corp123";
		try {
			this.con = DriverManager.getConnection(url, uid, pwd);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Map<String, Customer> data = new HashMap<String, Customer>();

	@Override
	public boolean save(Customer customer) {
		String query = "insert into customer(name,MobileNo,balance) values(?,?,?)";
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, customer.getName());
			psmt.setString(2, customer.getMobileNo());

			Wallet w1 = customer.getWallet();
			BigDecimal bal = w1.getBalance();
			psmt.setBigDecimal(3, bal);
			psmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data.put(customer.getMobileNo(), customer);
		// TODO Auto-generated method stub
		return true;
	}
	
	

	@Override
	public Customer findOne(String mobileNo) {
		// TODO Auto-generated method stub
		Customer e = null;
		String query = "select * from customer where mobileNo=?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, mobileNo);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				e = new Customer();
				e.setMobileNo(rs.getString(2));
				e.setName(rs.getString(1));

				Wallet wl = new Wallet();
				wl.setBalance(rs.getBigDecimal(3));
				e.setWallet(wl);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e;
		/*
		 * Customer cu1 = data.get(mobileNo); return cu1;
		 */
	}



	@Override
	public Customer update(Customer cu2) {
		// TODO Auto-generated method stub
		String query1 = "UPDATE customer SET balance= ? WHERE mobileNo=?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(query1);
			Wallet w1 = cu2.getWallet();
			BigDecimal bal = w1.getBalance();
			stmt.setBigDecimal(1, bal);
			stmt.setString(2, cu2.getMobileNo());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cu2;
	}
}
