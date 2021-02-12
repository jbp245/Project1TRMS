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

import dev.patten.entities.ApprovalStatus;
import dev.patten.util.JDBCConnection;

/**
 * @author james
 *
 */
public class ApprovalStatusDAOimpl implements CRUDable<ApprovalStatus> {

	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public boolean add(ApprovalStatus record) {
		try {
			String sql = "CALL add_ApprovalStatus(?,?,?,?,?,?,?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);

			cs.setString(1, Integer.toString(record.getId()));
			cs.setString(2, Integer.toString(record.getStatus()));
			cs.setString(3, record.getStatus_name());
			cs.setString(4, Integer.toString(record.getEvent_id()));
			cs.setString(5, Boolean.toString(record.isSup_approved()));
			cs.setString(6, record.getSup_appr_desc());
			cs.setString(5, Boolean.toString(record.isDept_approved()));
			cs.setString(6, record.getDept_appr_desc());
			cs.setString(5, Boolean.toString(record.isBenco_approved()));
			cs.setString(6, record.getBenco_appr_desc());
			cs.setString(4, Integer.toString(record.getGrade()));
			
			cs.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

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
				a.setBenco_appr_desc(rs.getString("BENCO_APPR_DESC"));
				a.setGrade(rs.getInt("GRADE"));

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
			String sql = "UPDATE Approval_Status SET status = ?, event_id = ?, super_appr = ?, super_appr_desc = ?, dep_appr = ?, dep_appr_desc = ?, benco_appr = ?, status_name = ?, benco_appr_desc = ?, grade = ? WHERE form_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(11, Integer.toString(change.getId()));
			ps.setString(1, Integer.toString(change.getStatus()));
			ps.setString(2, Integer.toString(change.getEvent_id()));
			ps.setString(3, Boolean.toString(change.isSup_approved()));
			ps.setString(4, change.getSup_appr_desc());
			ps.setString(5, Boolean.toString(change.isDept_approved()));
			ps.setString(6, change.getDept_appr_desc());
			ps.setString(7, Boolean.toString(change.isBenco_approved()));
			ps.setString(8, change.getStatus_name());
			ps.setString(9, change.getBenco_appr_desc());
			ps.setString(10, Integer.toString(change.getGrade()));

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
