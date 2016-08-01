package com.test.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.test.bean.Account;
import com.test.bean.Statement;
import com.test.bean.Transaction;

public enum BankDao {

	instance;

	Map<String, Account> accounts = new HashMap<String, Account>();
	Map<String, List<Transaction>> transactions = new HashMap<String, List<Transaction>>();

	private BankDao() {

		Account account = new Account();
		account.setAcctId("123");
		account.setAcctBranch("SB ROAD");
		account.setAcctName("Rashmi");
		account.setAcctType("SAVING");

		accounts.put("123", account);
		
		List<Transaction> transactions = new ArrayList<Transaction>();
		
		for (int i = 0; i < 20; i++) {
			
			Transaction transaction = new Transaction();
			transaction.setTransId(new Date().getTime()+"");
			transaction.setTransDateTime(new Date()+"");
			transaction.setTransType("DEBIT");
			Random random = new Random();
			
			int amt = random.nextInt(100000);
			transaction.setTransAmount(amt);
			
			transactions.add(transaction);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		for (int i = 0; i < 20; i++) {
			
			Transaction transaction = new Transaction();
			transaction.setTransId(new Date().getTime()+"");
			transaction.setTransType("DEBIT");
			transaction.setTransDateTime(new Date()+"");
			Random random = new Random();
			
			int amt = random.nextInt(100000);
			transaction.setTransAmount(amt);
			
			transactions.add(transaction);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.transactions.put(account.getAcctId(), transactions);
		

	}

	public Statement getStatement(String accountNumber) {

		Account account = accounts.get(accountNumber);

		if (accounts.containsKey(accountNumber)) {

			List<Transaction> transactionsList = transactions
					.get(accountNumber);

			Statement statement = new Statement();
			statement.setStmtId(new Date().getTime() + "STMT");
			statement.setStmtDate(new Date());
			statement.setTransactions(transactionsList);

			return statement;

		} else {

			return null;
		}

	}

	public Statement getStatementPagignated(String accountNumber, int startCount) {

		// Account account = accounts.get(accountNumber);

		if (accounts.containsKey(accountNumber)) {
			List<Transaction> transactionsList = transactions
					.get(accountNumber);

			List<Transaction> pageTrasnsaction = transactionsList.subList(
					startCount, startCount + 10);

			Statement statement = new Statement();
			statement.setStmtId(new Date().getTime() + "STMT");
			statement.setStmtDate(new Date());
			statement.setTransactions(pageTrasnsaction);

			return statement;
		} else {
			return null;
		}

	}

	public Account getAccountDeatilsFromAcctNumber(String acctNumber) {

		if (accounts.containsKey(acctNumber)) {

			return accounts.get(acctNumber);

		} else {

			return null;
		}

	}

	public Account createNewAccount(String accountId, String name,
			String branch, String type) {

		if(accounts.containsKey(accountId)){
			
			return null;
			
		}else{
			
			Account account = new Account();
			account.setAcctId(accountId);
			account.setAcctName(name);
			account.setAcctBranch(branch);
			account.setAcctType(type);
	
			accounts.put(accountId, account);

		return account;
		}

	}

	public Account deleteAccount(String accountNumber) {

		if (transactions.containsKey(accountNumber)) {

			Account account = accounts.get(accountNumber);
			
			transactions.remove(accountNumber);
			accounts.remove(accountNumber);
			
			return account;
			
		}else{
			
			return null;
		}

		

	}

	// statement date in sorted order
	// statement date in date range
	// get all debit/credit details

}
