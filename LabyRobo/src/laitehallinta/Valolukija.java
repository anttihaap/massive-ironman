package laitehallinta;

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class Valolukija {
	
	private LightSensor sensori;
	private int teippiLattiaRajaarvo;
	
	public Valolukija(int lattianValoarvo, int teipinValoarvo) {
		sensori = new LightSensor(LaitePortit.valosensori);
		sensori.setFloodlight(true);
		teippiLattiaRajaarvo = (lattianValoarvo-teipinValoarvo) / 2 + teipinValoarvo;
	}
	
	public boolean onkoTeipilla() {
		return sensori.getLightValue() < teippiLattiaRajaarvo;
	}

}
