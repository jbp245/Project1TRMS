/**
 * 
 */
package dev.patten.entities;

/**
 * @author james
 * Entity representing a record in Event_grades table in db
 */
public class EventGrades {
	
	private int id;
	private boolean passing;
	private String grade_name;
	
	/**
	 * 
	 */
	public EventGrades() {
		super();
	}

	/**
	 * @param passing
	 * @param grade_name
	 */
	public EventGrades(boolean passing, String grade_name) {
		super();
		this.passing = passing;
		this.grade_name = grade_name;
	}

	/**
	 * @param id
	 * @param passing
	 * @param grade_name
	 */
	public EventGrades(int id, boolean passing, String grade_name) {
		super();
		this.id = id;
		this.passing = passing;
		this.grade_name = grade_name;
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
	 * @return the passing
	 */
	public boolean isPassing() {
		return passing;
	}

	/**
	 * @param passing the passing to set
	 */
	public void setPassing(boolean passing) {
		this.passing = passing;
	}

	/**
	 * @return the grade_name
	 */
	public String getGrade_name() {
		return grade_name;
	}

	/**
	 * @param grade_name the grade_name to set
	 */
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}

	@Override
	public String toString() {
		return "EventGrades [id=" + id + ", passing=" + passing + ", grade_name=" + grade_name + "]";
	}
	
}
