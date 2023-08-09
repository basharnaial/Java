package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

public class PanelGoals extends JPanel {

	private JTextField titletask;
	private JTextField textField_1;
	JDateChooser datestart;
	LineBorder animatedBorder = new LineBorder(new Color(255, 255, 0), 4, true);

	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	private Connecter connector;
	private JTable table1;

	/**
	 * Create the panel.
	 */
	public PanelGoals() {
		connector = new Connecter();
		connector.Connect();

		setBounds(0, 0, 1089, 661);
		setVisible(true);

		setBounds(0, 0, 1089, 661);
		setLayout(null);
		setLayout(null);
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(442, 367, 626, 283);
		panel.setBorder(new LineBorder(new Color(255, 193, 7), 4, true));
		panel.setBackground(new Color(254, 244, 195));
		add(panel);
		panel.setLayout(null);
		panel.setVisible(true);

		JLabel lblNewLabel = new JLabel("عنوان المهمة");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Tajawal", Font.BOLD, 20));
		lblNewLabel.setBounds(459, 49, 124, 25);
		panel.add(lblNewLabel);

		titletask = new JTextField();
		titletask.setForeground(Color.BLACK);
		titletask.setFont(new Font("Tajawal", Font.PLAIN, 11));
		titletask.setHorizontalAlignment(SwingConstants.RIGHT);
		titletask.setBackground(Color.WHITE);
		titletask.setBounds(260, 38, 204, 42);
		panel.add(titletask);
		titletask.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("تاريخ الانتهاء");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tajawal", Font.BOLD, 20));
		lblNewLabel_2.setBounds(455, 141, 125, 25);
		panel.add(lblNewLabel_2);

		JButton addtask = new JButton("أضف المهمة");
		addtask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean insertGoalRecord = connector.insertGoalRecord(titletask.getText(), datestart.getDate());
				if (insertGoalRecord) {
					table_goals();
//                    connector.table_load(table1);
					JOptionPane.showMessageDialog(null, "تمت الاضافة!!!!!");

					titletask.setText("");
					datestart.setDate(null);
					textField_1.setText("");
					titletask.requestFocus();

				}

			}
		});

		addtask.setBackground(new Color(30, 144, 255));
		addtask.setForeground(new Color(255, 255, 255));
		addtask.setFont(new Font("Tajawal", Font.PLAIN, 16));
		addtask.setBounds(265, 203, 154, 34);
		panel.add(addtask);

		JButton clear = new JButton("مسح");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titletask.setText("");
				datestart.setDate(null);
			}
		});
		clear.setForeground(new Color(255, 255, 255));
		clear.setFont(new Font("Tajawal", Font.PLAIN, 16));
		clear.setBackground(new Color(255, 0, 0));
		clear.setBounds(429, 203, 154, 34);
		panel.add(clear);

		datestart = new JDateChooser();
		datestart.setBounds(260, 133, 202, 42);
		panel.add(datestart);

		JButton btnNewButton_1 = new JButton("تحديث");
		btnNewButton_1.setBounds(201, 155, 154, 34);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Tajawal", Font.PLAIN, 22));
		btnNewButton_1.setBackground(new Color(213, 243, 246));

		JButton btnNewButton_1_1 = new JButton("حذف");
		btnNewButton_1_1.setBounds(36, 157, 155, 32);
		panel.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton_1_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1_1.setFont(new Font("Tajawal", Font.PLAIN, 22));
		btnNewButton_1_1.setBackground(new Color(213, 243, 246));

		JButton completed = new JButton("تعيين كمكتملة");
		completed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		completed.setForeground(Color.WHITE);
		completed.setFont(new Font("Tajawal", Font.PLAIN, 16));
		completed.setBackground(new Color(0, 128, 0));
		completed.setBounds(36, 110, 318, 34);
		panel.add(completed);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(442, 33, 626, 306);
		panel_1.setBackground(new Color(240, 240, 240));
		add(panel_1);
		panel_1.setLayout(null);
		PanelGoals panelgoals = new PanelGoals(2);
		panelgoals.setBounds(-19, 0, 971, 305);
		panel_1.add(panelgoals);
		panelgoals.setBackground(new Color(255, 192, 203));

		Timer borderTimer = new Timer(1000, new ActionListener() {
			private boolean isYellow = false;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isYellow) {
					animatedBorder = new LineBorder(new Color(255, 255, 0), 4, true);
				} else {
					animatedBorder = new LineBorder(new Color(214, 200, 246), 4, true);
				}
				panelgoals.setBorder(animatedBorder);
				isYellow = !isYellow;
			}
		});
		borderTimer.start();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 407, 306);
		add(scrollPane);

		table1 = new JTable();

		table1.setFillsViewportHeight(true);
		table1.setColumnSelectionAllowed(true);
		table1.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table1);
		table1.setBackground(new Color(214, 200, 246));

		JLabel lblNewLabel_1 = new JLabel("الأهداف الحالية");
		lblNewLabel_1.setForeground(new Color(255, 182, 193));
		lblNewLabel_1.setFont(new Font("Tajawal Black", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(943, 11, 136, 22);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("الأهداف السابقة");
		lblNewLabel_1_1.setForeground(new Color(221, 160, 221));
		lblNewLabel_1_1.setFont(new Font("Tajawal Black", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(271, 12, 152, 22);
		add(lblNewLabel_1_1);
		table_goals();

		btnNewButton_1.setVisible(false);
		btnNewButton_1_1.setVisible(false);
		completed.setVisible(false);
	}

	public PanelGoals(int a) {
		connector = new Connecter();
		connector.Connect();
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		try {
			String query = "SELECT * FROM goals WHERE start_date > CURDATE();";
			PreparedStatement pst = connector.con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String goalTitle = rs.getString("name");
				String goalDescription = rs.getString("start_date");

				// إنشاء وتكوين المربع
				JPanel goalPanel = new JPanel();
				goalPanel.setBorder(new LineBorder(Color.BLACK));
				goalPanel.setLayout(new BorderLayout());
				goalPanel.setPreferredSize(new Dimension(900, 25));

				JLabel titleLabel = new JLabel(goalTitle);
				JLabel descriptionLabel = new JLabel(goalDescription);

				titleLabel.setFont(new Font("Tajawal", Font.BOLD, 18));
				descriptionLabel.setFont(new Font("Tajawal", Font.PLAIN, 14));

				JPanel labelsPanel = new JPanel();
				labelsPanel.setLayout(new GridLayout(1, 2));
				labelsPanel.add(descriptionLabel);
				labelsPanel.add(titleLabel);

				goalPanel.add(labelsPanel, BorderLayout.CENTER);

				add(goalPanel);

				Timer countdownTimer = new Timer(1000, e -> {
					long currentTimeMillis = System.currentTimeMillis();
					long goalMillis = parseDateToMillis(goalDescription);

					long remainingTimeMillis = goalMillis - currentTimeMillis;
					if (remainingTimeMillis <= 0) {
						((Timer) e.getSource()).stop();
						descriptionLabel.setText("لقد مضى وقت هذا الهدف");
					} else {
						String remainingTimeString = formatMillisToTime(remainingTimeMillis);
						descriptionLabel.setText("الوقت المتبقي: " + remainingTimeString + "  (أيام-ساعات-دقائق)");
					}
				});
				countdownTimer.start();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private long parseDateToMillis(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date parsedDate = dateFormat.parse(date);
			long millis = parsedDate.getTime();
			return millis;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private String formatMillisToTime(long millis) {
		long seconds = millis / 1000;
		long minutes = seconds / 60;
		long hours = minutes / 60;
		long days = hours / 24;

		String timeString = String.format("%02d:%02d:%02d:%02d", days, hours % 24, minutes % 60, seconds % 60);
		return timeString;
	}

	public void table_goals() {
		connector.Connect();
		try {
			pst = connector.con.prepareStatement(
					"SELECT id AS \"#\", name AS \"الاسم\", start_date AS \"تاريخ النهاية\" FROM goals WHERE start_date < CURDATE()");
			rs = pst.executeQuery();
			table1.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
