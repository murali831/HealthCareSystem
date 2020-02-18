package demo.MavenDemo;

import java.time.LocalDate;
import java.util.Map;


import com.cg.entity.DiagnosticCenter;
import com.cg.entity.DiagnosticTest;
import com.cg.entity.TestSlot;
import com.cg.exception.DiagnosticException;
import com.cg.service.HealthCareService;
import com.cg.service.HealthCareServiceImpl;

public class HealthCareUISlot {
	static HealthCareService ser = new HealthCareServiceImpl();
	public static void main(String[] args) {
		try {
			DiagnosticTest test1 = new DiagnosticTest("Complete blood count", "CBC", 600);
			DiagnosticTest test2 = new DiagnosticTest("Liver functioning Test", "LFT", 1600);
			TestSlot slot1 = new TestSlot("1", test1, LocalDate.of(2020, 2, 25), 10);
			ser.addTestSlot("HYD1001", "CBC", slot1);
			TestSlot slot2 = new TestSlot("1", test2, LocalDate.of(2020, 2, 25), 10);
			ser.addTestSlot("HYD1001", "LFT", slot2);
			Map<String, DiagnosticCenter> map = ser.getCentres();
			map.values().forEach(c->{System.out.println(c);
			             c.getListOfTests().forEach(t->{System.out.println(t);
			             t.getTestSlotList().forEach(slot->System.out.println(slot));
			             });
			});
	        }catch(DiagnosticException ex) {
	        	System.out.println(ex.getMessage());
	        }	 

	}

}
