package laitehallinta;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Sound;

/**
 * Luokka sisältää pieniä hyödyllisiä robotin toimintoja. Kaikki metodit ovat
 * static-tyyppisiä.
 * 
 * @author Antti
 * 
 */
public class Robotti {

	/**
	 * Tulostaa viestin, odottaa käyttäjän napinpainallusta ja lopettaa
	 * ohjelman.
	 * 
	 * @param viesti
	 */
	public static void lopetaOhjelma(String viesti) {
		Moottorit.pysahdy();

		tulosta(viesti);

		Sound.playTone(300, 3000);

		Button.waitForPress();
		System.exit(0);
	}

	/**
	 * Nukkuu aikaMS verran.
	 * 
	 * @param aikaMS
	 *            aika millisekuntteina
	 */
	public static void nuku(int aikaMS) {
		try {
			Thread.sleep(aikaMS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void tulostaJaOdotaPainallusta(String viesti) {
		tulosta(viesti);
		Button.waitForPress();
	}

	public static void tulosta(String viesti) {
		LCD.clear();
		LCD.drawString(viesti, 0, 0);
	}

}
