/**
 * 
 */
package dev.patten.services.read_only;

import java.util.List;

import dev.patten.entities.EventGrades;
import dev.patten.repositories.EventGradesDAOimpl;
import dev.patten.repositories.READable;

/**
 * @author james
 *
 */
public class EventGradesServiceImpl implements EventGradesService {

	public READable<EventGrades> dao = new EventGradesDAOimpl();
	
	@Override
	public EventGrades get(int id) {
		return dao.get(id);
	}

	@Override
	public List<EventGrades> getAll() {
		return dao.getAll();
	}

}
