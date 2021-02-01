/**
 * 
 */
package dev.patten.services;

import dev.patten.entities.Employee;

/**
 * @author james
 * Custom Service impl for Employee entity business logic; guarantees CRUD calls to respective DAO impl.
 */
public interface EmployeeService extends Serviceable<Employee> {

	boolean submitForm();
	
}
