package labyrintinratkaisija;

import laitehallinta.Moottorienhallinta;
import laitehallinta.Valolukija;
import lejos.nxt.*;

public class Labyrintinratkaisija {
	
	private final int lattianValoarvo = 49;
	private final int teipinValoarvo = 39;
	private Moottorienhallinta moottorit;
	private Valolukija valosensori;
	private Viivanseuraaja viivanseuraaja;
	
	public Labyrintinratkaisija(MotorPort oikeaMoottori, MotorPort vasenMoottori, SensorPort valonPortti) {
		moottorit = new Moottorienhallinta(oikeaMoottori, vasenMoottori);
		valosensori = new Valolukija(valonPortti, lattianValoarvo, teipinValoarvo);
		viivanseuraaja = new Viivanseuraaja(moottorit, valosensori);
	}
	
	public void aloita() {		
		while (!Button.ENTER.isPressed()) {
		viivanseuraaja.seuraaViivaLoppuun();
		moottorit.liikuEteenpain(150, 80);
		etsiRisteydenHaarat();
		kaannySuuntaanRisteydessa(3);
		moottorit.pysahdy();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public void etsiRisteydenHaarat() {
		moottorit.vasenKierroksetNollaa();
		LCD.clear();
		
		int waitKaant = 0;
		boolean teipilla = valosensori.onkoTeipilla();
		String loppuSyote = "";
		while (moottorit.vasenKierrokset() < 1060) {
			if (waitKaant < moottorit.vasenKierrokset() && teipilla) {
				int kierrokset = moottorit.vasenKierrokset();
				if (kierrokset < 100) {
					loppuSyote += "y ";
				} else if (kierrokset < 364) {
					loppuSyote += "o ";
				} else if (kierrokset < 640) {
					loppuSyote += "a ";
				} else if (kierrokset < 900) {
					loppuSyote += "v ";
				}
				waitKaant = moottorit.vasenKierrokset() + 200;
				Sound.playTone(1000, 100, 100);
			}
			moottorit.pyoriSuuntaan(true, 80);
			teipilla = valosensori.onkoTeipilla();
		}
		
		LCD.drawString(loppuSyote, 0, 0);
		moottorit.pysahdy();
	}
	//suoraan: 0, oikea: 1, alas: 2, vasen: 3
	private void kaannySuuntaanRisteydessa(int suunta) {
		int kierroksetRajaan;
		if (suunta == 0) {
			kierroksetRajaan = 0;
		} else if (suunta == 1) {
			kierroksetRajaan = 100;
		} else if (suunta == 2) {
			kierroksetRajaan = 364;
		} else if (suunta == 3) {
			kierroksetRajaan = 640;
		} else {
			kierroksetRajaan = -1;
		}
		
		moottorit.vasenKierroksetNollaa();
		moottorit.pyoriSuuntaan(true, 80);
		while(moottorit.vasenKierrokset() < kierroksetRajaan) { }
		while(!valosensori.onkoTeipilla()) { }
	}

}
