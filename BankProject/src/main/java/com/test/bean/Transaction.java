package com.test.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Transaction {

	
	private String transId;
	private String transType;
	private String transDateTime;
	private long transAmount;
	
	public Transaction(){
		
		
	}
	
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public String getTransDateTime() {
		return transDateTime;
	}
	public void setTransDateTime(String transDateTime) {
		this.transDateTime = transDateTime;
	}

	public long getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(long transAmount) {
		this.transAmount = transAmount;
	}
	
}
