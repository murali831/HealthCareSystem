package com.cg.entity;

import java.util.ArrayList;
import java.util.List;

public class DiagnosticTest {
	// STATE
	private String testName;
	private String testId;
	private Integer price;
	List<TestSlot> testSlotList = new ArrayList<TestSlot>();

	// Constructor
	public DiagnosticTest(String testName, String testId, Integer price) {
		super();
		this.testName = testName;
		this.testId = testId;
		this.price = price;
		
	}
	//No ArgumentConstructor
	public DiagnosticTest() {
		super();
	}
	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	public List<TestSlot> getTestSlotList() {
		return testSlotList;
	}
	public void setTestSlotList(List<TestSlot> testSlotList) {
		this.testSlotList = testSlotList;
	}
	@Override
	public String toString() {
		return "testnamee="+testName + ", testId=" + testId + ", price=" + price ;
	}
	

}
