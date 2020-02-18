package com.cg.dao;

import java.util.Map;

import com.cg.entity.DiagnosticTest;
import com.cg.entity.TestSlot;
import com.cg.entity.DiagnosticCenter;
import com.cg.exception.DiagnosticException;

public interface HealthCareDao {
	public boolean addCentre(DiagnosticCenter center);

	public boolean addTest(DiagnosticCenter centre, DiagnosticTest test);

	public boolean addTestSlot(DiagnosticTest test, TestSlot slot);

	public DiagnosticCenter viewDiagnosticCenter(String centreId) throws DiagnosticException;

	public Map<String, DiagnosticCenter> getCentres();

}
