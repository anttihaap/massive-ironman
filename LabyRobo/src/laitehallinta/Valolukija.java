package laitehallinta;

import lejos.nxt.*;

/**
 * Käyttää valosensoria ja pitää sisällään hyödyllisiä toimintoja
 * valoarvojen lukemiseen.
 */
public class Valolukija {
	
	private LightSensor sensori;
	
	private int teippi;
	private int lattia;
	private int maali;
	
	private int teippiLattiaRajaarvo;
	private int lattiaMaaliRajaarvo;
	
	public Valolukija() {
		sensori = new LightSensor(LaitePortit.valosensori);
		sensori.setFloodlight(true);
	}
	
	public void lueValot() {
		lueLattia();
		lueTeippi();
		lueMaali();
		
		//Asetetaan valojen raja-arvoja
		teippiLattiaRajaarvo = (lattia-teippi) / 2 + teippi;
		lattiaMaaliRajaarvo = (maali-lattia) / 2 + lattia;
		
		tarkistaValoarvojenEroavuus();
	}
	
	/**
	 * Lukee teipin valoarvon.
	 */
	private void lueTeippi() {
		Robotti.tulostaJaOdotaPainallusta("teippi");
		teippi = sensori.getLightValue();
	}
	
	/*
	 * Lukee lattian valoarvon.
	 */
	private void lueLattia() {
		Robotti.tulostaJaOdotaPainallusta("lattia");
		lattia = sensori.getLightValue();
	}
	
	/**
	 * Lukee maalin valoarvon.
	 */
	private void lueMaali() {
		Robotti.tulostaJaOdotaPainallusta("maali");
		maali = sensori.getLightValue();
	}
	
	/**
	 * Tarkistaa valoarvojen eroavuuden. Jos valoarvot eivät 
	 * eroa toisistaan tarpeeksi, ohjelma lopetetaan virheviestillä.
	 * Teipin tulee olla tummempi kuin lattian ja lattian tummempi kuin maalin.
	 */
	private void tarkistaValoarvojenEroavuus() {
		int valoarvojenPieninEro = 3;
		if (teippi + valoarvojenPieninEro >= lattia || lattia + valoarvojenPieninEro >= maali) {
			Robotti.lopetaOhjelma("Valoarvot ei kelpaa!");
		}
	}	
	
	public boolean onkoTeipilla() {
		return sensori.getLightValue() < teippiLattiaRajaarvo;
	}
	
	public boolean onkoMaalissa() {
		return sensori.getLightValue() > lattiaMaaliRajaarvo;
	}

}