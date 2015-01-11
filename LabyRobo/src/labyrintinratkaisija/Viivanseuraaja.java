package labyrintinratkaisija;

import laitehallinta.Moottorit;
import laitehallinta.Valolukija;
import lejos.nxt.Button;
import lejos.nxt.Sound;

/**
 * Luokka toteuttaa viivanseuraamistoiminnon.
 * @author Antti
 *
 */
public class Viivanseuraaja {
	
	private Valolukija valo;
	
	/**
	 * Luokalle välitetään valonlukija parametrina.
	 * @param v valonlukija
	 */
	public Viivanseuraaja(Valolukija v) {
		this.valo = v;
	}
	
	/**
	 * Seuraa viivaa loppumiseen asti ja korjaa ylimenneen liikkeen viivan yli.
	 * Viivan seuraaja kääntyy hieman oikealle, jos valosensori lukee teipin valoarvoa,
	 * ja hieman vasemmalle, jos ei.
	 */
	public void seuraaViivaLoppuun() {
		
		int kaantymisvoima = 80;

		while(true) {
			
			//Monta kierrosta ollaan liikuttu yhteen suuntaan.
			//Arvo vaihtuu, jos suunta vaihtuu.
			int kierrokset;
			if (!valo.onkoTeipilla()) {
				Moottorit.kaannyOikealle(kaantymisvoima);
		
				Moottorit.oikeaKierroksetNollaa();
				kierrokset = Moottorit.vasenKierrokset();
			} else {
				Moottorit.kaannyVasemmalle(kaantymisvoima);
				
				Moottorit.vasenKierroksetNollaa();
				kierrokset = Moottorit.oikeaKierrokset();
			}
			
			
			//Jos kierrokset menee yli 160, niin silloin ollaan teipin päässä.
			if (kierrokset > 160) {
				Moottorit.pysahdy();
				korjaaYlikaannos(kierrokset-40, 80);
				break;
			}
		}
		
	}
	
	private void korjaaYlikaannos(int kierrokset, int voima) {
		Moottorit.vasenKierroksetNollaa();
		Sound.playTone(500, 1000, 100);
		
		while(kierrokset * -1 < Moottorit.vasenKierrokset() && !Button.ENTER.isPressed()) {
			//korjataan taakseppäin ylimennyt
			Moottorit.kaannyTaakseppainVasemmalle(voima);
		}
		
		Moottorit.pysahdy();
	}

}
