package kullanilmayan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;

import data.Komutlar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Form extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame = new Form();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	JList<String> listFilm;
	Komutlar k = new Komutlar();
	private JScrollPane scrollPane;
	private JList<String> list;

	public Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		listFilm = new JList<String>();
		listFilm.setBounds(0, 0, 194, 247);
		contentPane.add(listFilm);

		listFilm.setModel(k.listele());

		JButton btnFilmEkle = new JButton("Film Ekle");
		btnFilmEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Form_Film_Ekle ffe = new Form_Film_Ekle();
				ffe.setVisible(true);
			}
		});
		btnFilmEkle.setBounds(12, 259, 194, 25);
		contentPane.add(btnFilmEkle);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(240, 12, 369, 247);
		contentPane.add(scrollPane);
		
		list = new JList<String>();
		scrollPane.setViewportView(list);
	}

}
