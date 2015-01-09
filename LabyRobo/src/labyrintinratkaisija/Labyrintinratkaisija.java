package labyrintinratkaisija;

import laitehallinta.Moottorit;
import laitehallinta.Nuku;
import laitehallinta.Valolukija;
import lejos.nxt.*;

public class Labyrintinratkaisija {
	
	private final int lattianValoarvo = 49;
	private final int teipinValoarvo = 39;
	private Valolukija valosensori;
	private Viivanseuraaja viivanseuraaja;
	private Logiikka logiikka;
	
	public Labyrintinratkaisija() {
		valosensori = new Valolukija(lattianValoarvo, teipinValoarvo);
		viivanseuraaja = new Viivanseuraaja(valosensori);
		logiikka = new Logiikka();
	}
	
	public void aloita() {
		while (true) {
		viivanseuraaja.seuraaViivaLoppuun();
		//Liikutaan risteyksen keskelle
		Moottorit.liikuEteenpain(150, 80);
		Moottorit.pysahdy();
		String tuloste = "";
		if (logiikka.seuraavaUusiRisteys()) {
			Risteys lisattavaRisteys = uusiRisteys();
			tuloste += lisattavaRisteys.toString() + " ";
			logiikka.lisaaUusiRisteys(lisattavaRisteys);
		}
	
		int suunta = logiikka.liikuSuuntaan();
		LCD.clear();
		LCD.drawString(tuloste + "r:" + logiikka.palautaRobotinSuunta() + "s:" + suunta, 0, 0);
		//Nuku.nuku(1000);
		kaannySuuntaanRisteydessa(suunta);
		}
	}
	
	private Risteys uusiRisteys() {
		Moottorit.vasenKierroksetNollaa();
		int odotaKierroksen = 0;
		Risteys uusiRisteys = new Risteys();
		//Pyöritään 360 astetta etsien kaikki risteyden suunnat
		Moottorit.pyoriSuuntaan(true, 80);
		while (Moottorit.vasenKierrokset() < Suunnat.ympyra) {
			//Moottorin kierrokset yli odotettavan liikkeen ja musta teippi löydett:
			if (odotaKierroksen < Moottorit.vasenKierrokset() && valosensori.onkoTeipilla()) {
				int kierrokset = Moottorit.vasenKierrokset();
				int suunta = Suunnat.palautaSuunta(kierrokset);
				
				//Jos suunta on 2 (taakseppäin), se on robotin tulosuunta risteykseen. 
				if (suunta == 2) {
					uusiRisteys.lisaaTulosuunta(logiikka.palautaRobotinSuunta());
				} else {
					//Uusi suunta risteykselle
					Sound.playTone(1000, 100, 100);
					uusiRisteys.lisaaSuunta(logiikka.oikeaSuuntaRisteys(suunta));
				}
				odotaKierroksen = kierrokset + 200;		
			}
		}
		
		Moottorit.pysahdy();
		return uusiRisteys;
	}
	//suoraan: 0, oikea: 1, alas: 2, vasen: -1
	private void kaannySuuntaanRisteydessa(int suunta) {
		//Suunta eteenpäin, ei tarvitse kääntyä;
		if (suunta == 0) return;
		
		int kierroksetRajaan = Suunnat.palautaKierroksetRajaan(suunta);
		
		Moottorit.vasenKierroksetNollaa();
		
		if (kierroksetRajaan > 0) {
		Moottorit.pyoriSuuntaan(true, 80);
		
		while(Moottorit.vasenKierrokset() < kierroksetRajaan) { }
		} else {
			Moottorit.pyoriSuuntaan(false, 80);
			while(Moottorit.vasenKierrokset() > kierroksetRajaan) { }
		}
		while(!valosensori.onkoTeipilla()) { }
		
		Moottorit.pysahdy();
	}
}