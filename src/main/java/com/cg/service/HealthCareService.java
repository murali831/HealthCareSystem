package com.cg.service;

import java.util.Map;

import com.cg.entity.DiagnosticTest;
import com.cg.entity.DiagnosticCenter;
import com.cg.exception.DiagnosticException;
import com.cg.exception.ValidateException;

public interface HealthCareService {
	/**
	 * In addCenter()-We add the center into center Map if no center was already present with that centerId.And 
	 *               throw validateException if centerId was not  in format(Example-"HYD1001")
	 *
	 * addTest()-Here we are adding tests to center based on the centerId and centerTest instance.And throws 
	 *           ValidateException id testId is not according to format(Example-"BST"),DiagnosticException if
	 *           user input centerId is not present in the map. 
	 * 
	 * getCentres()-We are returning the Collection<Map> of centers.
	 */
	public boolean addDiagnosticCentre(DiagnosticCenter centre) throws ValidateException;

	public boolean addTest(String centreId, DiagnosticTest test) throws DiagnosticException, ValidateException;
	

	public Map<String, DiagnosticCenter> getCentres();

}