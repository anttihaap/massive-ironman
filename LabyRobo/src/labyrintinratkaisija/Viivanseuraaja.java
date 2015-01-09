package labyrintinratkaisija;

import laitehallinta.Moottorit;
import laitehallinta.Valolukija;
import lejos.nxt.Button;
import lejos.nxt.Sound;

public class Viivanseuraaja {
	
	private Valolukija valo;
	
	public Viivanseuraaja(Valolukija v) {
		this.valo = v;
	}
	
	public void seuraaViivaLoppuun() {
		Moottorit.vasenKierroksetNollaa();
		Moottorit.oikeaKierroksetNollaa();
		
		int kaantymisvoima = 80;
		
		while(true) {
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
