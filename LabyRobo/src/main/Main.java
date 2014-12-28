package main;

import labyrintinratkaisija.Labyrintinratkaisija;
import labyrintinratkaisija.Viivanseuraaja;
import laitehallinta.Moottorienhallinta;
import laitehallinta.Valolukija;
import lejos.nxt.*;

public class Main {
	
	static final MotorPort oikeaMoottori = MotorPort.C;
	static final MotorPort vasenMoottori = MotorPort.A;
	static final SensorPort valosensorinPortti = SensorPort.S3;
	
	public static void main (String[] aArg) {
		Labyrintinratkaisija ratkaisija = new Labyrintinratkaisija(oikeaMoottori, vasenMoottori, valosensorinPortti);
		
		LCD.drawString("Start ENTER", 0, 0);
		Button.waitForPress();
		LCD.clear();
		
		Button.ENTER.addButtonListener(new Pysaytyskuuntelija());
		
	
		ratkaisija.aloita();		
	}

}
