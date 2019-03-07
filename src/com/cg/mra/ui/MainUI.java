package com.cg.mra.ui;

import java.util.Scanner;

import com.cg.mra.beans.Account;
//import com.cg.mra.dao.AccountDao;
//import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class MainUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		AccountService as = new AccountServiceImpl();
		while(true)
		{
			System.out.println("Menu to Customer Care Representative to perform various operations");
			System.out.println("1) Account Balance Enquiry");
			System.out.println("2) Recharge Account");
			System.out.println("3) Exit");
			int n = sc.nextInt();
			switch(n)
			{
			case 1: System.out.println("Enter the mobile no");
					String mobileNo = sc.next();
					
					Account a = as.getAccountDetails(mobileNo);
					if(a != null)
						System.out.println("Your Current Balance is "+a.getAccountBalance());
					else
						System.out.println("Given account id doesn't exists");
			       break;
			case 2: System.out.println("Enter MobileNo:");
					String mobileNumber = sc.next();
	
					Account a1 = as.getAccountDetails(mobileNumber);
					if(a1 != null)
					{
						System.out.println("Enter Recharge Amount:");
						int amount = sc.nextInt();
						int balance = as.rechargeAccount(mobileNumber, amount);
						System.out.println("Your Account Recharged Successfully");
						System.out.println("Hello "+a1.getCustomerName()+",Available Balance is "+balance);
					}
					else
					{
						System.out.println("ERROR: Cannot Recharge Account as Given Mobile No Does Not Exists");
					}
					break;
			case 3: System.out.println("Thank You");
					System.exit(0);
			}
		}
	}

}
