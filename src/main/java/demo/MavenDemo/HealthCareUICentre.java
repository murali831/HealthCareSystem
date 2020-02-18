package demo.MavenDemo;
import java.util.Map;

import com.cg.entity.DiagnosticCenter;
import com.cg.exception.DiagnosticException;
import com.cg.exception.ValidateException;
import com.cg.service.HealthCareService;
import com.cg.service.HealthCareServiceImpl;


public class HealthCareUICentre {
	
	static HealthCareService ser = new HealthCareServiceImpl();
	public static void main(String[] args) throws DiagnosticException {
		try {
		DiagnosticCenter centre = new DiagnosticCenter();
		centre.setCenterId("HYD1001");
		centre.setCenterName("Padmavathi Diagnostic Cdentre");
		ser.addDiagnosticCentre(centre);	
		
		System.out.println("ceters after adding  1 center into map");
		ser.getCentres().values().forEach(System.out::println);
		
		//-------------------adding one more center--------------------------------------//
		centre.setCenterId("KMM1001");
		centre.setCenterName("Apex Diagnostic Cdentre");
		ser.addDiagnosticCentre(centre);
		
		System.out.println("ceters after adding 2 center into map");
		ser.getCentres().values().forEach(System.out::println);
		
		/*Map<String, DiagnosticCenter> map = ser.getCentres();
		map.values().forEach(c->{System.out.println(c);});*/
		}
		catch(ValidateException ex) {
			System.err.println(ex.getMessage());
		}
	}
}
