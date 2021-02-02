/**
 * 
 */
package dev.patten.services;

import java.util.List;

import dev.patten.entities.ApprovalStatus;
import dev.patten.repositories.ApprovalStatusDAOimpl;
import dev.patten.repositories.CRUDable;

/**
 * @author james
 *
 */
public class ApprovalStatusServiceImpl implements ApprovalStatusService {

	public CRUDable<ApprovalStatus> dao = new ApprovalStatusDAOimpl();

	@Override
	public boolean add(ApprovalStatus record) {
		return dao.add(record);
	}

	@Override
	public boolean update(ApprovalStatus change) {
		return dao.update(change);
	}

	@Override
	public boolean delete(int id) {
		return dao.delete(id);
	}

	@Override
	public ApprovalStatus get(int id) {
		return dao.get(id);
	}

	@Override
	public List<ApprovalStatus> getAll() {
		return dao.getAll();
	}

}
