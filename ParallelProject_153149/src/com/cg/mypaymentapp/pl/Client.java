package com.cg.mypaymentapp.pl;

import java.math.BigDecimal;
import java.util.Scanner;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.service.WalletService;
import com.cg.mypaymentapp.service.WalletServiceImpl;

public class Client {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		WalletService service;
		{
			service = new WalletServiceImpl();
		}
		String ans;
		do{
		System.out.println("****Welcome to XYZ Bank****");
		System.out.println("\t\tMenu");
		System.out.println("\t\t-----");
		System.out.println("1. Create Account");
		System.out.println("2. Show Balance");
		System.out.println("3. Deposit");
		System.out.println("4. Withdraw");
		System.out.println("5. Fund Transfer");
		System.out.println("6. Quit");
		System.out.println("\nSelect an Option!");
		System.out.println("Enter Your Option : ");
		int opt=sc.nextInt();
		switch(opt){
		case 1:
			System.out.println("Enter Your Name : ");
			String name = sc.next();
			System.out.println("Enter your Mobile Number : ");
			String number = sc.next();
			System.out.println("Enter Amount You Want To Deposit : ");
			BigDecimal amt = sc.nextBigDecimal();
			Customer cs = service.createAccount(name ,number,amt);
			
			System.out.println("Your Account Created With User Id " + cs.getMobileNo());
			break;
		case 2:
			System.out.println("Enter Your Mobile Number : ");
			String Mobile = sc.next();
			Customer ShowDetails = service.showBalance(Mobile);
			System.out.println("Wallet Number : " + ShowDetails.getMobileNo());
			System.out.println("Name : "+ ShowDetails.getName());
			System.out.println("Balance :" +ShowDetails.getWallet());
			break;
		case 3:
			System.out.println("Enter Your Mobile Number : ");
			String PhNo = sc.next();
			System.out.println("Enter Amount you want to deposit : ");
			BigDecimal amount = sc.nextBigDecimal();
			Customer Deposit = service.depositAmount(PhNo, amount);
			System.out.println("Wallet Number : " + Deposit.getMobileNo());
			System.out.println("Name : " + Deposit.getName());
			System.out.println("Amount Deposited : " + amount);
			System.out.println("Updated Balance : " + Deposit.getWallet());
			break;
		case 4:
			System.out.println("Enter Your Mobile Number : ");
			String Mno = sc.next();
			System.out.println("Enter Amount You Want to withdraw : ");
			BigDecimal withdrawamt = sc.nextBigDecimal();
			Customer Withdraw = service.withdrawAmount(Mno, withdrawamt);
			System.out.println("Wallet Number : " + Withdraw.getMobileNo());
			System.out.println("Name : " + Withdraw.getName());
			System.out.println("Amount Deposited : " + withdrawamt);
			System.out.println("Updated Balance : " + Withdraw.getWallet());
			break;
		case 5:
			System.out.println("Enter Your Mobile Number : ");
			String srcno = sc.next();
			System.out.println("Enter Mobile Number You want to Transfer : ");
			String trgno = sc.next();
			System.out.println("Enter Amount you Want To Tranfer : ");
			BigDecimal tranferAmt = sc.nextBigDecimal();
			Customer fundTransfer = service.fundTransfer(srcno, trgno, tranferAmt);
			System.out.println("Transaction Successful !");
			System.out.println("Wallet Number : " + fundTransfer.getMobileNo());
			System.out.println("Name : " + fundTransfer.getName());
			System.out.println("Amount Transfered : " + tranferAmt);
			System.out.println("Updated Balance : " + fundTransfer.getWallet());
			
			break;
		case 6:
			System.out.println("Thank You For Using XYZ Bank Serivces!");
			return;
		default:
			System.out.println("Invalid Option!\nTransaction Aborted");
		}
		System.out.println("Do You Want to Continue?");
		ans = sc.next();
		}while(ans.equals("yes") || ans.equals("yes") || ans.equals("Y") || ans.equals("y") );
	}
}
