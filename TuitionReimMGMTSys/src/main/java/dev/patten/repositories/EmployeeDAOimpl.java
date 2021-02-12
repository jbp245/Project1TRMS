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

import dev.patten.entities.Employee;
import dev.patten.util.JDBCConnection;

/**
 * @author james
 *
 */
public class EmployeeDAOimpl implements CRUDable<Employee> {

	public static Connection conn = JDBCConnection.getConnection();
	
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
