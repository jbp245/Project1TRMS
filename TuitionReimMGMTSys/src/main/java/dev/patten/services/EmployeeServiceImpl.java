/**
 * 
 */
package dev.patten.services;

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

	@Override
	public boolean submitForm() {
		return false;
	}
	
	
}
