package laitehallinta;

import lejos.nxt.MotorPort;

/**
 * Luokka hallitsee robotin molempia moottoreita.
 * @author Antti
 *
 */
public final class Moottorit {

	/**
	 * Oikea moottori.
	 */
	private static final MotorPort oikea = LaitePortit.moottoriOikea;
	
	/**
	 * Vasen moottori.
	 */
	private static final MotorPort vasen = LaitePortit.moottoriVasen;

	/**
	 * Asettaa moottori tilaan, jossa se kääntyy oikealle ja asettaa voimaksi parametrin voima verran.
	 * @param voima Moottorin voima.
	 */
	public static void kaannyOikealle(int voima) {
		oikea.controlMotor(0, 3);
		vasen.controlMotor(voima, 1);
	}
	/**
	 * Asettaa moottori tilaan, jossa se kääntyy vasemmalle ja asettaa voimaksi parametrin voima verran.
	 * @param voima Moottorin voima.
	 */
	public static void kaannyVasemmalle(int voima) {
		oikea.controlMotor(voima, 1);
		vasen.controlMotor(0, 3);
	}

	/**
	 * Asettaa moottorit tilaan, jossa se kääntyy vasemmalle taakseppäin. Moottorin voimaksi asetetaan voima-parametrin avo
	 * @param voima Moottorin voima.
	 */
	public static void kaannyTaakseppainVasemmalle(int voima) {
		oikea.controlMotor(0, 3);
		vasen.controlMotor(voima, 2);
	}

	/**
	 * Liikkuu eteenpäin kierrokset-parametrin verran. Asettaa moottorien voimaksi voima-parametrin arvon.
	 * @param kierrokset Kuinka monta moottorin kierrosta liikutaan eteenpäin.
	 * @param voima Moottorien voima.
	 */
	public static void liikuEteenpain(int kierrokset, int voima) {
		oikeaKierroksetNollaa();
		while (oikeaKierrokset() < kierrokset) {
			liikuEteenpain(voima);
		}
		oikeaKierroksetNollaa();
		pysahdy();

	}

	/**
	 * Asettaa moottorit tilaan, jossa se liikkyy eteenpäin voima-parametrin voimalla.
	 * @param voima voima
	 */
	public static void liikuEteenpain(int voima) {
		oikea.controlMotor(voima, 1);
		vasen.controlMotor(voima, 1);
	}

	/**
	 * Asettaa moottorin tilaan, jossa se pyörii ympyrää.
	 * @param oikealle Pyöriikö oikealle. Tosi = pyörii oikealle, epätosi = pyörii vasemmalle.
	 * @param voima Moottorille asetettava voima pyörimisen ajaksi.
	 */
	public static void pyoriSuuntaan(boolean oikealle, int voima) {
		int oikeaMode = 2;
		int vasenMode = 1;
		if (!oikealle) {
			oikeaMode = 1;
			vasenMode = 2;
		}
		oikea.controlMotor(voima, oikeaMode);
		vasen.controlMotor(voima, vasenMode);
	}

	
	/**
	 * Pysäyttää moottorit ja nollaa molempien moottorien kierrokset.
	 */
	public static void pysahdy() {
		oikea.controlMotor(0, 3);
		vasen.controlMotor(0, 3);
		oikeaKierroksetNollaa();
		vasenKierroksetNollaa();
	}

	/**
	 * Palauttaa vasemman moottorin kierrosluvun.
	 * @return kierrokset
	 */
	public static int vasenKierrokset() {
		return vasen.getTachoCount();
	}

	
	/**
	 * Nollaa vasemman moottorin kierrosluvun.
	 */
	public static void vasenKierroksetNollaa() {
		vasen.resetTachoCount();
	}
	
	
	/**
	 * Palauttaa oikean moottorin kierrosluvun.
	 * @return kierrokset
	 */
	public static int oikeaKierrokset() {
		return oikea.getTachoCount();
	}

	/**
	 * Nollaa vasemman moottorin kierrosluvun.
	 */
	public static void oikeaKierroksetNollaa() {
		oikea.resetTachoCount();
	}

}