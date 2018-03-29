package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Form_Film_Ekle extends JFrame {

	private JPanel contentPane;
	private JTextField txf_film;
	private JTextField txf_yonetmen;
	private JTextField txj_yazar;
	private JTextField txj_sure;
	private JTextField txf_tur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Film_Ekle frame = new Form_Film_Ekle();
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
	public Form_Film_Ekle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 304, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblFilminAd = new JLabel("Filmin Adı");
		lblFilminAd.setBounds(29, 12, 70, 15);
		contentPane.add(lblFilminAd);
		
		JLabel lblYnetmen = new JLabel("Yönetmen");
		lblYnetmen.setBounds(29, 39, 78, 15);
		contentPane.add(lblYnetmen);
		
		JLabel lblYazar = new JLabel("Yazar");
		lblYazar.setBounds(29, 66, 70, 15);
		contentPane.add(lblYazar);
		
		JLabel lblSre = new JLabel("Süre");
		lblSre.setBounds(29, 93, 70, 15);
		contentPane.add(lblSre);
		
		JLabel lblTr = new JLabel("Tür");
		lblTr.setBounds(29, 120, 70, 15);
		contentPane.add(lblTr);
		
		JLabel lblDurum = new JLabel("Durum");
		lblDurum.setBounds(29, 147, 70, 15);
		contentPane.add(lblDurum);
		
		JLabel lblResim = new JLabel("Resim");
		lblResim.setBounds(29, 174, 70, 15);
		contentPane.add(lblResim);
		
		txf_film = new JTextField();
		txf_film.setBounds(144, 10, 142, 19);
		contentPane.add(txf_film);
		txf_film.setColumns(10);
		
		txf_yonetmen = new JTextField();
		txf_yonetmen.setBounds(144, 37, 142, 19);
		contentPane.add(txf_yonetmen);
		txf_yonetmen.setColumns(10);
		
		txj_yazar = new JTextField();
		txj_yazar.setBounds(144, 64, 142, 19);
		contentPane.add(txj_yazar);
		txj_yazar.setColumns(10);
		
		txj_sure = new JTextField();
		txj_sure.setBounds(144, 91, 142, 19);
		contentPane.add(txj_sure);
		txj_sure.setColumns(10);
		
		txf_tur = new JTextField();
		txf_tur.setBounds(144, 118, 142, 19);
		contentPane.add(txf_tur);
		txf_tur.setColumns(10);
		
		JComboBox cb_durum = new JComboBox();
		cb_durum.setBounds(144, 142, 142, 20);
		contentPane.add(cb_durum);
		
		JButton btnResimAl = new JButton("Resim Al");
		btnResimAl.setBounds(144, 169, 142, 25);
		contentPane.add(btnResimAl);
		
		JButton btnEkle = new JButton("Film Listesine Ekle");
		btnEkle.setBounds(29, 206, 257, 25);
		contentPane.add(btnEkle);
		
		
		
		
		
	}
}
