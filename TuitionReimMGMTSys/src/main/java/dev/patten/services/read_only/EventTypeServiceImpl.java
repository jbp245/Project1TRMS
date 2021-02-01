/**
 * 
 */
package dev.patten.services.read_only;

import java.util.List;

import dev.patten.entities.EventType;
import dev.patten.repositories.EventTypeDAOimpl;
import dev.patten.repositories.READable;

/**
 * @author james
 *
 */
public class EventTypeServiceImpl implements ServiceREADable<EventType> {

	public READable<EventType> dao = new EventTypeDAOimpl();
	
	@Override
	public EventType get(int id) {
		return dao.get(id);
	}

	@Override
	public List<EventType> getAll() {
		return dao.getAll();
	}

}
