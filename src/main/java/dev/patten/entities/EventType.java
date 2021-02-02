/**
 * 
 */
package dev.patten.entities;

/**
 * @author james
 * Entity representing a record in Event_type table in db
 */
public class EventType {
	
	private int id;
	private String name;
	private double reimbursement_rate;
	
	/**
	 * 
	 */
	public EventType() {
		super();
	}

	/**
	 * @param name
	 * @param reimbursement_rate
	 */
	public EventType(String name, double reimbursement_rate) {
		super();
		this.name = name;
		this.reimbursement_rate = reimbursement_rate;
	}

	/**
	 * @param id
	 * @param name
	 * @param reimbursement_rate
	 */
	public EventType(int id, String name, double reimbursement_rate) {
		super();
		this.id = id;
		this.name = name;
		this.reimbursement_rate = reimbursement_rate;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the reimbursement_rate
	 */
	public double getReimbursement_rate() {
		return reimbursement_rate;
	}

	/**
	 * @param reimbursement_rate the reimbursement_rate to set
	 */
	public void setReimbursement_rate(double reimbursement_rate) {
		this.reimbursement_rate = reimbursement_rate;
	}

	@Override
	public String toString() {
		return "EventType [id=" + id + ", name=" + name + ", reimbursement_rate=" + reimbursement_rate + "]";
	}
	
}
