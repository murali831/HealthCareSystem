package com.cg.service;

import java.util.Map;
import com.cg.dao.HealthCareDao;
import com.cg.dao.HealthCareDaoImp;
import com.cg.entity.DiagnosticCenter;
import com.cg.entity.DiagnosticTest;
import com.cg.exception.DiagnosticException;
import com.cg.exception.ValidateException;

public class HealthCareServiceImpl implements HealthCareService {

	private HealthCareDao dao = new HealthCareDaoImp();
	/*
	 * @author Kandula Murali Ramesh
	 * 
	 * Description: The method  mentioned below adds the diagnostic center based on the
	 *              Diagnostic Center instance and adds that center into a Map<String,DiagnosticCenter>.
	 *              
	 * Method: addDiagnosticCentre() - Add DiagnosticCenter method add the center into Collection<Map> using the
	 *                   Diagnostic center instance as a parameter and validates the centerId if it is not in proper format
	 *                   (Example "HYD1001") and puts that center into the collection<Map> of diagnostic Center.
	 *                     
	 * @return type is boolean
	 * 
	 * @throws ValidateException: While entering the centerId using instance if the centerId is no according
	 *                            to the format First 3 characters are alphabets and next 4 characters are 
	 *                            Number(Example-HYD1001,Kmm1002) then Validate exception rises. 
	 */
	@Override
	public boolean addDiagnosticCentre(DiagnosticCenter centre) throws ValidateException {
		// validating the diagnostic CentreId
		if (validateCenter(centre)) {
			return dao.addCentre(centre);
		}
		return false;

	}
	/*
	 * @author Kandula Murali Ramesh
	 * 
	 * Description: The method mentioned below adds the tests based on the
	 *              Diagnostic Test instance and centerId and adds that test into a listOfTest <List> .
	 *              
	 * Method: addTest()- Add Test method add the Test into Diagnostic center attribute listOfTest<List> using the
	 *                     centerId as parameter and validates the TestId if it is not in proper format
	 *                   (Example "BST") and add that test into the listOfTests<list> of that particular diagnostic Center centerId.
	 *                     
	 * @return type is boolean
	 * 
	 * @throws ValidateException: While entering the testId using instance if the centerId is no according
	 *                            to the format First 3 characters are alphabets and next 4 characters are 
	 *                            Number(Example-HYD1001,Kmm1002) or the testId is no according to format
	 *                            (Example="BST") then Validate exception rises. 
	 */
	@Override
	public boolean addTest(String centreId, DiagnosticTest test) throws DiagnosticException, ValidateException {
		if (validateTest(test)) {
			DiagnosticCenter centre = dao.viewDiagnosticCenter(centreId);
			dao.addTest(centre, test);
			return true;
		}
		return false;
	}
	/*
	 * @author Kandula Murali Ramesh
	 * 
	 * Description: The method mentioned below is used to print all the keys and values in Collection<Map>
	 *              
	 * Method: getCentres()- it return the elements that are present in Collection<Map>
	 *                     
	 * @return type is Map<String,DiagnosticCenter>
	 * 
	 */
	@Override
	public Map<String, DiagnosticCenter> getCentres() {

		return dao.getCentres();
	}
	/*
	 * @author Kandula Murali Ramesh
	 * 
	 * Description: The method mentioned below is used for validating the user inputed centerId and testId.
	 * 
	 * Method: validateCenter()-This method is for validating the centerID if it is no according to format throws and ValidateException;
	 *                           else true
	 * Method: validateTest()- This method is for validating the testID if it is no according to format throws and ValidateException;
	 *                           else true
	 * @return type is boolean
	 * 
	 */
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
