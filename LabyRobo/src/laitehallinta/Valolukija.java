package laitehallinta;

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class Valolukija {
	
	private LightSensor sensori;
	private int teippiLattiaRajaarvo;
	
	public Valolukija(SensorPort s, int lattianValoarvo, int teipinValoarvo) {
		sensori = new LightSensor(s);
		sensori.setFloodlight(true);
		teippiLattiaRajaarvo = (lattianValoarvo-teipinValoarvo) / 2 + teipinValoarvo;
	}
	
	public boolean onkoTeipilla() {
		return sensori.getLightValue() < teippiLattiaRajaarvo;
	}

}
