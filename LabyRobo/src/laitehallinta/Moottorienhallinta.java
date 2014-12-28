package laitehallinta;

import java.util.Stack;

import lejos.nxt.MotorPort;

public class Moottorienhallinta {
	
	private MotorPort oikea;
	private MotorPort vasen;
	
	public Moottorienhallinta(MotorPort oikea, MotorPort vasen) {
		this.oikea = oikea;
		this.vasen = vasen;
	}
	
	public void kaannyOikealle(int voima) {
		oikea.controlMotor(0, 3);
		vasen.controlMotor(voima, 1);
	}
	
	public void kaannyVasemmalle(int voima) {
		oikea.controlMotor(voima, 1);
		vasen.controlMotor(0, 3);
	}
	
	public void kaannyTaakseppainVasemmalle(int voima) {
		oikea.controlMotor(0, 3);
		vasen.controlMotor(voima, 2);
	}
	
	public void liikuEteenpain(int kierrokset, int voima) {
		oikeaKierroksetNollaa();
		while (oikeaKierrokset() < kierrokset) {
			liikuEteenpain(voima);
		}

	}
	
	public void liikuEteenpain(int voima) {
		oikea.controlMotor(voima, 1);
		vasen.controlMotor(voima, 1);
	}
	
	public void pyoriSuuntaan(boolean oikealle, int voima) {
		int oikeaMode, vasenMode;
		if (!oikealle) {
			oikeaMode = 1;
			vasenMode = 2;
		} else {
			oikeaMode = 2;
			vasenMode = 1;
		}	
			oikea.controlMotor(voima, oikeaMode);
			vasen.controlMotor(voima, vasenMode);
		
	}
	
	public void pysahdy() {
		oikea.controlMotor(0, 3);
		vasen.controlMotor(0, 3);
		
	}
	
	public int vasenKierrokset() {
		return vasen.getTachoCount();
	}
	
	public void vasenKierroksetNollaa() {
		vasen.resetTachoCount();
	}
	
	public int oikeaKierrokset() {
		return oikea.getTachoCount();
	}
	
	public void oikeaKierroksetNollaa() {
		oikea.resetTachoCount();
	}

}
