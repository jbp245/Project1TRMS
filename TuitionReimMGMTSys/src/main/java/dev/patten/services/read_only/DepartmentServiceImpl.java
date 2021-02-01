/**
 * 
 */
package dev.patten.services.read_only;

import java.util.List;

import dev.patten.entities.Department;
import dev.patten.repositories.DepartmentDAOimpl;
import dev.patten.repositories.READable;

/**
 * @author james
 *
 */
public class DepartmentServiceImpl implements ServiceREADable<Department> {

	public READable<Department> dao = new DepartmentDAOimpl();
	
	@Override
	public Department get(int id) {
		return dao.get(id);
	}

	@Override
	public List<Department> getAll() {
		return dao.getAll();
	}

}
