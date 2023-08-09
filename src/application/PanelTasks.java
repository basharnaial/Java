package application;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JDateChooser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;

public class PanelTasks extends JPanel {
	private JTextField titletask;
	private JTextField textField_1;
	private JTextField time_estimate;
	private JTextField destask;
	JDateChooser datestart;
	/**
	 * Create the panel.
	 */

	private JTable table1;
	boolean panelVisible = false;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private Connecter connector;
	// way 2: Create a object from class to connect DB (Connecter connector = new
	// Connecter();)
	private JTable table2;
	private JTable table3;

	public PanelTasks() {
		setToolTipText("ضع رقم المهمة");
		connector = new Connecter();
		// connector.Connect();
		setBounds(0, 0, 1089, 661);
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 193, 7), 4, true));
		panel.setBackground(new Color(254, 244, 195));
		panel.setBounds(12, 449, 1057, 201);
		add(panel);
		panel.setLayout(null);
		panel.setVisible(false);

		JLabel lblNewLabel = new JLabel("عنوان المهمة");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Tajawal", Font.BOLD, 20));
		lblNewLabel.setBounds(927, 55, 124, 25);
		panel.add(lblNewLabel);

		titletask = new JTextField();
		titletask.setForeground(Color.BLACK);
		titletask.setFont(new Font("Tajawal", Font.PLAIN, 11));
		titletask.setHorizontalAlignment(SwingConstants.RIGHT);
		titletask.setBackground(Color.WHITE);
		titletask.setBounds(728, 44, 204, 42);
		panel.add(titletask);
		titletask.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("وصف المهمة");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tajawal", Font.BOLD, 20));
		lblNewLabel_1.setBounds(593, 52, 125, 25);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("تاريخ البداية");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tajawal", Font.BOLD, 20));
		lblNewLabel_2.setBounds(923, 147, 125, 25);
		panel.add(lblNewLabel_2);

		JButton addtask = new JButton("أضف المهمة");
		addtask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean isInsertSuccessful = connector.insertTaskRecord(titletask.getText(), destask.getText(),
						datestart.getDate(), time_estimate.getText());
				if (isInsertSuccessful) {
					connector.table_load(table1);
					connector.table_late(table2);
					connector.table_completed(table3);

					JOptionPane.showMessageDialog(null, "تمت الاضافة!!!!!");

					titletask.setText("");
					destask.setText("");
					datestart.setDate(null);
					time_estimate.setText("");
					textField_1.setText("");
					titletask.requestFocus();

				}

			}
		});

		addtask.setBackground(new Color(30, 144, 255));
		addtask.setForeground(new Color(255, 255, 255));
		addtask.setFont(new Font("Tajawal", Font.PLAIN, 16));
		addtask.setBounds(24, 52, 154, 34);
		panel.add(addtask);

		JLabel lblNewLabel_2_1 = new JLabel("الوقت المقدر(يوم)");
		lblNewLabel_2_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("Tajawal", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(568, 145, 154, 25);
		panel.add(lblNewLabel_2_1);

		time_estimate = new JTextField();
		time_estimate.setHorizontalAlignment(SwingConstants.RIGHT);
		time_estimate.setForeground(Color.BLACK);
		time_estimate.setFont(new Font("Tajawal", Font.PLAIN, 11));
		time_estimate.setColumns(10);
		time_estimate.setBackground(Color.WHITE);
		time_estimate.setBounds(379, 139, 204, 42);
		panel.add(time_estimate);

		destask = new JTextField();
		destask.setHorizontalAlignment(SwingConstants.RIGHT);
		destask.setForeground(Color.BLACK);
		destask.setFont(new Font("Tajawal", Font.PLAIN, 11));
		destask.setColumns(10);
		destask.setBackground(Color.WHITE);
		destask.setBounds(379, 48, 204, 76);
		panel.add(destask);

		JButton clear = new JButton("مسح");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titletask.setText("");
				destask.setText("");
				datestart.setDate(null);
				time_estimate.setText("");
			}
		});
		clear.setForeground(new Color(255, 255, 255));
		clear.setFont(new Font("Tajawal", Font.PLAIN, 16));
		clear.setBackground(new Color(255, 0, 0));
		clear.setBounds(188, 52, 154, 34);
		panel.add(clear);

		datestart = new JDateChooser();
		datestart.setBounds(728, 139, 202, 42);
		panel.add(datestart);

		JButton btnNewButton_1 = new JButton("تحديث");
		btnNewButton_1.setBounds(189, 147, 154, 34);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean isUpdateSuccessful = connector.updateTask(titletask.getText(), destask.getText(),
						datestart.getDate(), time_estimate.getText(), textField_1.getText());

				if (isUpdateSuccessful) {
					JOptionPane.showMessageDialog(null, "تم التحديث!!!!!");
					connector.table_load(table1);
					connector.table_late(table2);
					connector.table_completed(table3);
					titletask.setText("");
					destask.setText("");
					datestart.setDate(null);
					time_estimate.setText("");
					textField_1.setText("");
					titletask.requestFocus();
				}

			}
		});
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Tajawal", Font.PLAIN, 22));
		btnNewButton_1.setBackground(new Color(213, 243, 246));

		JButton btnNewButton_1_1 = new JButton("حذف");
		btnNewButton_1_1.setBounds(24, 149, 155, 32);
		panel.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean isDeletedSuccessful = connector.deleteTask(textField_1.getText());
				if (isDeletedSuccessful) {
					JOptionPane.showMessageDialog(null, "تم الحذف!!!!!");
					connector.table_load(table1);
					connector.table_late(table2);
					connector.table_completed(table3);
					titletask.setText("");
					destask.setText("");
					datestart.setDate(null);
					time_estimate.setText("");
					textField_1.setText("");
					titletask.requestFocus();
				}

			}
		});
		btnNewButton_1_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1_1.setFont(new Font("Tajawal", Font.PLAIN, 22));
		btnNewButton_1_1.setBackground(new Color(213, 243, 246));

		JButton completed = new JButton("تعيين كمكتملة");
		completed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				boolean isSetCompleted = connector.setTaskCompleted(textField_1.getText());
				if (isSetCompleted) {
					JOptionPane.showMessageDialog(null, "تم التعيين كمكتملة!!!");
					connector.table_load(table1);
					connector.table_late(table2);
					connector.table_completed(table3);
					titletask.setText("");
					destask.setText("");
					datestart.setDate(null);
					time_estimate.setText("");
					textField_1.setText("");
					titletask.requestFocus();
				}

			}
		});
		completed.setForeground(Color.WHITE);
		completed.setFont(new Font("Tajawal", Font.PLAIN, 16));
		completed.setBackground(new Color(0, 128, 0));
		completed.setBounds(24, 102, 318, 34);
		panel.add(completed);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(214, 200, 246), 3));
		panel_2.setBackground(SystemColor.controlLtHighlight);
		panel_2.setBounds(670, 38, 399, 46);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("البحث (رقم ID)");
		lblNewLabel_3.setForeground(new Color(214, 200, 246));
		lblNewLabel_3.setBounds(253, 21, 136, 25);
		lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tajawal", Font.BOLD, 20));
		panel_2.add(lblNewLabel_3);

		textField_1 = new JTextField();
		textField_1.setToolTipText("10");
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String id = textField_1.getText();
					pst = connector.con
							.prepareStatement("select name, description, start_date, time from tasks where id = ?");
					pst.setString(1, id);
					ResultSet rs = pst.executeQuery();
					if (rs.next()) {
						panelVisible = !panelVisible;
						panel.setVisible(panelVisible);
						titletask.setText(rs.getString("name"));
						destask.setText(rs.getString("description"));
						datestart.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("start_date")));
						time_estimate.setText(rs.getString("time"));
					} else {
						titletask.setText("");
						destask.setText("");
						datestart.setDate(null);
						time_estimate.setText("");
					}
				} catch (SQLException | ParseException ex) {
					ex.printStackTrace();
				}

			}
		});
		textField_1.setBounds(61, 0, 182, 46);
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Tajawal", Font.PLAIN, 11));
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.info);
		panel_2.add(textField_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(670, 84, 399, 354);
		add(scrollPane);

		table1 = new JTable();
		table1.setFillsViewportHeight(true);
		table1.setColumnSelectionAllowed(true);
		table1.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table1);
		table1.setBackground(new Color(214, 200, 246));

		JButton button1 = new JButton("إضافة/تعديل مهمة");
		button1.setBackground(Color.ORANGE);
		button1.setForeground(Color.WHITE);
		button1.setFont(new Font("Tajawal", Font.BOLD, 18));
		button1.setBounds(868, 11, 201, 29);
		add(button1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(255, 0, 0), 3));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(343, 38, 317, 400);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("مهام متأخرة");
		lblNewLabel_4.setFont(new Font("Tajawal", Font.BOLD, 20));
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(191, 21, 116, 25);
		panel_1.add(lblNewLabel_4);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 47, 317, 382);
		panel_1.add(scrollPane_1);

		table2 = new JTable();
		table2.setForeground(new Color(255, 255, 255));
		table2.setFillsViewportHeight(true);
		table2.setColumnSelectionAllowed(true);
		table2.setCellSelectionEnabled(true);
		table2.setBackground(new Color(220, 20, 60));
		scrollPane_1.setViewportView(table2);

		connector.table_late(table2);

		int rowCount = table2.getRowCount();
		String rowCountString = Integer.toString(rowCount);
		JLabel lblNewLabel_4_1 = new JLabel(rowCountString);
		lblNewLabel_4_1.setForeground(Color.RED);
		lblNewLabel_4_1.setFont(new Font("Tajawal", Font.BOLD, 20));
		lblNewLabel_4_1.setBounds(165, 21, 30, 25);
		panel_1.add(lblNewLabel_4_1);

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelVisible = !panelVisible;
				panel.setVisible(panelVisible);
			}
		});

		connector.table_load(table1);
		int rowCount0 = table1.getRowCount();
		String rowCountString0 = Integer.toString(rowCount0);

		JLabel lblNewLabel_4_1_1 = new JLabel(rowCountString0);
		lblNewLabel_4_1_1.setForeground(new Color(214, 200, 246));
		lblNewLabel_4_1_1.setFont(new Font("Tajawal", Font.BOLD, 20));
		lblNewLabel_4_1_1.setBounds(29, 21, 30, 25);
		panel_2.add(lblNewLabel_4_1_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(144, 238, 144), 3, true));
		panel_3.setLayout(null);
		panel_3.setBackground(SystemColor.controlLtHighlight);
		panel_3.setBounds(12, 38, 317, 400);
		add(panel_3);

		JLabel lblNewLabel_4_2 = new JLabel("مهام مكتملة");
		lblNewLabel_4_2.setForeground(new Color(144, 238, 144));
		lblNewLabel_4_2.setFont(new Font("Tajawal", Font.BOLD, 20));
		lblNewLabel_4_2.setBounds(191, 21, 116, 25);
		panel_3.add(lblNewLabel_4_2);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 47, 317, 382);
		panel_3.add(scrollPane_3);

		table3 = new JTable();
		table3.setFillsViewportHeight(true);
		table3.setColumnSelectionAllowed(true);
		table3.setCellSelectionEnabled(true);
		table3.setBackground(new Color(144, 238, 144));
		scrollPane_3.setViewportView(table3);

		connector.table_completed(table3);
		int rowCount2 = table3.getRowCount();
		String rowCountString2 = Integer.toString(rowCount2);
		JLabel lblNewLabel_4_1_2 = new JLabel(rowCountString2);
		lblNewLabel_4_1_2.setForeground(new Color(144, 238, 144));
		lblNewLabel_4_1_2.setFont(new Font("Tajawal", Font.BOLD, 20));
		lblNewLabel_4_1_2.setBounds(175, 21, 30, 25);
		panel_3.add(lblNewLabel_4_1_2);

		setVisible(true);
	}

}