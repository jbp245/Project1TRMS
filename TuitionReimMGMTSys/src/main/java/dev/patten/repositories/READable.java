/**
 * 
 */
package dev.patten.repositories;

import java.util.List;

/**
 * @author james
 * Read-only DAO
 */
public interface READable<T> {
	
	/**
	 * READ (Single)
	 * Retrieves a specific record with @param id from the persistence layer
	 */
	public T get(int id);
	
	/**
	 * READ (All)
	 * Retrieves a List<T> comprising all records of a table from the persistence layer
	 */
	public List<T> getAll();
	
}
