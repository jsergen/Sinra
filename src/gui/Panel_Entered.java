package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class Panel_Entered extends JPanel {

	/**
	 * Create the panel.
	 */
	public Panel_Entered() {
		setBounds(100, 100, 900, 376);
		setLayout(null);
		
		JLabel lbl = new JLabel("Film Girişi Yapın");
		lbl.setFont(new Font("Dialog", Font.BOLD, 21));
		lbl.setBounds(32, 12, 219, 40);
		add(lbl);

	}
}
