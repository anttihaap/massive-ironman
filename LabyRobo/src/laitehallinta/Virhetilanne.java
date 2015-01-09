package laitehallinta;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Sound;

public class Virhetilanne {
	
	public static void virhe(String viesti) {
		Moottorit.pysahdy();
		LCD.clear();
		LCD.drawString(viesti, 0, 0);
		Sound.playTone(300, 3000);
		Button.waitForPress();
	}

}
