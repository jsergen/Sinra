package kullanilmayan;

import gui.Panel_Entered;
import gui.Panel_Login;
import gui.Panel_Main;

import java.awt.CardLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel_Ana extends JPanel {

	JPanel panelAna;
	JPanel panel_login;
	JPanel panel_main;
	JPanel panel_entered;

	/**
	 * Create the panel.
	 */
	public Panel_Ana() {
		setBounds(100, 100, 900, 376);
		setLayout(new CardLayout(0, 0));

		panel_login = new Panel_Login();
		add(panel_login, "panel_login");

		panel_main = new Panel_Main();
		add(panel_main, "panel_main");

		panel_entered = new Panel_Entered();
		add(panel_entered, "panel_entered");

	}

}
