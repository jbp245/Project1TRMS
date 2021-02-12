/**
 * 
 */
package dev.patten.entities;

/**
 * @author james
 * Entity representing a record in Employee table in db
 */
public class Employee {

	private int id;
	
	private String first_name;
	private String last_name;
	private String username;
	private String password;
	
	private int super_id;
	private int department_id;
	private int role_id;
	
	private double award_available;

	private final double MAX_AWARD = 1000.00; 

	/**
	 * DEFAULT CONSTRUCTOR:
	 */
	public Employee() {
		super();
	}

	/**
	 * ID-LESS CONSTRUCTOR
	 * @param first_name
	 * @param last_name
	 * @param username
	 * @param password
	 * @param super_id
	 * @param department_id
	 * @param role_id
	 * @param award_available
	 */
	public Employee(String first_name, String last_name, String username, String password, int super_id,
			int department_id, int role_id, int award_available) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.super_id = super_id;
		this.department_id = department_id;
		this.role_id = role_id;
		this.award_available = award_available;
	}

	/**
	 * FULL CONSTRUCTOR:
	 * @param id
	 * @param first_name
	 * @param last_name
	 * @param username
	 * @param password
	 * @param super_id
	 * @param department_id
	 * @param role_id
	 * @param award_available
	 */
	public Employee(int id, String first_name, String last_name, String username, String password, int super_id,
			int department_id, int role_id, int award_available) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.super_id = super_id;
		this.department_id = department_id;
		this.role_id = role_id;
		this.award_available = award_available;
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
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the super_id
	 */
	public int getSuper_id() {
		return super_id;
	}

	/**
	 * @param super_id the super_id to set
	 */
	public void setSuper_id(int super_id) {
		this.super_id = super_id;
	}

	/**
	 * @return the department_id
	 */
	public int getDepartment_id() {
		return department_id;
	}

	/**
	 * @param department_id the department_id to set
	 */
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	/**
	 * @return the role_id
	 */
	public int getRole_id() {
		return role_id;
	}

	/**
	 * @param role_id the role_id to set
	 */
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	/**
	 * @return the award_available
	 */
	public double getAward_available() {
		return award_available;
	}

	/**
	 * @param award_available the award_available to set
	 */
	public void setAward_available(double award_available) {
		this.award_available = award_available;
	}

	/**
	 * @return the MAX_AWARD
	 */
	public double getMAX_AWARD() {
		return MAX_AWARD;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", username="
				+ username + ", password=" + password + ", super_id=" + super_id + ", department_id=" + department_id
				+ ", role_id=" + role_id + ", award_available=" + award_available + "]";
	}

	
}
