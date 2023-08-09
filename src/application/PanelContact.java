package application;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelContact extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelContact() {
		setBounds(0, 0, 1089, 661);
		setLayout(null);
		setVisible(true);
		JLabel lblNewLabel = new JLabel("تطوير وبرمجة بشار نيال - 4310757 - 0500061559");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(198, 181, 562, 255);
		add(lblNewLabel);

//		import java.io.File;
//		import java.io.IOException;
//
//		public class CreateFileExample {
//		    public static void main(String[] args) {
//		        try {
//		            File file = new File("example.txt");
//		            if (file.createNewFile()) {
//		                System.out.println("تم إنشاء الملف بنجاح.");
//		            } else {
//		                System.out.println("الملف موجود بالفعل.");
//		            }
//		        } catch (IOException e) {
//		            e.printStackTrace();
//		        }
//		    }
//		}

	}

}
