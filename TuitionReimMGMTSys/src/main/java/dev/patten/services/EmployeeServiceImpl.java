/**
 * 
 */
package dev.patten.services;

import java.util.ArrayList;
import java.util.List;

import dev.patten.entities.Employee;
import dev.patten.repositories.CRUDable;
import dev.patten.repositories.EmployeeDAOimpl;

/**
 * @author james
 *
 */
public class EmployeeServiceImpl implements EmployeeService {

	// source>override>all once employee service fleshed out
	public CRUDable<Employee> dao = new EmployeeDAOimpl();
	
	@Override
	public boolean add(Employee record) {
		return dao.add(record);
	}

	@Override
	public boolean update(Employee change) {
		return dao.update(change);
	}

	@Override
	public boolean delete(int id) {
		return dao.delete(id);
	}

	@Override
	public Employee get(int id) {
		return dao.get(id);
	}

	@Override
	public List<Employee> getAll() {
		return dao.getAll();
	}


	//LoginController
	@Override
	public Employee login(String username, String password) {
		List<Employee> all = this.getAll();
		
		for (Employee element: all) {
			if ((element.getUsername().equals(username)) && (element.getPassword().equals(password))) {
				System.out.println("Login Successful! Welcome: " + element.getFirst_name() + " " + element.getLast_name());
				return element;
				}
		}
		System.out.println("Login Unsuccessful");
		return null;
	}

	//not used
	//LoginController
	@Override
	public boolean logout() {
		return true;
	}
	
	//EmployeeController - used update afterall
	@Override
	public boolean adjustAwardAvail(double change) {
		
		return false;
	}
	
	//EmployeeController
	public Employee getByUsername(String username) {
		List<Employee> all = this.getAll();
		
		for (Employee element: all) {
			if ((element.getUsername().equals(username))) {
				System.out.println(element.toString());
				return element;
				}
		}
		return null;
	}

	// TODO unfinished, unsure where to really put
	@Override
	public List<Employee> getAllUnder(Employee subject) {
		List<Employee> employees = getAll();
		List<Employee> temp = new ArrayList<Employee>();
		//test works for pam
		//System.out.println("called in service impl " + employees.toString());
		//System.out.println(subject.getRole_id() + " role id");
		if (subject.getRole_id() == (4)) { System.out.println("testing BenCo(Pam)"); return employees; }
		if (subject.getRole_id() == (1)) { 
			System.out.println("testing CEO(Ryan)"); 
			for (Employee element: employees) {
				if (element.getRole_id() != 1) { temp.add(element); }
			}
			return temp;
		} 
		
		if (subject.getId() == (5)) { 
			System.out.println("testing VP(Toby)"); 
			for (Employee element: employees) {
				if (element.getRole_id() == 4) { temp.add(element); }
			}
			return temp;
		} 
		if (subject.getId() == (4)) { 
			System.out.println("testing VP(Toby)"); 
			for (Employee element: employees) {
				if (5 < element.getId()) { temp.add(element); }
			}
			return temp;
		} else {
			for (Employee element: employees) {
				if (subject.getId() < element.getId()) { temp.add(element); }
			}
		}
		return temp;
	}

	@Override
	public List<Employee> getAllAbove(Employee subject, List<Employee> employees) {
		// TODO Auto-generated method stub
		return null;
	}
}
