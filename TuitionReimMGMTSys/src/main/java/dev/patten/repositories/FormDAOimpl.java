/**
 * 
 */
package dev.patten.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.patten.entities.Form;
import dev.patten.util.JDBCConnection;

/**
 * @author james
 *
 */
public class FormDAOimpl implements CRUDable<Form> {

	public static Connection conn = JDBCConnection.getConnection();
	
	@Override
	public boolean add(Form record) {
		try {
			System.out.println(record);
			String sql = "CALL add_form(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);

			int bool = record.isGrade_format() ? 1 :0;

			
			cs.setString(1, record.getFirst_name());
			cs.setString(2, record.getLast_name());
			cs.setString(3, Integer.toString(record.getEmp_id()));
			cs.setNull(4, java.sql.Types.DATE);
			//cs.setString(4, record.getDate());
			//cs.setString(5, record.getTime());
			cs.setNull(5, java.sql.Types.TIME);
			cs.setString(6, record.getLocation());
			cs.setString(7, record.getDescription());
			cs.setInt(8, (int)record.getCost());
			cs.setString(9, Integer.toString(bool));
			cs.setString(10, Integer.toString(record.getGrade_cutoff()));
			cs.setString(11, Integer.toString(record.getEvent_type_id()));
			//cs.setBlob(12, record.getAttachment());
			cs.setNull(12, java.sql.Types.BLOB);
			System.out.println(record.getAttachment());
			cs.setString(13, Integer.toString(record.getApproval_type()));
			cs.setString(14, Integer.toString(record.getTime_off()));
			bool = record.isUrgent() ? 1 :0;
			System.out.println(bool);
			cs.setString(15, Integer.toString(bool));

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
				//made these strings
				a.setDate("null");
				a.setTime("null");
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
			ps.setString(4, change.getDate());
			ps.setString(5, change.getTime());
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
