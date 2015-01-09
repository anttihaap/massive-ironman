package main;

import labyrintinratkaisija.Labyrintinratkaisija;
import labyrintinratkaisija.Viivanseuraaja;
import laitehallinta.Moottorit;
import laitehallinta.Valolukija;
import lejos.nxt.*;

public class Main {
	
	public static void main (String[] aArg) {
		Labyrintinratkaisija ratkaisija = new Labyrintinratkaisija();
		
		LCD.drawString("Start ENTER", 0, 0);
		Button.waitForPress();
		LCD.clear();
		
		Button.ENTER.addButtonListener(new Pysaytyskuuntelija());
		ratkaisija.aloita();		
	}

}
