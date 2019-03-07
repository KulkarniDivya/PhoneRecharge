package com.cg.mra.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.mra.beans.Account;

public class AccountDaoImpl implements AccountDao {
	Map<String,Account> accountEntry;
	
	public AccountDaoImpl() {
		// TODO Auto-generated constructor stub
		accountEntry = new HashMap<>();
		accountEntry.put("9010210131", new Account("Prepaid","Vaishali",200));
		accountEntry.put("9823920123", new Account("Prepaid","Megha",453));
		accountEntry.put("9932012345", new Account("Prepaid","Vikas",631));
		accountEntry.put("9010210132", new Account("Prepaid","Anju",521));
		accountEntry.put("9010210133", new Account("Prepaid","Tushar",632));
	}
	@Override
	public Account getAccountDetails(String mobileNo) {
		// TODO Auto-generated method stub
		Account user = null; 
		for(Map.Entry<String, Account> m : accountEntry.entrySet())
		{
			if(m.getKey().equals(mobileNo))
			{
				user = m.getValue();
			}
		}
		
		return user;
	}

	@Override
	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		// TODO Auto-generated method stub
		Account user = null;
		//int n = 0;
		for(Map.Entry<String, Account> m : accountEntry.entrySet())
		{
			if(m.getKey().equals(mobileNo))
			{
				user = m.getValue();
			
			}
		}
		if(user != null)
		{
			rechargeAmount = rechargeAmount+user.getAccountBalance();
			user.setAccountBalance(rechargeAmount);
			accountEntry.put(mobileNo, user);
		}
		
		return (int)rechargeAmount;
	}

}
