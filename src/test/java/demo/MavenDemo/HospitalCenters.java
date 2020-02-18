package demo.MavenDemo;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cg.entity.DiagnosticCenter;
import com.cg.exception.ValidateException;
import com.cg.service.HealthCareService;
import com.cg.service.HealthCareServiceImpl;

public class HospitalCenters {
	@Test
	@DisplayName("Test case 1")
	public void testcase1() throws ValidateException {
		HealthCareService ser = new HealthCareServiceImpl();
		DiagnosticCenter centre = new DiagnosticCenter("HYD1001", "Murali Diagnostics");
		assertTrue(ser.addDiagnosticCentre(centre));
	}

	@Test
	@DisplayName("Test case 2")
	public void testcase2() throws ValidateException {
		HealthCareService ser = new HealthCareServiceImpl();
		DiagnosticCenter centre = new DiagnosticCenter("Kmm1001", "Apex Diagnostics");
		assertTrue(ser.addDiagnosticCentre(centre));
	}

	@Test
	@DisplayName("Test case 3")
	public void testcase3() throws ValidateException {
		HealthCareService ser = new HealthCareServiceImpl();
		DiagnosticCenter centre = new DiagnosticCenter("K1002", "srija Diagnostics");
		assertThrows(ValidateException.class, () -> ser.addDiagnosticCentre(centre));
	}

	@Test
	@DisplayName("Test case 4")
	public void testcase4() throws ValidateException {
		HealthCareService ser = new HealthCareServiceImpl();
		DiagnosticCenter centre = new DiagnosticCenter("KMM002", "srija Diagnostics");
		assertThrows(ValidateException.class, () -> ser.addDiagnosticCentre(centre));
	}

}
