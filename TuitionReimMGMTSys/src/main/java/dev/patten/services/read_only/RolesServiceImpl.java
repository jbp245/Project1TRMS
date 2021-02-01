/**
 * 
 */
package dev.patten.services.read_only;

import java.util.List;

import dev.patten.entities.Roles;
import dev.patten.repositories.READable;
import dev.patten.repositories.RolesDAOimpl;

/**
 * @author james
 *
 */
public class RolesServiceImpl implements ServiceREADable<Roles> {

	public READable<Roles> dao = new RolesDAOimpl();
	
	@Override
	public Roles get(int id) {
		return dao.get(id);
	}

	@Override
	public List<Roles> getAll() {
		return dao.getAll();
	}

}
