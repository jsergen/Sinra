package gui;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Panel_Main extends JPanel {

	private JButton btnFilmEkle;
	private JButton btnGuncelle;
	private JLabel lblBaslik;
	private JLabel lblFilmAdi;
	private JLabel lblYonetmen;
	private JLabel lblYazar;
	private JLabel lblTur;
	private JLabel lblSure;
	private JLabel lblYasSiniri;
	private JScrollPane scrollPane;
	private JList<String> listFilm;

	/**
	 * Create the panel.
	 */

	Yordamlar yordam = new Yordamlar();
	data.Komutlar komut = new data.Komutlar();

	public Panel_Main() {
		setBounds(100, 100, 900, 376);
		setLayout(null);

		btnFilmEkle = new JButton("Film Ekle");
		btnFilmEkle.setFont(new Font("Dialog", Font.BOLD, 11));
		btnFilmEkle.setBounds(12, 339, 136, 25);
		add(btnFilmEkle);

		btnGuncelle = new JButton("Listeyi Güncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuncelle.setFont(new Font("Dialog", Font.BOLD, 11));
		btnGuncelle.setBounds(160, 339, 136, 25);
		add(btnGuncelle);

		lblBaslik = new JLabel("Film Bilgileri");
		lblBaslik.setFont(new Font("Dialog", Font.BOLD, 15));
		lblBaslik.setBounds(314, 13, 284, 15);
		add(lblBaslik);

		lblFilmAdi = new JLabel("Adı: ");
		lblFilmAdi.setBounds(324, 40, 274, 15);
		add(lblFilmAdi);

		lblYonetmen = new JLabel("Yönetmen: ");
		lblYonetmen.setBounds(324, 67, 274, 15);
		add(lblYonetmen);

		lblYazar = new JLabel("Yazar: ");
		lblYazar.setBounds(324, 94, 274, 15);
		add(lblYazar);

		lblTur = new JLabel("Tür: ");
		lblTur.setBounds(324, 121, 274, 15);
		add(lblTur);

		lblSure = new JLabel("Süre: ");
		lblSure.setBounds(324, 148, 274, 15);
		add(lblSure);

		lblYasSiniri = new JLabel("Yaş Sınırı: ");
		lblYasSiniri.setBounds(324, 175, 274, 15);
		add(lblYasSiniri);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 284, 314);
		add(scrollPane);

		listFilm = new JList<String>();
		scrollPane.setViewportView(listFilm);

		listFilm.setModel(komut.listele());
	}
}
