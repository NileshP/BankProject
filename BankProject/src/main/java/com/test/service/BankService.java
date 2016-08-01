package com.test.service;

import com.test.bean.Account;
import com.test.bean.Statement;
import com.test.dao.BankDao;

public class BankService {

	BankDao bankDao;
	
	public BankService(){
		
		bankDao = BankDao.instance;
	}
	
	public Statement getStatementPagignated(String accountNumber,int startCount){
		
		return bankDao.getStatementPagignated(accountNumber, startCount);
	}
	
	public Statement getStatement(String accountNumber){
		
		return bankDao.getStatement(accountNumber);
	}

	public Account getAccountDeatilsFromAcctNumber(String accountNumber) {
		
		
		System.out.println("BankService GetAccountDetails called...");
		
		return bankDao.getAccountDeatilsFromAcctNumber(accountNumber);
		
		
	}

	public Account createNewAccount(String accountId, String name, String branch,
			String type) {
		
		return bankDao.createNewAccount(accountId,name,branch,type);
		
	}

	public Account deleteAccount(String accountNumber) {
		
		return bankDao.deleteAccount(accountNumber);
	}
	
}
