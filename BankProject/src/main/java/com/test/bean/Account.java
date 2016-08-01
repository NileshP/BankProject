package com.test.bean;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class Account {

	private String acctId;
	private String acctName;
	private String acctType;
	private String acctBranch;
	
	public Account(){
		
		
	}
	
	public String getAcctId() {
		return acctId;
	}
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	public String getAcctName() {
		return acctName;
	}
	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}
	public String getAcctType() {
		return acctType;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public String getAcctBranch() {
		return acctBranch;
	}
	public void setAcctBranch(String acctBranch) {
		this.acctBranch = acctBranch;
	}
	
}
