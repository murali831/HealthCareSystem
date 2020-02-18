package com.cg.service;

import java.util.Map;

import com.cg.entity.DiagnosticTest;
import com.cg.entity.TestSlot;
import com.cg.entity.DiagnosticCenter;
import com.cg.exception.DiagnosticException;
import com.cg.exception.ValidateException;

public interface HealthCareService {
	public boolean addDiagnosticCentre(DiagnosticCenter centre) throws ValidateException;

	public boolean addTest(String centreId, DiagnosticTest test) throws DiagnosticException, ValidateException;
	
	public boolean addTestSlot(String centreId, String TestId, TestSlot testSlotId) throws DiagnosticException;

	public Map<String, DiagnosticCenter> getCentres();

}