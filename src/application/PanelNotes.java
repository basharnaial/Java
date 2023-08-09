package application;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelNotes extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelNotes() {
		setBounds(0, 0, 1089, 661);
		setLayout(null);
		setVisible(true);
		JLabel lblNewLabel = new JLabel("This Notes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 95));
		lblNewLabel.setBounds(144, 181, 562, 255);
		add(lblNewLabel);

	}

}
