package org.test;

public class TestData {

	private String name;
	private String job;

	// Along with these we need to generate constructor using fields

//	public TestData(String name, String job) {
//
//		this.name = name;
//		this.job = job;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
