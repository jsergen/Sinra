package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import data.Komutlar;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial", "unused" })
public class Form_Giris extends JFrame {

	private JPanel contentPane;
	private JTextField txf_ad;
	private JPasswordField psf_sifre;

	String ka;
	String sifre;

	static Komutlar k = new Komutlar();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					baglantiKontrol();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void baglantiKontrol(){
		boolean bayrak = k.baglantiKontrol();
		if (bayrak == true) {
			Form_Giris frame = new Form_Giris();
			frame.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "Şifreniz hatalı, yeniden deneyin.");
			baglantiKontrol();
		}
	}
	
	
	/**
	 * Create the frame.
	 */
	public Form_Giris() {
		setTitle("Sinema Mecra");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblAd = new JLabel("Kullanıcı Adı");
		lblAd.setBounds(44, 51, 100, 15);
		contentPane.add(lblAd);

		JLabel lblSifre = new JLabel("Şifre");
		lblSifre.setBounds(44, 82, 70, 15);
		contentPane.add(lblSifre);

		txf_ad = new JTextField("");
		txf_ad.setBounds(162, 49, 114, 19);
		contentPane.add(txf_ad);
		txf_ad.setColumns(10);

		psf_sifre = new JPasswordField("");
		psf_sifre.setColumns(10);
		psf_sifre.setBounds(162, 80, 114, 19);
		contentPane.add(psf_sifre);

		JButton btn_Giris = new JButton("Giriş");

		btn_Giris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ka = txf_ad.getText();
				sifre = String.valueOf(psf_sifre.getPassword());
				if (!ka.equals("") && !sifre.equals("")) {
					
					boolean sonuc = k.girisKontrol(ka, sifre);
					if (sonuc == true) {
						Form_Ana fa = new Form_Ana();
						fa.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Kullanıcı adı veya Şifre hatalı!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Kullanıcı adı ve Şifre boş bırakılamaz!!");
				}
			}
		});
		btn_Giris.setBounds(162, 111, 114, 25);
		contentPane.add(btn_Giris);

		JLabel lblSinem = new JLabel("Sinra");
		lblSinem.setFont(new Font("Ani", Font.BOLD, 30));
		lblSinem.setBounds(113, 12, 93, 25);
		contentPane.add(lblSinem);
		
		
		//DIŞARIDAN GELEN METODLAR
		
	}
}
