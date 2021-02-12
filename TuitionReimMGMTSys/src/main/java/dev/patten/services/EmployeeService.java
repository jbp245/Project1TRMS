/**
 * 
 */
package dev.patten.services;

import java.util.List;

import dev.patten.entities.Employee;

/**
 * @author james
 * Custom Service impl for Employee entity business logic; guarantees CRUD calls to respective DAO impl.
 */
public interface EmployeeService extends Serviceable<Employee> {

	boolean adjustAwardAvail(double change);

	Employee login(String username, String password);
	
	boolean logout();
	
	Employee getByUsername(String username);
	
	List<Employee> getAllUnder(Employee subject);

	List<Employee> getAllAbove(Employee subject, List<Employee> employees);
}
