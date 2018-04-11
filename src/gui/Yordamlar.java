package gui;

import javax.swing.JOptionPane;

import kullanilmayan.Form_Giris;
import data.Komutlar;

public class Yordamlar {

	static Komutlar k = new Komutlar();

	String ka, sifre;

	public Yordamlar() {

	}

	@SuppressWarnings("unused")
	private void baglantiKontrol() {
		boolean bayrak = k.baglantiKontrol();
		if (bayrak == true) {
			Form_Giris frame = new Form_Giris();
			frame.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null,
					"Şifreniz hatalı, yeniden deneyin.");
			baglantiKontrol();
		}
	}

	public boolean anaGiris(String ka, String sifre) {
		if (!ka.equals("") && !sifre.equals("")) {
			boolean sonuc = k.girisKontrol(ka, sifre);
			if (sonuc == true) {
				return true;
			} else {
				JOptionPane.showMessageDialog(null,
						"Kullanıcı adı veya Şifre hatalı!");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"Kullanıcı adı ve Şifre boş bırakılamaz!!");
			return false;
		}

	}

}
