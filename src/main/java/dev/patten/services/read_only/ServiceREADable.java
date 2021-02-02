/**
 * 
 */
package dev.patten.services.read_only;

import java.util.List;

/**
 * @author james
 *
 */
public interface ServiceREADable<T> {

	/**
	 * READ (Single)
	 * Call on DAO impl to retrieve a single record with @param id from the DB
	 */
	public T get(int id);

	/**
	 * READ (All)
	 * Call on DAO impl to retrieve a List<T> of all records from a persistence layer table
	 */
	public List<T> getAll();
}
