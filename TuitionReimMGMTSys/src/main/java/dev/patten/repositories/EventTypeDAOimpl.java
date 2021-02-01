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

import dev.patten.entities.EventType;
import dev.patten.util.JDBCConnection;

/**
 * @author james
 *
 */
public class EventTypeDAOimpl implements READable<EventType> {

	public static Connection conn = JDBCConnection.getConnection();
	
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
