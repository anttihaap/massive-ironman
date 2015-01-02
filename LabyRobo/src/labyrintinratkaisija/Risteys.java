package labyrintinratkaisija;

public class Risteys {
	
	private boolean oikea; //1
	private boolean ylos; //0
	private boolean vasen; //-1
	
	public void lisaaSuunta(int suunta) {
		if (suunta == 1) {
			oikea = true;
		} else if (suunta == 0) {
			ylos = true;
		} else if (suunta == -1) {
			vasen = true;
		}
	}
	
	public int palautaSuunta() {
		if (oikea) {
			oikea = false;
			return 1;
		} else if (ylos) {
			ylos = false;
			return 0;
		} else if (vasen) {
			vasen = false;
			return -1;
		} else {
			return 2;
		}
	}
	
	public String toString() {
		String s = "";
		if (oikea) s+= "o";
		if (ylos) s+= "y";
		if (vasen) s+= "v";
		return s;
	}

}
