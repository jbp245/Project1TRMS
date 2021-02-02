/**
 * 
 */
package dev.patten.entities;

/**
 * @author james
 * An entity representing a record in Roles table in db
 */
public class Roles {
	
	private int id;
	private String role_name;
	
	/**
	 * DEFAULT CONSTRUCTOR
	 */
	public Roles() {
		super();
	}

	/**
	 * ID-LESS CONSTRUCTOR
	 * @param role_name
	 */
	public Roles(String role_name) {
		super();
		this.role_name = role_name;
	}

	/**
	 * FULL CONSTRUCTOR
	 * @param id
	 * @param role_name
	 */
	public Roles(int id, String role_name) {
		super();
		this.id = id;
		this.role_name = role_name;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the role_name
	 */
	public String getRole_name() {
		return role_name;
	}

	/**
	 * @param role_name the role_name to set
	 */
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", role_name=" + role_name + "]";
	}
}
