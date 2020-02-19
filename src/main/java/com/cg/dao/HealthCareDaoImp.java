package com.cg.dao;

import java.util.Map;
import com.cg.entity.DiagnosticTest;
import com.cg.client.CgRepo;
import com.cg.entity.DiagnosticCenter;
import com.cg.exception.DiagnosticException;

public class HealthCareDaoImp implements HealthCareDao {
	private Map<String, DiagnosticCenter> listofCenters = CgRepo.listcCenters;

	/*
	 * @author Kandula Murali Ramesh
	 * 
	 * Description: The method  mentioned below adds the diagnostic center based on the
	 *              Diagnostic Center instance and adds that center into a Map<String,DiagnosticCenter>.
	 *              
	 * Method: addCentre() - Add DiagnosticCenter method add the center into Collection<Map> using the
	 *                   Diagnostic center instance as a parameter if centerId already exits then it return false  
	 *                   else it throws an exception and put that centerId into the collection<Map> of diagnostic Center.
	 *                   
	 *                     
	 * @return type is boolean
	 * 
	 * @throws DiagnosticException:If centerId is not present then it throws an DiagnosticException and adds that centerId into the <Map>
	 *                             in catch block and return true.
	 */
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
	/*
	 * @author Kandula Murali Ramesh
	 * 
	 * Description: The method mentioned below adds the tests based on the
	 *              Diagnostic Test instance and centerId and adds that test into a listOfTest <List> .
	 *              
	 * Method: addTest()- Add Test method add the Test into Diagnostic center attribute listOfTest<List> using the
	 *                     centerId as parameter and firstly it checks the <Map> of centerID if found adds that test into the 
	 *                     listOfTests<list> of that particular diagnostic Center centerId.Else throws and DiagnosticException
	 *                     "Center not found!!!!!".
	 *                     
	 * @return type is boolean
	 * 
	 * @throws DiagnosticException: If centerId is not present then it throws an DiagnosticException and prints "Center not found!!!!".
	 */
	public boolean addTest(DiagnosticCenter centre, DiagnosticTest test) {
		centre.getListOfTests().add(test);
		return true;
	}
	/*
	 * @author Kandula Murali Ramesh
	 * 
	 * Description: The method mentioned below is check the keys and values in Collection<Map> for adding centerId and Tests into a center.
	 *              
	 * Method: viewDiagnosticCenter()- it checks the current centerId with <Map> datas and comapres if centerId is available then returns that 
	 *                        else throws an DiagnosticException.
	 *                        
	 * @return type is DiagnosticCenter
	 * 
	 * @throws DiagnosticException: If centerId is not present then it throws an DiagnosticException and prints "Center not found!!!!".
	 */
	public DiagnosticCenter viewDiagnosticCenter(String centreId) throws DiagnosticException {
		if (!listofCenters.containsKey(centreId))
			throw new DiagnosticException("No Center found !!!!");

		return listofCenters.get(centreId);
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

		return listofCenters;
	}

}
