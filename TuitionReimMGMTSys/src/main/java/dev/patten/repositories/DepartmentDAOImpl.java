/**
 * 
 */
package dev.patten.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.patten.entities.Department;
import dev.patten.util.JDBCConnection;

/**
 * @author james
 *
 */
public class DepartmentDAOImpl implements READable<Department> {

	public static Connection conn = JDBCConnection.getConnection();
	
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
