package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.CardLayout;

import kullanilmayan.Panel_Ana;

@SuppressWarnings("serial")
public class Form_Menu extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Menu frame = new Form_Menu();
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

	JPanel panel;
	
	JPanel panel_login;
	JPanel panel_main;
	JPanel panel_entered;

	public Form_Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 414);
		setTitle("Sinra");
		setResizable(false);

		panel = new Panel_Ana();
		setContentPane(panel);
		panel.setLayout(new CardLayout(0, 0));
		getContentPane();
		
		panel_login = new Panel_Login();
		add(panel_login, "pl");

		panel_main = new Panel_Main();
		add(panel_main, "pm");

		panel_entered = new Panel_Entered();
		add(panel_entered, "pe");

	}
}
