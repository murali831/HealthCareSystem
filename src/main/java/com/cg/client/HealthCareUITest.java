package com.cg.client;


import java.util.Map;

import com.cg.entity.DiagnosticCenter;
import com.cg.entity.DiagnosticTest;
import com.cg.exception.DiagnosticException;
import com.cg.exception.ValidateException;
import com.cg.service.HealthCareService;
import com.cg.service.HealthCareServiceImpl;

public class HealthCareUITest {
	static HealthCareService ser = new HealthCareServiceImpl();
	public static void main(String[] args) {
		try {
			DiagnosticTest test1 = new DiagnosticTest("Complete blood count", "CBC", 600);
			ser.addTest("HYD1001", test1);
			
			DiagnosticTest test2 = new DiagnosticTest("Liver functioning Test", "LFT", 1600);
			ser.addTest("HYD1001", test2);
			
			Map<String, DiagnosticCenter> map = ser.getCentres();
			map.values().forEach(c->{System.out.println(c);
			             c.getListOfTests().forEach(t->{System.out.println(t);});
			             });
	        }catch(ValidateException ex) {
	        	System.out.println(ex.getMessage());
	        }catch(DiagnosticException ex) {
	        	System.out.println(ex.getMessage());
	        }
	}
}
