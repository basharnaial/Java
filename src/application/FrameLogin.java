package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FrameLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtemail;
	private JTextField password;
	private JLabel lbl_loginmessage = new JLabel("");

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private Connecter connector;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameLogin() {
		connector = new Connecter();
		connector.Connect();

		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 581);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 495, 573);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(-263, 0, 824, 393);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(FrameLogin.class.getResource("/Images/image-asset.png")));

		JLabel lblNewLabel_3 = new JLabel("Your limitation");
		lblNewLabel_3.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 24));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(SystemColor.text);
		lblNewLabel_3.setBounds(138, 425, 233, 28);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel(" it's only your imagination");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Montserrat Light", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(96, 464, 312, 28);
		panel.add(lblNewLabel_3_1);

		// اغلاق البرنامج
		JLabel lbl_close = new JLabel("X");
		lbl_close.setBounds(10, 11, 65, 56);
		panel.add(lbl_close);
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 46));
		lbl_close.setForeground(new Color(255, 163, 0));

		Button button = new Button("تسجيل الدخول");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username1 = txtemail.getText();
				String password1 = password.getText();
				boolean isLoginSuccessful = connector.loginChecker(username1, password1);
				if (isLoginSuccessful) {
					lbl_loginmessage.setText("");
					JOptionPane.showMessageDialog(null, "تم الدخول بنجاح");

					FrameDashboard framedashboard = new FrameDashboard();
					framedashboard.setVisible(true);
					FrameLogin.this.dispose();
				} else if (username1.equals("") || username1.equals("Email") || password1.equals(" ")
						|| password1.equals("Password")) {
					lbl_loginmessage.setText("الرجاء تعبئة جميع الحقول المطلوبة!");

				} else {
					lbl_loginmessage.setText("اسم المستخدم أو كلمة المرور غير صحيحة، حاول مجددًا");
				}

			}
		});
		button.setForeground(SystemColor.text);
		button.setFont(new Font("Tajawal Light", Font.PLAIN, 14));
		button.setBackground(new Color(56, 142, 60));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(526, 435, 408, 42);
		contentPane.add(button);

		txtemail = new JTextField();
		txtemail.setHorizontalAlignment(SwingConstants.RIGHT);
		txtemail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtemail.getText().equals("Username")) {
					txtemail.setText("");
				} else {
					txtemail.selectAll();

				}
			}
		});
		txtemail.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		txtemail.setToolTipText("اكتب اسم المستخدم");
		txtemail.setBounds(526, 229, 408, 56);
		contentPane.add(txtemail);
		txtemail.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.ORANGE);
		separator.setBounds(526, 282, 408, 2);
		contentPane.add(separator);

		JLabel lblNewLabel = new JLabel("البريد الالكتروني");
		lblNewLabel.setFont(new Font("Tajawal", Font.PLAIN, 11));
		lblNewLabel.setBounds(861, 204, 76, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("كلمة المرور");
		lblNewLabel_1.setFont(new Font("Tajawal", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(881, 311, 53, 14);
		contentPane.add(lblNewLabel_1);

		password = new JPasswordField();
		password.setFont(new Font("Montserrat Light", Font.BOLD, 11));
		password.setHorizontalAlignment(SwingConstants.RIGHT);
		password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (password.getText().equals("Password")) {
					password.setText("");
				} else {
					password.selectAll();

				}
			}
		});
		password.setToolTipText("اكتب كلمة المرور");
		password.setColumns(10);
		password.setBounds(526, 338, 408, 56);
		contentPane.add(password);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(526, 392, 408, 2);
		contentPane.add(separator_1);

		lbl_loginmessage.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_loginmessage.setVerticalAlignment(SwingConstants.TOP);
		lbl_loginmessage.setForeground(Color.RED);
		lbl_loginmessage.setFont(new Font("Tajawal Black", Font.PLAIN, 11));
		lbl_loginmessage.setBounds(526, 415, 408, 14);
		contentPane.add(lbl_loginmessage);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(FrameLogin.class.getResource("/Images/icon-color.png")));
		lblNewLabel_4.setBounds(453, 62, 537, 92);
		contentPane.add(lblNewLabel_4);
	}
}