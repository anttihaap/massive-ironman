package main;

import labyrintinratkaisija.Labyrintinratkaisija;
import labyrintinratkaisija.Viivanseuraaja;
import laitehallinta.LaitePortit;
import laitehallinta.Moottorit;
import laitehallinta.Valolukija;
import lejos.nxt.*;

public class Main {
	
	public static void main (String[] aArg) {
		
		Labyrintinratkaisija ratkaisija = new Labyrintinratkaisija();
		

		ratkaisija.aloita();		
	}

}
