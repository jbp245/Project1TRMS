/**
 * 
 */
package dev.patten.repositories;

/**
 * @author james
 * Generic DAO interface that guarantees CRUD operation implementations
 * 
 * NOTE: Testing out using T in place of int. Replace with <T, PK extends Integer>, Integer, or int for typesafety/ simplicity
 */
public interface CRUDable<T> extends READable<T>{
	
	/**
	 * CREATE:
	 * Adds new @param record to the persistence layer
	 */
	public boolean add(T record);
	
	// READable implements 
	// T get(T);
	// List<T> getAll();
	
	/**
	 * UPDATE
	 * Updates a specific record to reflect the state of @param change in the persistence layer
	 */
	public boolean update(T change);
	
	/**
	 * DELETE
	 * Deletes a specific record with @param id from the persistence layer 
	 */
	public boolean delete(int id);
	
}
