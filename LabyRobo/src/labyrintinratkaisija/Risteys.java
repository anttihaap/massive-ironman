package labyrintinratkaisija;

/**
 * Luokka kuvaa risteystä. Risteyteen voi lisätä uusia suunita, saada seuraavaksi mentävän risteyden
 * ja tietoa siitä, että onko kaikki risteyden suuntia käyty jo.
 * @author Antti
 *
 */
public class Risteys {
	
	private boolean oikea; //1
	private boolean ylos; //0
	private boolean vasen; //-1
	private boolean alas;
	private int tulosuunta;
	private boolean kaikkiKayty;
	
	/**
	 * Lisää risteykseen robotin tulosuunnan.
	 * @param tulosuunta Tulosuunta risteykseen.
	 */
	public void lisaaTulosuunta(int tulosuunta) {
		this.tulosuunta = tulosuunta;
	}
	
	
	/**
	 * Palauttaa robotin tulosuunnan risteykseen.
	 * @return robotin tulosuunta risteykseen
	 */
	public int palautaTulosuunta() {
		return this.tulosuunta;
	}
	
	
	/**
	 * Lisää risteykseen suunnan.
	 * @param suunta Uusi suunta.
	 */
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
	
	/**
	 * Palauttaa seuraavaksi käytävän suunnan. Sunnat palautetaan järjestyksessä oikea, ylös, vasen ja lopuksi tulosuunta.
	 * @return seuraava suunta
	 */
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
	
	/**
	 * Kertoo onko risteyksen kaikissa suunnissa käyty.
	 * @return onko kaikki suunnat käyty
	 */
	public boolean kaikkiKayty() {
		return kaikkiKayty;
	}
	
	/**
	 * Palauttaa merkkijonon risteyden tilasta. Palauttaa merkin suunnan, jos siellä ei ole käyty, ja lopuksi tulosuunnan.
	 */
	public String toString() { 
		String s = "";
		if (oikea) s+= "o";
		if (ylos) s+= "y";
		if (vasen) s+= "v";
		if (alas) s += "a";
		return s + " - t: " + tulosuunta;
	}

}
