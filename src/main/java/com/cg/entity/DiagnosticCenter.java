package com.cg.entity;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class DiagnosticCenter {
	// STATE
	private String centerName;
	private String centerId;
	private List<DiagnosticTest> listOfTests = new ArrayList<>();
	Map<String, String> clistCenter = new Hashtable<>();


	public DiagnosticCenter(String centerId,String centerName ) {
		super();
		this.centerName = centerName;
		this.centerId = centerId;
	}
	// No Argument Constructor
	public DiagnosticCenter() {
		super();
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterId() {
		return centerId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	public List<DiagnosticTest> getListOfTests() {
		return listOfTests;
	}

	public void setListOfTests(List<DiagnosticTest> listOfTests) {
		this.listOfTests = listOfTests;
	}
	@Override
	public String toString() {
		return centerId + " " + centerName;
	}
}
