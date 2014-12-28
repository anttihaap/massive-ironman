package labyrintinratkaisija;

import laitehallinta.Moottorienhallinta;
import laitehallinta.Valolukija;
import lejos.nxt.Button;
import lejos.nxt.Sound;

public class Viivanseuraaja {
	
	private Moottorienhallinta moottori;
	private Valolukija valo;
	
	public Viivanseuraaja(Moottorienhallinta m, Valolukija v) {
		this.moottori = m;
		this.valo = v;
	}
	
	public void seuraaViivaLoppuun() {
		int kaantymisvoima = 80;
		
		while(true) {
			int tachoArvo;
			if (!valo.onkoTeipilla()) {
				moottori.kaannyOikealle(kaantymisvoima);
		
				moottori.oikeaKierroksetNollaa();
				tachoArvo = moottori.vasenKierrokset();
			} else {
				moottori.kaannyVasemmalle(kaantymisvoima);
				
				moottori.vasenKierroksetNollaa();
				tachoArvo = moottori.oikeaKierrokset();
			}
			
			if (tachoArvo > 120) {
				korjaaYlikaannos(tachoArvo-40, 80);
				break;
			}
		}
		
	}
	
	private void korjaaYlikaannos(int kierrokset, int voima) {
		moottori.vasenKierroksetNollaa();
		Sound.playTone(500, 1000, 100);
		
		while(kierrokset * -1 < moottori.vasenKierrokset() && !Button.ENTER.isPressed()) {
			//korjataan taakseppäin ylimennyt
			moottori.kaannyTaakseppainVasemmalle(voima);
		}
	}

}
