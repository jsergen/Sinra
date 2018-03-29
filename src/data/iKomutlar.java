package data;

import javax.swing.ListModel;


public interface iKomutlar {
	
	public void baglantıAc();
	
	public void baglantıKapat();
	
	public boolean girisKontrol(String kull_ad, String sifre);
	
	public ListModel<String> listele();

}
