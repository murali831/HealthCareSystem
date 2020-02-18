package com.cg.dao;

import java.util.Map;

import com.cg.entity.TestSlot;
import com.cg.entity.DiagnosticTest;
import com.cg.client.CgRepo;
import com.cg.entity.DiagnosticCenter;
import com.cg.exception.DiagnosticException;

public class HealthCareDaoImp implements HealthCareDao {
	private Map<String, DiagnosticCenter> listofCenters = CgRepo.listcCenters;

	@Override
	public boolean addCentre(DiagnosticCenter centre) {
		try {
			DiagnosticCenter dcentre = viewDiagnosticCenter(centre.getCenterId());
			return false;
		} catch (DiagnosticException e) {
			listofCenters.put(centre.getCenterId(), centre);
		}
		
		return true;
	}
	public boolean addTest(DiagnosticCenter centre, DiagnosticTest test) {
		centre.getListOfTests().add(test);
		return true;
	}
	@Override
	public boolean addTestSlot(DiagnosticTest test, TestSlot slot) {
		test.getTestSlotList().add(slot);
		return true;
	}
	public DiagnosticCenter viewDiagnosticCenter(String centreId) throws DiagnosticException {
		if (!listofCenters.containsKey(centreId))
			throw new DiagnosticException("No Center found !!!!");

		return listofCenters.get(centreId);
	}

	@Override
	public Map<String, DiagnosticCenter> getCentres() {

		return listofCenters;
	}

}
