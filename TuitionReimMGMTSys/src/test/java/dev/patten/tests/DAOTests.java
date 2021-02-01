/**
 * 
 */
package dev.patten.tests;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//entities
import dev.patten.entities.ApprovalStatus;
import dev.patten.entities.Department;
import dev.patten.entities.Employee;
import dev.patten.entities.EventGrades;
import dev.patten.entities.EventType;
import dev.patten.entities.Form;
import dev.patten.entities.Roles;

import dev.patten.repositories.CRUDable;
import dev.patten.repositories.READable;

import dev.patten.util.JDBCConnection;

/**
 * @author james
 *
 */
@TestMethodOrder(MethodName.class)
public class DAOTests {
	
	public static Connection conn = JDBCConnection.getConnection();

	// if impl's unwritten, new ClassDAOimpl(){ @override methods }
	// private static GDAO<Employee> emp = new EmployeeDAOimpl();

	private class ApprovalStatusDAOimpl implements CRUDable<ApprovalStatus> {
		
		@Override
		public boolean add(ApprovalStatus record) {
			// TODO should implement
			return false;
		}

		@Override
		public ApprovalStatus get(int id) {
			try {
				String sql = "SELECT * FROM Approval_Status WHERE form_id = ?";

				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, Integer.toString(id));

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {

					ApprovalStatus a = new ApprovalStatus();
					a.setStatus(rs.getInt("STATUS"));
					a.setId(rs.getInt("FORM_ID"));
					a.setEvent_id(rs.getInt("EVENT_ID"));
					a.setSup_approved(rs.getBoolean("SUPER_APPR"));
					a.setDept_appr_desc(rs.getString("SUPER_APPR_DESC"));
					a.setDept_approved(rs.getBoolean("DEP_APPR"));
					a.setDept_appr_desc(rs.getString("DEP_APPR_DESC"));
					a.setBenco_approved(rs.getBoolean("BENCO_APPR"));
					a.setStatus_name(rs.getString("STATUS_NAME"));

					return a;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return null;
		}

		@Override
		public List<ApprovalStatus> getAll() {
			List<ApprovalStatus> apprStatuses = new ArrayList<ApprovalStatus>();

			try {
				String sql = "SELECT * FROM Approval_Status";
				PreparedStatement ps = conn.prepareStatement(sql);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					apprStatuses.add(this.get(rs.getInt("FORM_ID")));
				}
				return apprStatuses;
			} catch (SQLException e1) {
				e1.printStackTrace();

			}
			return apprStatuses;
		}

		@Override
		public boolean update(ApprovalStatus change) {

			try {
				String sql = "UPDATE Approval_Status SET status = ?, event_id = ?, super_appr = ?, super_appr_desc = ?, dep_appr = ?, dep_appr_desc = ?, benco_appr = ?, status_name = ? WHERE form_id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(9, Integer.toString(change.getId()));
				ps.setString(1, Integer.toString(change.getStatus()));
				ps.setString(2, Integer.toString(change.getEvent_id()));
				ps.setString(3, Boolean.toString(change.isSup_approved()));
				ps.setString(4, change.getSup_appr_desc());
				ps.setString(5, Boolean.toString(change.isDept_approved()));
				ps.setString(6, change.getDept_appr_desc());
				ps.setString(7, Boolean.toString(change.isBenco_approved()));
				ps.setString(8, change.getStatus_name());

				ps.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;

		}

		@Override
		public boolean delete(int id) {
			try {
				String sql = "DELETE Approval_Status WHERE id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);

				ps.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
	}

	@Test
	void apprStatusGet() {
		ApprovalStatus test = new ApprovalStatusDAOimpl().get(1);
		Assertions.assertEquals(1, test.getId());
	}

	@Test
	void apprStatusGetAll() {
		List<ApprovalStatus> test = new ApprovalStatusDAOimpl().getAll();
		Assertions.assertFalse(test.isEmpty());
	}
	
	private class DepartmentDAOimpl implements READable<Department> {

		@Override
		public Department get(int id) {

			try {
				String sql = "SELECT * FROM departments WHERE id = ?";

				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, Integer.toString(id));

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {

					Department a = new Department();
					a.setId(rs.getInt("ID"));
					a.setDept_name(rs.getString("DEPT_NAME"));
					a.setHead_id(rs.getInt("HEAD"));

					return a;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return null;
		}

		@Override
		public List<Department> getAll() {
			List<Department> departments = new ArrayList<Department>();

			try {
				String sql = "SELECT * FROM departments";
				PreparedStatement ps = conn.prepareStatement(sql);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					departments.add(this.get(rs.getInt("ID")));
				}
				return departments;
			} catch (SQLException e1) {
				e1.printStackTrace();

			}
			return departments;
		}

	}

	@Test
	void departmentGet() {
		Department test = new DepartmentDAOimpl().get(1);
		Assertions.assertEquals(1, test.getId());
	}

	@Test
	void departmentGetAll() {
		List<Department> test = new DepartmentDAOimpl().getAll();
		Assertions.assertFalse(test.isEmpty());
	}
	
	private class EmployeeDAOimpl implements CRUDable<Employee> {

		@Override
		public boolean add(Employee record) {
			try {
				String sql = "CALL add_employee(?,?,?,?,?,?,?,?)";
				CallableStatement cs = conn.prepareCall(sql);

				cs.setString(1, record.getFirst_name());
				cs.setString(2, record.getLast_name());
				cs.setString(3, record.getUsername());
				cs.setString(4, record.getPassword());
				cs.setString(5, Integer.toString(record.getSuper_id()));
				cs.setString(6, Integer.toString(record.getDepartment_id()));
				cs.setString(7, Integer.toString(record.getRole_id()));
				cs.setString(8, Double.toString(record.getAward_available()));

				cs.execute();
				return true;

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return false;
		}

		@Override
		public Employee get(int id) {

			try {
				String sql = "SELECT * FROM employee WHERE id = ?";

				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, Integer.toString(id));

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {

					Employee a = new Employee();
					a.setId(rs.getInt("ID"));
					a.setFirst_name(rs.getString("FIRST_NAME"));
					a.setLast_name(rs.getString("LAST_NAME"));
					a.setUsername(rs.getString("USERNAME"));
					a.setPassword(rs.getString("PASSWORD"));
					a.setSuper_id(rs.getInt("SUPER_ID"));
					a.setDepartment_id(rs.getInt("DEPT_ID"));
					a.setRole_id(rs.getInt("ROLE_ID"));
					a.setAward_available(rs.getDouble("AWARD_AVAIL"));

					return a;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return null;
		}

		@Override
		public List<Employee> getAll() {
			List<Employee> employees = new ArrayList<Employee>();

			try {
				String sql = "SELECT * FROM employee";
				PreparedStatement ps = conn.prepareStatement(sql);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					employees.add(this.get(rs.getInt("ID")));
				}
				return employees;
			} catch (SQLException e1) {
				e1.printStackTrace();

			}
			return employees;
		}

		@Override
		public boolean update(Employee change) {
			try {
				String sql = "UPDATE employee SET first_name = ?, last_name = ?, username = ?, password = ?, super_id = ?, dept_id = ?, role_id = ?, award_avail = ? WHERE id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(9, Integer.toString(change.getId()));
				ps.setString(1, change.getFirst_name());
				ps.setString(2, change.getLast_name());
				ps.setString(3, change.getUsername());
				ps.setString(4, change.getPassword());
				ps.setString(5, Integer.toString(change.getSuper_id()));
				ps.setString(6, Integer.toString(change.getDepartment_id()));
				ps.setString(7, Integer.toString(change.getRole_id()));
				ps.setString(8, Double.toString(change.getAward_available()));

				ps.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}

		@Override
		public boolean delete(int id) {
			try {
				String sql = "DELETE employee WHERE id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);

				ps.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
	}
	
	@Test
	void employeeGet() {
		Employee test = new EmployeeDAOimpl().get(3);
		Assertions.assertEquals(3, test.getId());
	}

	@Test
	void employeeGetAll() {
		List<Employee> test = new EmployeeDAOimpl().getAll();
		Assertions.assertFalse(test.isEmpty());
	}

	private class EventGradesDAOimpl implements READable<EventGrades> {

		@Override
		public EventGrades get(int id) {

			try {
				String sql = "SELECT * FROM event_grades WHERE id = ?";

				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, Integer.toString(id));

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {

					EventGrades a = new EventGrades();
					a.setId(rs.getInt("ID"));
					a.setPassing(rs.getBoolean("PASSING"));
					a.setGrade_name(rs.getString("GRADE_NAME"));

					return a;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return null;
		}

		@Override
		public List<EventGrades> getAll() {
			List<EventGrades> eventGrades = new ArrayList<EventGrades>();

			try {
				String sql = "SELECT * FROM event_grades";
				PreparedStatement ps = conn.prepareStatement(sql);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					eventGrades.add(this.get(rs.getInt("ID")));
				}
				return eventGrades;
			} catch (SQLException e1) {
				e1.printStackTrace();

			}
			return eventGrades;
		}
	}
	
	@Test
	void eventGradesGet() {
		EventGrades test = new EventGradesDAOimpl().get(1);
		Assertions.assertEquals(1, test.getId());
	}

	@Test
	void eventGradesGetAll() {
		List<EventGrades> test = new EventGradesDAOimpl().getAll();
		Assertions.assertFalse(test.isEmpty());
	}

	/**
	 * EventTypeDAOimpl 
	 *
	 */
	private class EventTypeDAOimpl implements READable<EventType> {

		@Override
		public EventType get(int id) {

			try {
				String sql = "SELECT * FROM event_type WHERE id = ?";

				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, Integer.toString(id));

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {

					EventType a = new EventType();
					a.setId(rs.getInt("ID"));
					a.setName(rs.getString("EVENT_TYPE_NAME"));
					a.setReimbursement_rate(rs.getDouble("REIM_RATE"));

					return a;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return null;
		}

		@Override
		public List<EventType> getAll() {
			List<EventType> eventTypes = new ArrayList<EventType>();

			try {
				String sql = "SELECT * FROM event_type";
				PreparedStatement ps = conn.prepareStatement(sql);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					eventTypes.add(this.get(rs.getInt("ID")));
				}
				return eventTypes;
			} catch (SQLException e1) {
				e1.printStackTrace();

			}
			return eventTypes;
		}
	}
	
	@Test
	void eventTypeGet() {
		EventType test = new EventTypeDAOimpl().get(1);
		Assertions.assertEquals("University Course", test.getName());
	}

	@Test
	void eventTypeGetAll() {
		List<EventType> test = new EventTypeDAOimpl().getAll();
		Assertions.assertFalse(test.isEmpty());
	}

	private class FormDAOimpl implements CRUDable<Form> {

		@Override
		public boolean add(Form record) {
			try {

				String sql = "CALL add_form(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				CallableStatement cs = conn.prepareCall(sql);

				cs.setString(1, record.getFirst_name());
				cs.setString(2, record.getLast_name());
				cs.setString(3, Integer.toString(record.getEmp_id()));
				cs.setString(4, record.getDate().toString());
				cs.setString(5, record.getTime().toString());
				cs.setString(6, record.getLocation());
				cs.setString(7, record.getDescription());
				cs.setString(7, Double.toString(record.getCost()));
				cs.setString(8, Boolean.toString(record.isGrade_format()));
				cs.setString(9, Integer.toString(record.getGrade_cutoff()));
				cs.setString(10, Integer.toString(record.getEvent_type_id()));
				cs.setBlob(11, record.getAttachment());
				cs.setString(12, Integer.toString(record.getApproval_type()));
				cs.setString(13, Integer.toString(record.getTime_off()));
				cs.setString(14, Boolean.toString(record.isUrgent()));

				cs.execute();
				return true;

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return false;
		}

		@Override
		public Form get(int id) {

			try {
				String sql = "SELECT * FROM reim_form WHERE id = ?";

				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, Integer.toString(id));

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {

					Form a = new Form();
					a.setId(rs.getInt("ID"));
					a.setFirst_name(rs.getString("FIRST_NAME"));
					a.setLast_name(rs.getString("LAST_NAME"));
					a.setEmp_id(rs.getInt("EMP_ID"));
					a.setDate(rs.getDate("EVENT_DATE"));
					a.setTime(rs.getTimestamp("EVENT_TIME"));
					a.setLocation(rs.getString("EVENT_LOCATION"));
					a.setDescription(rs.getString("EVENT_DESCRIPTION"));
					a.setCost(rs.getDouble("EVENT_COST"));
					a.setGrade_format(rs.getBoolean("GRADE_FORMAT"));
					a.setGrade_cutoff(rs.getInt("GRADE_CUTOFF"));
					a.setEvent_type_id(rs.getInt("EVENT_TYPE_ID"));
					a.setAttachment(rs.getBlob("ATTACHMENT"));
					a.setApproval_type(rs.getInt("APPROVAL_TYPE"));
					a.setTime_off(rs.getInt("TIME_OFF"));
					a.setUrgency(rs.getBoolean("URGENT"));

					return a;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return null;
		}

		@Override
		public List<Form> getAll() {
			List<Form> accounts = new ArrayList<Form>();

			try {
				String sql = "SELECT * FROM reim_form";
				PreparedStatement ps = conn.prepareStatement(sql);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					accounts.add(this.get(rs.getInt("ID")));
				}
				return accounts;
			} catch (SQLException e1) {
				e1.printStackTrace();

			}
			return accounts;
		}

		@Override
		public boolean update(Form change) {

			try {
				String sql = "UPDATE reim_form SET first_name = ?, last_name = ?, emp_id = ?, event_date = ?, event_time = ?, event_location = ?, event_cost = ?, grade_format = ?, grade_cutoff = ?, event_id_type = ?, attachment = ?, approval_type = ?, time_off = ?, urgent = ? WHERE cust_id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(15, Integer.toString(change.getId()));
				ps.setString(1, change.getFirst_name());
				ps.setString(2, change.getLast_name());
				ps.setString(3, Integer.toString(change.getEmp_id()));
				ps.setString(4, change.getDate().toString());
				ps.setString(5, change.getTime().toString());
				ps.setString(6, change.getLocation());
				ps.setString(7, Double.toString(change.getCost()));
				ps.setString(8, Boolean.toString(change.isGrade_format()));
				ps.setString(9, Integer.toString(change.getGrade_cutoff()));
				ps.setString(10, Integer.toString(change.getEvent_type_id()));
				ps.setString(11, change.getAttachment().toString());
				ps.setString(12, Integer.toString(change.getApproval_type()));
				ps.setString(13, Integer.toString(change.getTime_off()));
				ps.setString(14, Boolean.toString(change.isUrgent()));

				ps.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}

		@Override
		public boolean delete(int id) {
			try {
				String sql = "DELETE reim_form WHERE id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);

				ps.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}

	}

	@Test
	void formGet() {
		Form test = new FormDAOimpl().get(1);
		Assertions.assertEquals(1, test.getId());
	}

	@Test
	void formGetAll() {
		List<Form> test = new FormDAOimpl().getAll();
		Assertions.assertFalse(test.isEmpty());
	}

	private class RolesDAOimpl implements READable<Roles> {

		@Override
		public Roles get(int id) {

			try {
				String sql = "SELECT * FROM roles WHERE id = ?";

				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, Integer.toString(id));

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {

					Roles a = new Roles();
					a.setId(rs.getInt("ID"));
					a.setRole_name(rs.getString("NAME"));

					return a;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return null;
		}

		@Override
		public List<Roles> getAll() {
			List<Roles> roles = new ArrayList<Roles>();

			try {
				String sql = "SELECT * FROM roles";
				PreparedStatement ps = conn.prepareStatement(sql);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					roles.add(this.get(rs.getInt("ID")));
				}
				return roles;
			} catch (SQLException e1) {
				e1.printStackTrace();

			}
			return roles;
		}
	}
	
	@Test
	void rolesGet() {
		Roles test = new RolesDAOimpl().get(1);
		Assertions.assertEquals(1, test.getId());
	}

	@Test
	void rolesGetAll() {
		List<Roles> test = new RolesDAOimpl().getAll();
		Assertions.assertFalse(test.isEmpty());
	}
}
