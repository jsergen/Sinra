package gui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Panel_Login extends JPanel {

	private JTextField txfKullanici;
	private JPasswordField psfSifre;
	private JLabel lblbl;
	private JLabel lblss;
	private JButton btnGiris;

	/**
	 * Create the panel.
	 * 
	 * @author thargalin;
	 */

	Yordamlar yordam = new Yordamlar();

	public Panel_Login() {
		setBounds(100, 100, 900, 376);
		setLayout(null);

		lblbl = new JLabel("Kullanıcı Adı");
		lblbl.setBounds(326, 150, 100, 15);
		add(lblbl);

		lblss = new JLabel("Şifre");
		lblss.setBounds(326, 180, 100, 15);
		add(lblss);

		txfKullanici = new JTextField();
		txfKullanici.setBounds(444, 150, 114, 19);
		add(txfKullanici);
		txfKullanici.setColumns(10);

		psfSifre = new JPasswordField();
		psfSifre.setBounds(444, 180, 114, 19);
		add(psfSifre);
		psfSifre.setColumns(10);

		btnGiris = new JButton("Giriş Yap");
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean b = yordam.anaGiris(txfKullanici.getText(),
						String.valueOf(psfSifre.getPassword()));
				if (b == true) {
					System.out.println("sssssssssss");
					Form_Menu fm = new Form_Menu();
					CardLayout c = (CardLayout) (fm.panel.getLayout());
					c.show(fm.panel, "pm");
				}
			}
		});
		btnGiris.setBounds(444, 210, 114, 25);
		add(btnGiris);
	}

}
