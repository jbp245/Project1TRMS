/**
 * 
 */
package dev.patten.entities;

/**
 * @author james
 * An entity representing a record in Departments table in db
 */
public class Department {

	private int id;
	private String dept_name;
	private int head_id;
	
	/**
	 * DEFAULT CONSTRUCTOR
	 */
	public Department() {
		super();
	}

	/**
	 * ID-LESS CONSTRUCTOR
	 * @param dept_name
	 * @param head_id
	 */
	public Department(String dept_name, int head_id) {
		super();
		this.dept_name = dept_name;
		this.head_id = head_id;
	}

	/**
	 * FULL CONSTRUCTOR
	 * @param id
	 * @param dept_name
	 * @param head_id
	 */
	public Department(int id, String dept_name, int head_id) {
		super();
		this.id = id;
		this.dept_name = dept_name;
		this.head_id = head_id;
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
	 * @return the dept_name
	 */
	public String getDept_name() {
		return dept_name;
	}

	/**
	 * @param dept_name the dept_name to set
	 */
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	/**
	 * @return the head_id
	 */
	public int getHead_id() {
		return head_id;
	}

	/**
	 * @param head_id the head_id to set
	 */
	public void setHead_id(int head_id) {
		this.head_id = head_id;
	}

	@Override
	public String toString() {
		return "Departments [id=" + id + ", dept_name=" + dept_name + ", head_id=" + head_id + "]";
	}
	
}
