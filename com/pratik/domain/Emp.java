package com.pratik.domain;

public class Emp {
private int accno;
private int version;
private String holdername;
private String acctype;
private float balance;

public Emp() {
	super();
	System.out.println("\t\t***WELCOME TO AXIS BANK***");
}

public int getAccno() {
	return accno;
}
public void setAccno(int accno) {
	this.accno = accno;
}

public int getVersion() {
	return version;
}
public void setVersion(int version) {
	this.version = version;
}

public String getHoldername() {
	return holdername;
}
public void setHoldername(String holdername) {
	this.holdername = holdername;
}

public String getAcctype() {
	return acctype;
}
public void setAcctype(String acctype) {
	this.acctype = acctype;
}

public float getBalance() {
	return balance;
}
public void setBalance(float balance) {
	this.balance = balance;
}

@Override
public String toString() {
	return "Emp [accno=" + accno + ", version=" + version + ", holdername=" + holdername + ", acctype=" + acctype
			+ ", balance=" + balance + "]";
}



}
