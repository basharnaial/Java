package application;

import java.sql.Connection;
import java.sql.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;
import java.text.SimpleDateFormat;

public class Connecter {

	public JTable table1;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/hobitshero", "root", "");

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void table_load(JTable table) {
		Connect();
		try {
			pst = con.prepareStatement(
					"SELECT id AS \"#\", name AS \"الاسم\", description AS \"الوصف\", start_date AS \"تاريخ البدء\", time AS \"الوقت المقدر\" FROM tasks where status=0");
			rs = pst.executeQuery();
			if (table != null) {
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean insertTaskRecord(String vtitletask, String vdestask, java.util.Date vdatestart,
			String vtime_estimate) {
		boolean success = false;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = dateFormat.format(vdatestart);

			pst = con.prepareStatement("insert into tasks(name,description,start_date,time)values(?,?,?,?)");
			pst.setString(1, vtitletask);
			pst.setString(2, vdestask);
			pst.setString(3, dateString);
			pst.setString(4, vtime_estimate);
			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				success = true;
			}

			pst.close();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return success;
	}

	public boolean updateTask(String vtitletask, String vdestask, java.util.Date vdatestart, String vtime_estimate,
			String vtextField_1) {
		boolean success = false;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = dateFormat.format(vdatestart);

			pst = con.prepareStatement("update tasks set name= ?,description=?,start_date=?,time=? where id =?");
			pst.setString(1, vtitletask);
			pst.setString(2, vdestask);
			pst.setString(3, dateString);
			pst.setString(4, vtime_estimate);
			pst.setString(5, vtextField_1);
			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				success = true;
			}

			pst.close();

		}

		catch (SQLException e1) {

			e1.printStackTrace();
		}
		return success;
	}

	public boolean deleteTask(String vtextField_1) {
		boolean success = false;

		try {
			pst = con.prepareStatement("delete from tasks where id =?");
			pst.setString(1, vtextField_1);
			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				success = true;
			}
			pst.close();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return success;
	}

	public boolean setTaskCompleted(String vtextField_1) {
		boolean success = false;

		try {
			pst = con.prepareStatement("update tasks set status=1 where id =?");
			pst.setString(1, vtextField_1);
			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				success = true;
			}
			pst.close();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return success;
	}

	public void table_late(JTable table) {
		Connect();
		try {
			pst = con.prepareStatement(
					"SELECT id AS \"#\", name AS \"الاسم\", description AS \"الوصف\",  time AS \"الوقت المقدر\", DATEDIFF(CURDATE(), start_date) - time AS \"التأخير (أيام)\" FROM tasks WHERE start_date < CURDATE() AND DATEDIFF(start_date, CURDATE()) <= time AND status=0;");
			rs = pst.executeQuery();
			if (table != null) {
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void table_completed(JTable table) {
		Connect();
		try {
			pst = con.prepareStatement(
					"SELECT id AS \"#\", name AS \"الاسم\", description AS \"الوصف\", start_date AS \"تاريخ البدء\", time AS \"الوقت المقدر\" FROM tasks where status=1");
			rs = pst.executeQuery();
			if (table != null) {
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean insertGoalRecord(String vtitletask, java.util.Date vdatestart) {
		boolean success = false;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = dateFormat.format(vdatestart);

			pst = con.prepareStatement("insert into goals(name,start_date)values(?,?)");
			pst.setString(1, vtitletask);
			pst.setString(2, dateString);
			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				success = true;
			}

			pst.close();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return success;
	}

	public boolean loginChecker(String username1, String password1) {
		boolean success = false;

		try {
			pst = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
			pst.setString(1, username1);
			pst.setString(2, password1);

			rs = pst.executeQuery();
			if (rs.next()) {
				success = true;
			}

			pst.close();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return success;
	}

}
