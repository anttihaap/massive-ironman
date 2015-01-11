package labyrintinratkaisija;

import laitehallinta.Robotti;

/**
 * Luokka pitää sisällään suuntiin liittyvää toiminnallisuutta.
 * Muuntaa mm. moottirien kierroksia suunta numeroksi.
 * Suunta numerot: oikea 1, ylos 0, vasen -1, alas 2
 * @author Antti
 *
 */
public class Suunnat {
	
	/**
	 * Moottorin kierrokset suunnan ylös ja oikea välille.
	 */
	public static final int ylosOikeaVali = 100;
	/**
	 * Moottorin kierrokset suunnan oikea ja alas välille.
	 */
	public static final int oikeaAlasVali = 364;
	/**
	 * Moottorin kierrokset suunnan alas ja vasen välille.
	 */
	public static final int alasVasenVali = 640;
	/**
	 * Moottorin kierrokset suunnan vasen ja ylös välille.
	 */
	public static final int vasenYlosVali = 900;
	/**
	 * Moottorin kierrokset, joka vastaa robootin 360 asteen käännöstä.
	 */
	public static final int ympyra = 1060;
	
	/**
	 * Palauttaa suunnan numeron jota moottorin kierrokset vastaa.
	 * @param moottorinKierrokset
	 * @return Suunnan numero.
	 */
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
	
	/**
	 * Palauttaa suuntaa vastaavan raja-arvon moottorin kierroksina.
	 * @param suunta suunta numero
	 * @return moottorin kierrokset
	 */
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
			Robotti.lopetaOhjelma("kierroksetRajaan");
			return-1;
		}
	}
	
	/**
	 * Kääntää suuntaa kaannot verran. Jos suunta on negatiivinen, metodi kiertää suuntaa vasemmalle
	 * vähentäen suuntaa kaannot-parametrin itseisarvon verran. Jos suunta on positiivinen, metodi kääntää suuntaa
	 * oikealle suunta-arvon verran.
	 * @param suunta Kaannettava suunta.
	 * @param kaannot Kaannot.
	 * @return Käännetty suunta.
	 */
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