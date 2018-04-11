package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Form_Menu extends JFrame {

	private JPanel panelGiris;
	JPanel panelAna;
	private JTextField txfKullanici;
	private JPasswordField psfSifre;
	private JLabel lblbl;
	private JLabel lblss;
	private JButton btnGiris;

	Yordamlar yordam = new Yordamlar();

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
	public Form_Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 414);
		setTitle("Sinra");
		setResizable(false);

		panelAna = new JPanel();
		panelAna.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelAna);
		panelAna.setLayout(new CardLayout(0, 0));

		panelGiris = new JPanel();
		panelAna.add(panelGiris, "panel_ana");
		panelGiris.setLayout(null);

		// /////////////////////////
		// /// GİRİŞ //////////////
		// ///////////////////////
		lblbl = new JLabel("Kullanıcı Adı");
		lblbl.setBounds(326, 150, 100, 15);
		panelGiris.add(lblbl);

		lblss = new JLabel("Şifre");
		lblss.setBounds(326, 180, 100, 15);
		panelGiris.add(lblss);

		txfKullanici = new JTextField();
		txfKullanici.setBounds(444, 150, 114, 19);
		panelGiris.add(txfKullanici);
		txfKullanici.setColumns(10);

		psfSifre = new JPasswordField();
		psfSifre.setBounds(444, 180, 114, 19);
		panelGiris.add(psfSifre);
		psfSifre.setColumns(10);

		btnGiris = new JButton("Giriş Yap");
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean b = yordam.anaGiris(txfKullanici.getText(),
						String.valueOf(psfSifre.getPassword()));

				if (b == true) {
					CardLayout c = (CardLayout) (panelAna.getLayout());
					c.show(panelAna, "t1");
				}
			}
		});
		btnGiris.setBounds(444, 210, 114, 25);
		panelGiris.add(btnGiris);

		JPanel panel_main = new Panel_Main();
		panelAna.add(panel_main, "t1");

	}
}
