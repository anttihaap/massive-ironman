package laitehallinta;

import lejos.nxt.MotorPort;

public final class Moottorit {

	private static final MotorPort oikea = LaitePortit.moottoriOikea;
	private static final MotorPort vasen = LaitePortit.moottoriVasen;

	public static void kaannyOikealle(int voima) {
		oikea.controlMotor(0, 3);
		vasen.controlMotor(voima, 1);
	}

	public static void kaannyVasemmalle(int voima) {
		oikea.controlMotor(voima, 1);
		vasen.controlMotor(0, 3);
	}

	public static void kaannyTaakseppainVasemmalle(int voima) {
		oikea.controlMotor(0, 3);
		vasen.controlMotor(voima, 2);
	}

	public static void liikuEteenpain(int kierrokset, int voima) {
		oikeaKierroksetNollaa();
		while (oikeaKierrokset() < kierrokset) {
			liikuEteenpain(voima);
		}
		oikeaKierroksetNollaa();
		pysahdy();

	}

	public static void liikuEteenpain(int voima) {
		oikea.controlMotor(voima, 1);
		vasen.controlMotor(voima, 1);
	}

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

	public static void pysahdy() {
		oikea.controlMotor(0, 3);
		vasen.controlMotor(0, 3);
		oikeaKierroksetNollaa();
		vasenKierroksetNollaa();
	}

	public static int vasenKierrokset() {
		return vasen.getTachoCount();
	}

	public static void vasenKierroksetNollaa() {
		vasen.resetTachoCount();
	}

	public static int oikeaKierrokset() {
		return oikea.getTachoCount();
	}

	public static void oikeaKierroksetNollaa() {
		oikea.resetTachoCount();
	}

}