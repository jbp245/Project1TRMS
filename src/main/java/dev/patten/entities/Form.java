/**
 * 
 */
package dev.patten.entities;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author james
 * Entity representing a record in Reim_Form table in db
 */
public class Form {
	
	private int id;
	private String first_name;
	private String last_name;
	private int emp_id;
	private Date date;
	private Timestamp time;
	private String location;
	private String description;
	private double cost;
	private boolean grade_format;
	private int grade_cutoff;
	private int event_type_id;
	private Blob attachment;
	private int approval_type;
	private int time_off;
	private boolean urgent;
	
	public Form (int id) {super(); this.id = 10;}
	
	/**
	 * DEFAULT CONSTRUCTOR:
	 */
	public Form() {
		super();
	}

	/**
	 * ID-LESS CONSTRUCTOR:
	 * @param first_name
	 * @param last_name
	 * @param emp_id
	 * @param date
	 * @param time
	 * @param location
	 * @param description
	 * @param cost
	 * @param grade_format
	 * @param event_type_id
	 * @param attachment
	 * @param approval_type
	 * @param time_off
	 * @param urgency
	 */
	public Form(String first_name, String last_name, int emp_id, Date date, Timestamp time, String location,
			String description, double cost, boolean grade_format, int grade_cutoff, int event_type_id, Blob attachment,
			int approval_type, int time_off, boolean urgency) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.emp_id = emp_id;
		this.date = date;
		this.time = time;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.grade_format = grade_format;
		this.grade_cutoff = grade_cutoff;
		this.event_type_id = event_type_id;
		this.attachment = attachment;
		this.approval_type = approval_type;
		this.time_off = time_off;
		this.urgent = urgency;
	}

	/**
	 * FULL CONSTRUCTOR:
	 * @param id
	 * @param first_name
	 * @param last_name
	 * @param emp_id
	 * @param date
	 * @param time
	 * @param location
	 * @param description
	 * @param cost
	 * @param grade_format
	 * @param event_type_id
	 * @param attachment
	 * @param approval_type
	 * @param time_off
	 * @param urgency
	 */
	public Form(int id, String first_name, String last_name, int emp_id, Date date, Timestamp time, String location,
			String description, double cost, boolean grade_format, int grade_cutoff, int event_type_id, Blob attachment,
			int approval_type, int time_off, boolean urgency) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.emp_id = emp_id;
		this.date = date;
		this.time = time;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.grade_format = grade_format;
		this.grade_cutoff = grade_cutoff;
		this.event_type_id = event_type_id;
		this.attachment = attachment;
		this.approval_type = approval_type;
		this.time_off = time_off;
		this.urgent = urgency;
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
	 * @return the emp_id
	 */
	public int getEmp_id() {
		return emp_id;
	}

	/**
	 * @param emp_id the emp_id to set
	 */
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the time
	 */
	public Timestamp getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Timestamp time) {
		this.time = time;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * @return the grade_format
	 */
	public boolean isGrade_format() {
		return grade_format;
	}

	/**
	 * @param grade_format the grade_format to set
	 */
	public void setGrade_format(boolean grade_format) {
		this.grade_format = grade_format;
	}

	/**
	 * @return the grade_cutoff
	 */
	public int getGrade_cutoff() {
		return grade_cutoff;
	}

	/**
	 * @param grade_cutoff the grade_cutoff to set
	 */
	public void setGrade_cutoff(int grade_cutoff) {
		this.grade_cutoff = grade_cutoff;
	}

	/**
	 * @return the event_type_id
	 */
	public int getEvent_type_id() {
		return event_type_id;
	}

	/**
	 * @param event_type_id the event_type_id to set
	 */
	public void setEvent_type_id(int event_type_id) {
		this.event_type_id = event_type_id;
	}

	/**
	 * @return the attachment
	 */
	public Blob getAttachment() {
		return attachment;
	}

	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(Blob attachment) {
		this.attachment = attachment;
	}

	/**
	 * @return the approval_type
	 */
	public int getApproval_type() {
		return approval_type;
	}

	/**
	 * @param approval_type the approval_type to set
	 */
	public void setApproval_type(int approval_type) {
		this.approval_type = approval_type;
	}

	/**
	 * @return the time_off
	 */
	public int getTime_off() {
		return time_off;
	}

	/**
	 * @param time_off the time_off to set
	 */
	public void setTime_off(int time_off) {
		this.time_off = time_off;
	}

	/**
	 * @return the urgency
	 */
	public boolean isUrgent() {
		return urgent;
	}

	/**
	 * @param urgent the urgency to set
	 */
	public void setUrgency(boolean urgency) {
		this.urgent = urgency;
	}

	@Override
	public String toString() {
		return "Form [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", emp_id=" + emp_id
				+ ", date=" + date + ", time=" + time + ", location=" + location + ", description=" + description
				+ ", cost=" + cost + ", grade_format=" + grade_format + ", event_type_id=" + event_type_id
				+ ", attachment=" + attachment + ", approval_type=" + approval_type + ", time_off=" + time_off
				+ ", urgency=" + urgent + "]";
	}

}
