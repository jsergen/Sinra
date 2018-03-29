package data;

import javax.swing.ListModel;


public interface iKomutlar {
	
	public void baglantiAc();
	
	public void baglantiKapat();
	
	public boolean baglantiKontrol();
	
	public String veritabaniSifresi();
	
	public boolean girisKontrol(String kull_ad, String sifre);
	
	public ListModel<String> listele();
	
	public void filmEkle(String filmAdi, String yonetmen, String yazar, String tur, String sure, String yas_siniri);

	
}
