package org.test;

import java.util.List;

public class C1 {

	private int compId;
	private String companyName;
	private long mobileNumber;
	private List<C2> employees;

//	public C1(int compId, String companyName, long mobileNumber, List<C2> employees) {
//
//		this.compId = compId;
//		this.companyName = companyName;
//		this.mobileNumber = mobileNumber;
//		this.employees = employees;
//	}
//	

	public int getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public List<C2> getEmployees() {
		return employees;
	}

	public void setEmployees(List<C2> employees) {
		this.employees = employees;
	}

}
