package com.test.bean;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Statement {

	private String stmtId;
	private Date stmtDate;
	
	private List<Transaction> transactions;
	
	public Statement(){
		
		
	}
	
	public String getStmtId() {
		return stmtId;
	}
	public void setStmtId(String stmtId) {
		this.stmtId = stmtId;
	}
	public Date getStmtDate() {
		return stmtDate;
	}
	public void setStmtDate(Date stmtDate) {
		this.stmtDate = stmtDate;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
}
