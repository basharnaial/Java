package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import java.sql.*;

public class FrameDashboard extends JFrame {

	private JPanel contentPane;

	private PanelTasks paneltasks;
	private PanelGoals panelgoals;
	private PanelNotes panelnotes;
	private PanelContact panelcontact;

	/**
	 * Launch the application.
	 */

	// Create an object from class to connect DB
	Connecter connector = new Connecter();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameDashboard frame = new FrameDashboard();
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
	public FrameDashboard() {
		setBackground(new Color(66, 190, 164));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 665);

//		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(18, 18, 18));
		contentPane.setBorder(new LineBorder(new Color(56, 142, 60), 2, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		paneltasks = new PanelTasks();
		paneltasks.setBounds(0, 0, 1079, 633);
		panelgoals = new PanelGoals();
		panelgoals.setBounds(0, 0, 1089, 661);
		panelnotes = new PanelNotes();
		panelnotes.setBounds(0, 0, 1089, 661);
		panelcontact = new PanelContact();
		panelcontact.setBounds(0, 0, 1089, 661);

		JPanel sidePremenu = new JPanel();
		sidePremenu.setBackground(new Color(56, 142, 60));
		sidePremenu.setBounds(1088, 0, 195, 700);
		contentPane.add(sidePremenu);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-14, -23, 253, 225);
		ImageIcon icon = new ImageIcon(FrameDashboard.class.getResource("/Images/superhero.jpg"));
		ImageIcon scaledIcon = new ImageIcon(icon.getImage().getScaledInstance(200, 190, Image.SCALE_SMOOTH));
		sidePremenu.setLayout(null);

		lblNewLabel.setIcon(scaledIcon);
		sidePremenu.add(lblNewLabel);

		JPanel tasks = new JPanel();
		tasks.setBounds(0, 185, 481, 62);
		tasks.addMouseListener(new PanelButtonMouseAdapter(tasks) {
			public void mouseClicked(MouseEvent e) {
				menuClicked(paneltasks);

			}
		});

		tasks.setBackground(new Color(156, 199, 158));
		tasks.setBorder(null);
		sidePremenu.add(tasks);
		tasks.setLayout(null);

		JLabel lbltasks = new JLabel("الرئيسية");
		lbltasks.setForeground(Color.WHITE);
		lbltasks.setHorizontalAlignment(SwingConstants.CENTER);
		lbltasks.setFont(new Font("Tajawal", Font.BOLD, 24));
		lbltasks.setBounds(-114, 3, 421, 62);
		tasks.add(lbltasks);

		JPanel goals = new JPanel();
		goals.setBounds(0, 286, 481, 62);
		goals.addMouseListener(new PanelButtonMouseAdapter(goals) {
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelgoals);

			}
		});

		goals.setBackground(new Color(156, 199, 158));
		goals.setBorder(null);
		sidePremenu.add(goals);
		goals.setLayout(null);

		JLabel lblgoals = new JLabel("الاهداف");
		lblgoals.setBackground(new Color(255, 163, 0));
		lblgoals.setBounds(-116, 0, 424, 62);
		lblgoals.setHorizontalAlignment(SwingConstants.CENTER);
		lblgoals.setForeground(Color.WHITE);
		lblgoals.setFont(new Font("Tajawal", Font.BOLD, 24));
		goals.add(lblgoals);

		JPanel notes = new JPanel();
		notes.setBounds(-1, 387, 481, 62);
		notes.addMouseListener(new PanelButtonMouseAdapter(notes) {
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelnotes);

			}
		});

		notes.setVisible(false);
		notes.setBackground(new Color(156, 199, 158));
		notes.setBorder(null);
		sidePremenu.add(notes);
		notes.setLayout(null);

		JLabel lblnotes = new JLabel("المصاريف(قريبا)");
		lblnotes.setBounds(-115, 0, 425, 62);
		lblnotes.setHorizontalAlignment(SwingConstants.CENTER);
		lblnotes.setForeground(Color.WHITE);
		lblnotes.setFont(new Font("Tajawal", Font.BOLD, 24));
		lblnotes.setBackground(new Color(255, 163, 0));
		notes.add(lblnotes);

		JPanel support = new JPanel();
		support.setBounds(0, 387, 481, 62);
		support.addMouseListener(new PanelButtonMouseAdapter(support) {
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelcontact);

			}
		});

		support.setBackground(new Color(156, 199, 158));
		support.setBorder(null);
		sidePremenu.add(support);
		support.setLayout(null);

		JLabel lblsupport = new JLabel("تواصل معنا");
		lblsupport.setBounds(-117, 0, 427, 62);
		lblsupport.setHorizontalAlignment(SwingConstants.CENTER);
		lblsupport.setForeground(Color.WHITE);
		lblsupport.setFont(new Font("Tajawal", Font.BOLD, 24));
		lblsupport.setBackground(new Color(255, 163, 0));
		support.add(lblsupport);

		JPanel logoutpannel = new JPanel();
		logoutpannel.setBounds(-14, 479, 481, 62);
		logoutpannel.addMouseListener(new PanelButtonMouseAdapter(logoutpannel) {
			public void mouseClicked(MouseEvent e) {
				FrameLogin framelogin = new FrameLogin();
				framelogin.setVisible(true);
				FrameDashboard.this.dispose();

				menuClicked(logoutpannel);

			}
		});

		logoutpannel.setLayout(null);
		logoutpannel.setBorder(null);
		logoutpannel.setBackground(new Color(255, 128, 128));
		sidePremenu.add(logoutpannel);

		JLabel logout = new JLabel("تسجيل الخروج");
		logout.setHorizontalAlignment(SwingConstants.CENTER);
		logout.setForeground(Color.WHITE);
		logout.setFont(new Font("Tajawal", Font.BOLD, 24));
		logout.setBackground(new Color(255, 128, 128));
		logout.setBounds(-98, 0, 422, 62);
		logoutpannel.add(logout);

		// اغلاق البرنامج
		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lbl_close.setFont(new Font("Montserrat", Font.PLAIN, 25));
		lbl_close.setForeground(Color.RED);
		lbl_close.setBounds(10, 11, 17, 21);
		contentPane.add(lbl_close);

		JPanel paneMainContent = new JPanel();
		paneMainContent.setBounds(0, 0, 1089, 661);
		contentPane.add(paneMainContent);
		paneMainContent.setLayout(null);

		paneMainContent.add(paneltasks);
		paneMainContent.add(panelgoals);
		paneMainContent.add(panelnotes);
		paneMainContent.add(panelcontact);
		paneMainContent.add(paneltasks);

		menuClicked(paneltasks);

	}

	public void menuClicked(JPanel panel) {
		paneltasks.setVisible(false);
		panelgoals.setVisible(false);
		panelnotes.setVisible(false);
		panelcontact.setVisible(false);

		panel.setVisible(true);

	}

	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panel;

		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}

		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(255, 186, 63));

		}

		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(156, 199, 158));
		}

		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60, 179, 113));

		}

		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(6, 3, 141));

		}
	}

}
