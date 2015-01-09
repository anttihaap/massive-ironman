package labyrintinratkaisija;

import laitehallinta.Virhetilanne;

public class Risteys {
	
	private boolean oikea; //1
	private boolean ylos; //0
	private boolean vasen; //-1
	private boolean alas;
	private int tulosuunta;
	private boolean kaikkiKayty;
	
	public void lisaaTulosuunta(int tulosuunta) {
		this.tulosuunta = tulosuunta;
	}
	
	public int palautaTulosuunta() {
		return this.tulosuunta;
	}
	
	public void lisaaSuunta(int suunta) {
		if (suunta == 1) {
			oikea = true;
		} else if (suunta == 0) {
			ylos = true;
		} else if (suunta == -1) {
			vasen = true;
		} else if (suunta == 2) {
			alas = true;
		} 
	}
	
	public int palautaSuunta() {
		if (oikea) {
			oikea = false;
			return 1;
		} else if (ylos) {
			ylos = false;
			return 0;
		} else if (vasen) {
			vasen = false;
			return -1;
		} else if (alas) {
			alas = false;
			return 2;
		} else {
			//Viimeinen käännos on 180 astetta tulosuunnasta.
			//Eli käännetään tulosuuntaa 2 kertaa ja palautetaan käännetty
			//suunta.
			kaikkiKayty = true;
			return Suunnat.kaannaSuuntaa(tulosuunta, 2);
		}
	}
	
	public boolean kaikkiKayty() {
		return kaikkiKayty;
	}
	
	
	public String toString() { 
		String s = "";
		if (oikea) s+= "o";
		if (ylos) s+= "y";
		if (vasen) s+= "v";
		if (alas) s += "a";
		return s + " - t: " + tulosuunta;
	}

}
