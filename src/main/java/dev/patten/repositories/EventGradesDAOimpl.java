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

import dev.patten.entities.EventGrades;
import dev.patten.util.JDBCConnection;

/**
 * @author james
 *
 */
public class EventGradesDAOimpl implements READable<EventGrades> {

	public static Connection conn = JDBCConnection.getConnection();
	
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
