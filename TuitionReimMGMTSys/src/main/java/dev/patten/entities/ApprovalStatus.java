/**
 * 
 */
package dev.patten.entities;

/**
 * @author james An entity representing a record in Approval_status table in db
 */
public class ApprovalStatus {

	// shouldnt use id - removed from constructors
	private int id;
	private int status;
	private String status_name;
	private int event_id;
	private boolean sup_approved;
	private String sup_appr_desc;
	private boolean dept_approved;
	private String dept_appr_desc;
	private boolean benco_approved;
	private String benco_appr_desc;
	private int grade;

	/**
	 * DEFAULT CONSTRUCTOR
	 */
	public ApprovalStatus() {
		super();
	}

	/**
	 * FULL CONSTRUCTOR
	 * @param status
	 * @param event_id
	 * @param sup_approved
	 * @param dept_approved
	 * @param dept_appr_desc
	 * @param benco_approved
	 * @param benco_appr_desc
	 */
	public ApprovalStatus(int status, int event_id, boolean sup_approved, boolean dept_approved, String dept_appr_desc,
			boolean benco_approved, String status_name, String benco_appr_desc, int grade) {
		super();
		this.status = status;
		this.event_id = event_id;
		this.sup_approved = sup_approved;
		this.dept_approved = dept_approved;
		this.dept_appr_desc = dept_appr_desc;
		this.benco_approved = benco_approved;
		this.status_name = status_name;
		this.benco_appr_desc = benco_appr_desc;
		this.setGrade(grade);
		
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
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the status_name
	 */
	public String getStatus_name() {
		return status_name;
	}

	/**
	 * @param status_name the status_name to set
	 */
	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}

	/**
	 * @return the event_id
	 */
	public int getEvent_id() {
		return event_id;
	}

	/**
	 * @param event_id the event_id to set
	 */
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	/**
	 * @return the sup_approved
	 */
	public boolean isSup_approved() {
		return sup_approved;
	}

	/**
	 * @param sup_approved the sup_approved to set
	 */
	public void setSup_approved(boolean sup_approved) {
		this.sup_approved = sup_approved;
	}

	/**
	 * @return the sup_appr_desc
	 */
	public String getSup_appr_desc() {
		return sup_appr_desc;
	}

	/**
	 * @param sup_appr_desc the sup_appr_desc to set
	 */
	public void setSup_appr_desc(String sup_appr_desc) {
		this.sup_appr_desc = sup_appr_desc;
	}

	/**
	 * @return the dept_approved
	 */
	public boolean isDept_approved() {
		return dept_approved;
	}

	/**
	 * @param dept_approved the dept_approved to set
	 */
	public void setDept_approved(boolean dept_approved) {
		this.dept_approved = dept_approved;
	}

	/**
	 * @return the dept_appr_desc
	 */
	public String getDept_appr_desc() {
		return dept_appr_desc;
	}

	/**
	 * @param dept_appr_desc the dept_appr_desc to set
	 */
	public void setDept_appr_desc(String dept_appr_desc) {
		this.dept_appr_desc = dept_appr_desc;
	}

	/**
	 * @return the benco_approved
	 */
	public boolean isBenco_approved() {
		return benco_approved;
	}

	/**
	 * @param benco_approved the benco_approved to set
	 */
	public void setBenco_approved(boolean benco_approved) {
		this.benco_approved = benco_approved;
	}

	/**
	 * @return the benco_appr_desc
	 */
	public String getBenco_appr_desc() {
		return benco_appr_desc;
	}

	/**
	 * @param benco_appr_desc the benco_appr_desc to set
	 */
	public void setBenco_appr_desc(String benco_appr_desc) {
		this.benco_appr_desc = benco_appr_desc;
	}

	/**
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "ApprovalStatus [id=" + id + ", status=" + status + ", status_name=" + status_name + ", event_id="
				+ event_id + ", sup_approved=" + sup_approved + ", sup_appr_desc=" + sup_appr_desc + ", dept_approved="
				+ dept_approved + ", dept_appr_desc=" + dept_appr_desc + ", benco_approved=" + benco_approved
				+ ", benco_appr_desc=" + benco_appr_desc + ", grade=" + grade + "]";
	}

}
