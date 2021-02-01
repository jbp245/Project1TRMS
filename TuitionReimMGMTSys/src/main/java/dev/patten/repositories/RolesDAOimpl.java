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

import dev.patten.entities.Roles;
import dev.patten.util.JDBCConnection;

/**
 * @author james
 *
 */
public class RolesDAOimpl implements READable<Roles> {

	public static Connection conn = JDBCConnection.getConnection();
	
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
