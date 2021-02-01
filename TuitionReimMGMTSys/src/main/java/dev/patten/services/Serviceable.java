/**
 * 
 */
package dev.patten.services;

import java.util.List;

/**
 * @author james
 * Generic Interface that guarantees CRUD operation implementations in Service calls to DAO
 * 
 * NOTE: Testing out using T in place of int. Replace with <T, PK extends Integer>, Integer, or int for typesafety/ simplicity
 */
public interface Serviceable<T> {
	
	/**
	 * CREATE
	 * Call on DAO impl to add a new @param record to the DB
	 */
	public boolean add(T record);

	/**
	 * READ (Single)
	 * Call on DAO impl to retrieve a single record with @param id from the DB
	 */
	public T get(T id);

	/**
	 * READ (All)
	 * Call on DAO impl to retrieve a List<T> of all records from a persistence layer table
	 */
	public List<T> getAll();
	
	/**
	 * UPDATE
	 * Call on DAO impl to reflect the current state of @param change in the persistence layer
	 */
	public boolean update(T change);

	/**
	 * DELETE
	 * Call on DAO impl to delete a record with @param id in the persistence layer
	 */
	public boolean delete(T id);
	
}
