/**
 * 
 */
package dev.patten.services;

import java.util.List;

import dev.patten.entities.Form;
import dev.patten.repositories.CRUDable;
import dev.patten.repositories.FormDAOimpl;

/**
 * @author james
 *
 */
public class FormServiceImpl implements FormService {

	public CRUDable<Form> dao = new FormDAOimpl();
	
	@Override
	public boolean add(Form record) {
		return dao.add(record);
	}

	@Override
	public boolean update(Form change) {
		return dao.update(change);
	}

	@Override
	public boolean delete(int id) {
		return dao.delete(id);
	}

	@Override
	public Form get(int id) {
		return dao.get(id);
	}

	@Override
	public List<Form> getAll() {
		return dao.getAll();
	}

}
