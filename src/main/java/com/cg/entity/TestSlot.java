package com.cg.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestSlot {
	private String testSlotId; 
	private DiagnosticTest testId;
	private LocalDate date;
	private Integer maxAppointments;
	private List<Appointment> listOfAppointments = new ArrayList<>();

	// Constructor
	public TestSlot(String testSlotId, DiagnosticTest testId, LocalDate date, Integer maxAppointments) {
		super();
		this.testSlotId = testSlotId;
		this.testId = testId;
		this.date = date;
		this.maxAppointments = maxAppointments;
	}
    //No ArgumentConstructor
	public TestSlot() {
		super();
	}
	public String getTestSlotId() {
		return testSlotId;
	}

	public void setTestSlotId(String testSlotId) {
		this.testSlotId = testSlotId;
	}

	public DiagnosticTest getTestId() {
		return testId;
	}

	public void setTestId(DiagnosticTest testId) {
		this.testId = testId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getMaxAppointments() {
		return maxAppointments;
	}

	public void setMaxAppointments(Integer maxAppointments) {
		this.maxAppointments = maxAppointments;
	}

	public List<Appointment> getListOfAppointments() {
		return listOfAppointments;
	}

	public void setListOfAppointments(List<Appointment> listOfAppointments) {
		this.listOfAppointments = listOfAppointments;
	}

	@Override
	public String toString() {
		return "testSlotId=" + testSlotId + ", testId=" + testId + ", date=" + date + ", maxApp="
				+ maxAppointments ;
	}

}
