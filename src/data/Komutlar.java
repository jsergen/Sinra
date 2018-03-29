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

	@Override
	public void baglantıAc() {
		String url = "jdbc:mysql://" + host + ":" + port + "/" + db;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			sifre = JOptionPane.showInputDialog("Şifreyi girin");
			conn = DriverManager.getConnection(url, kullanici_adi, sifre);
			System.out.println("Veritabanı Girişi Başarılı");
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql Connector Yok");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Bağlantı Başarısız");
			e.printStackTrace();
		}
	}

	@Override
	public void baglantıKapat() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean girisKontrol(String kull_ad, String sifre) {

		boolean bayrak = false;
		try {
			baglantıAc();
			ps = conn
					.prepareStatement("SELECT * FROM kullanici WHERE kullanici_ad=? AND kullanici_sifre=?");
			ps.setString(1, kull_ad);
			ps.setString(2, sifre);
			result = ps.executeQuery();
			if (result.next()) {
				bayrak = true;
			}
			baglantıKapat();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bayrak;
	}

	public ListModel<String> listele() {
		try {
			baglantıAc();
			String sorgu = "SELECT * FROM filmler";
			ps = conn.prepareStatement(sorgu);
			result = ps.executeQuery();
			DML = new DefaultListModel<String>();
			while (result.next()) {
				DML.addElement(result.getString(2));
			}
			baglantıKapat();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DML;

	}

}
