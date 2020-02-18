package demo.MavenDemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.cg.entity.DiagnosticCenter;
import com.cg.entity.DiagnosticTest;
import com.cg.exception.DiagnosticException;
import com.cg.exception.ValidateException;
import com.cg.service.HealthCareService;
import com.cg.service.HealthCareServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)
public class HospitalTests {
	static HealthCareService ser;

	@BeforeAll
	public static void beforeAll() {
		System.out.println("beforeall");

		ser = new HealthCareServiceImpl();
		DiagnosticCenter centre = new DiagnosticCenter("HYD1001", "Murali Diagnostics");
		try {
			ser.addDiagnosticCentre(centre);
		} catch (ValidateException e) {
			e.printStackTrace();
		}

	}

	@Test
	@DisplayName("Test case 1")
	public void testcase1() throws ValidateException, DiagnosticException {
		DiagnosticTest test1 = new DiagnosticTest("Complete blood count", "CBC", 600);
		System.out.println(ser);
		assertTrue(ser.addTest("HYD1001", test1));
	}

	@Test
	@DisplayName("Test case 2")
	public void testcase2() throws ValidateException, DiagnosticException {
		DiagnosticTest test2 = new DiagnosticTest("Liver functioning Test", "LFT", 1600);
		assertTrue(ser.addTest("HYD1001", test2));
	}

	@Test
	@DisplayName("Test case 3")
	public void testcase3() throws ValidateException, DiagnosticException {
		DiagnosticTest test3 = new DiagnosticTest("Blood Sugar Test", "BST", 300);
		assertTrue(ser.addTest("HYD1001", test3));
	}

	@Test
	@DisplayName("Test case 4")
	public void testcase4() throws ValidateException, DiagnosticException {

		DiagnosticTest test3 = new DiagnosticTest("City Themoscophy Scan", "CTTS", 300);
		assertThrows(ValidateException.class, () -> assertTrue(ser.addTest("HYD1001", test3)));
	}

	@Test
	@DisplayName("Test case 5")
	public void testcase5() throws ValidateException, DiagnosticException {

		DiagnosticTest test3 = new DiagnosticTest("Blood Sugar Test", "BST", 300);
		assertThrows(DiagnosticException.class, () -> assertTrue(ser.addTest("VZD1001", test3)));
	}

}
