package com.cg.dao;

import java.util.Map;

import com.cg.entity.DiagnosticTest;
import com.cg.entity.DiagnosticCenter;
import com.cg.exception.DiagnosticException;

public interface HealthCareDao {
	/**
	 * In addCenter()-We add the center into centers Map if no center was already present with that centerId.
	 * 
	 * viewDiagnosticCenter()-Here we are having the centers Collection<Map> if center is available then returns that 
	 *                        else throws an DiagnosticException "Center Not Found!!!!" 
	 *                       
	 * addTest()-Here we are adding tests to center based on the centerId and centerTest instance.And throws 
	 *           ValidateException id testId is not according to format(Example-"BST"),DiagnosticException if
	 *           user input centerId is not present in the map.
	 * 
	 * getCentres()-We are returning the Collection<Map> of centers.
	 */
	public boolean addCentre(DiagnosticCenter center);

	public boolean addTest(DiagnosticCenter centre, DiagnosticTest test);

	public DiagnosticCenter viewDiagnosticCenter(String centreId) throws DiagnosticException;

	public Map<String, DiagnosticCenter> getCentres();

}
