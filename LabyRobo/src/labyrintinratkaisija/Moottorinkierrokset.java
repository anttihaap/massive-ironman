package labyrintinratkaisija;

public class Moottorinkierrokset {
	
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

}
