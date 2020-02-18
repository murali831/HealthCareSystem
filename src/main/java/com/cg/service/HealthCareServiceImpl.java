package com.cg.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cg.entity.TestSlot;
import com.cg.dao.HealthCareDao;
import com.cg.dao.HealthCareDaoImp;
import com.cg.entity.DiagnosticCenter;
import com.cg.entity.DiagnosticTest;
import com.cg.exception.DiagnosticException;
import com.cg.exception.ValidateException;

public class HealthCareServiceImpl implements HealthCareService {

	private HealthCareDao dao = new HealthCareDaoImp();

	@Override
	public boolean addDiagnosticCentre(DiagnosticCenter centre) throws ValidateException {
		// validating the diagnostic CentreId
		if (validateCenter(centre)) {
			return dao.addCentre(centre);
		}
		return false;

	}

	@Override
	public boolean addTest(String centreId, DiagnosticTest test) throws DiagnosticException, ValidateException {
		if (validateTest(test)) {
			DiagnosticCenter centre = dao.viewDiagnosticCenter(centreId);
			dao.addTest(centre, test);
			return true;
		}
		return false;
	}

	@Override
	public boolean addTestSlot(String centreId, String testId, TestSlot testSlotId) throws DiagnosticException {
		DiagnosticCenter centre = dao.viewDiagnosticCenter(centreId);
		List<DiagnosticTest> list = centre.getListOfTests().stream().filter(dtest -> dtest.getTestId() == testId)
				.collect(Collectors.toList());
		if (list.isEmpty())
			throw new DiagnosticException("No Test At present");
		DiagnosticTest test = list.get(0);
		dao.addTestSlot(test, testSlotId);
		return true;
	}

	@Override
	public Map<String, DiagnosticCenter> getCentres() {

		return dao.getCentres();
	}

	public boolean validateCenter(DiagnosticCenter cent) throws ValidateException {
		if (!cent.getCenterId().matches("[a-zA-Z]{3}[0-9]{4}"))
			throw new ValidateException("First Three Character should be alphabet and rest 4 numbers");
		return true;
	}

	public boolean validateTest(DiagnosticTest test) throws ValidateException {
		if (!test.getTestId().matches("[a-zA-Z]{3}"))
			throw new ValidateException("First Three Character should be alphabet and rest 4 numbers");
		return true;
	}

}
