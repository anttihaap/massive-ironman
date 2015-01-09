package labyrintinratkaisija;

import laitehallinta.Virhetilanne;

public class Suunnat {
	
	public static final int ylosOikeaVali = 100;
	public static final int oikeaAlasVali = 364;
	public static final int alasVasenVali = 640;
	public static final int vasenYlosVali = 900;
	public static final int ympyra = 1060;
	
	public static int palautaSuunta(int moottorinKierrokset) {
		if (moottorinKierrokset < ylosOikeaVali) {
			return 0; //ALAS
		} else if (moottorinKierrokset < oikeaAlasVali) {
			return 1; //OIKEA
		} else if (moottorinKierrokset < alasVasenVali) {
			return 2;
		} else if (moottorinKierrokset < vasenYlosVali) {
			return -1;
		}
		//Arvo ei kelpaa
		return -999;
	}
	
	public static int palautaKierroksetRajaan(int suunta) {
		if (suunta == 0) {
			return 0;
		} else if (suunta == 1) {
			return ylosOikeaVali;
		} else if (suunta == 2) {
			return oikeaAlasVali;
		} else if (suunta == -1) {
			return -ylosOikeaVali;
		} else {
			Virhetilanne.virhe("kierroksetRajaan");
			return-1;
		}
	}
	
	public static int kaannaSuuntaa(int suunta, int kaannot) {
		for (int i = 0; i < Math.abs(kaannot); i++) {
			if (kaannot > 0) {
				suunta++;
				if (suunta == 3) suunta = -1;
			} else {
				suunta--;
				if (suunta == -2) suunta = 2;
			}
		}
		return suunta;
	}
}