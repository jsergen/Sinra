package data;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

public class Komutlar implements iKomutlar {
	// /////////////////////////////
	// / BAĞLANTI AYARLARI////////
	// ///////////////////////////
	private String kullanici_adi = "root";
	private String sifre = "";
	private String host = "127.0.0.1";
	private String db = "sine_data";
	private int port = 3306;

	private java.sql.Connection conn = null;

	// /////////////////////////////
	// / METOD DEĞİŞKENLERİ///////
	// ///////////////////////////
	ResultSet result = null;
	java.sql.PreparedStatement ps = null;
	DefaultListModel<String> DML = null;

	public Komutlar() {

	}

	public String veritabaniSifresi() {
		String ss = JOptionPane.showInputDialog("Şifreyi girin");
		this.sifre = ss;
		return sifre;
	}

	@Override
	public void baglantiAc() {
		String url = "jdbc:mysql://" + host + ":" + port + "/" + db
				+ "?useSSL=false";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// System.out.println(sifre);
			conn = DriverManager.getConnection(url, kullanici_adi, sifre);
			// System.out.println("Veritabanı Girişi Başarılı");
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql Connector Yok");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Bağlantı Başarısız");
			e.printStackTrace();
		}
	}

	@Override
	public void baglantiKapat() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean baglantiKontrol() {
		veritabaniSifresi();
		baglantiAc();
		if (conn != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean girisKontrol(String kull_ad, String sifre) {

		boolean bayrak = false;
		try {
			baglantiAc();
			ps = conn
					.prepareStatement("SELECT * FROM kullanici WHERE kullanici_ad=? AND kullanici_sifre=?");
			ps.setString(1, kull_ad);
			ps.setString(2, sifre);
			result = ps.executeQuery();
			if (result.next()) {
				bayrak = true;
			}
			baglantiKapat();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bayrak;
	}

	public ListModel<String> listele() {
		try {
			baglantiAc();
			String sorgu = "SELECT * FROM filmler";
			ps = conn.prepareStatement(sorgu);
			result = ps.executeQuery();
			DML = new DefaultListModel<String>();
			while (result.next()) {
				DML.addElement(result.getString(2));
			}
			baglantiKapat();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DML;

	}

	@Override
	public void filmEkle(String filmAdi, String yonetmen, String yazar,
			String tur, String sure, String yas_siniri) {
		try {
			baglantiAc();
			String sorgu = "INSERT INTO filmler (film_id, film_ad, yonetmen, yazar, tur, sure, yas_siniri) VALUES (NULL, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sorgu);
			ps.setString(1, filmAdi);
			ps.setString(2, yonetmen);
			ps.setString(3, yazar);
			ps.setString(4, tur);
			ps.setString(5, sure);
			ps.setString(6, yas_siniri);
			ps.execute();
			baglantiKapat();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
