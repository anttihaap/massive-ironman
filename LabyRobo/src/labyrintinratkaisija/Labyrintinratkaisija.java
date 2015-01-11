package labyrintinratkaisija;

import laitehallinta.Moottorit;
import laitehallinta.Pysaytyskuuntelija;
import laitehallinta.Robotti;
import laitehallinta.Valolukija;
import lejos.nxt.*;

/**
 * Pääluokka labyrintinratkaisijalle. Yhdistää kaikki toiminnot.
 * @author Antti
 * 
 */
public class Labyrintinratkaisija {

	private Valolukija valosensori;
	private Viivanseuraaja viivanseuraaja;
	private Logiikka logiikka;

	public Labyrintinratkaisija() {
		valosensori = new Valolukija();
		viivanseuraaja = new Viivanseuraaja(valosensori);
		logiikka = new Logiikka();
	}

	/**
	 * Aloittaa toiminnot.
	 */
	public void aloita() {
		// Luetaan valoarvot
		valosensori.lueValot();

		// Odotetaan käyttäjän napin pianallusta
		Robotti.tulostaJaOdotaPainallusta("Start ENTER");

		// Asetetaan napille enter pysäytyskuuntelija
		Button.ENTER.addButtonListener(new Pysaytyskuuntelija());

		ratkaise();
	}

	/**
	 * Aloittaa ratkaisemisen.
	 */
	private void ratkaise() {
		// Ratkaisun pää looppi. Ohjelman lopetus tapahtuu
		// Robotti.lopetaOhjelma() -metodin kautta,
		// eikä loopista poistuta muuten.
		while (true) {
			viivanseuraaja.seuraaViivaLoppuun();
			liikuRisteykseen();

			// Jos seuraava risteys on uusi risteys, lisätään logiikkaan
			// risteys.
			if (logiikka.seuraavaUusiRisteys()) {
				logiikka.lisaaUusiRisteys(uusiRisteys());
			}

			// Liikutaan logiikan antamaan suuntaan.
			kaannySuuntaanRisteydessa(logiikka.liikuSuuntaan());
		}
	}

	/**
	 * Etii risteyden kaikki suunnat ja palauttaa sen.
	 * @return Uusi risteys.
	 */
	private Risteys uusiRisteys() {

		int odotaKierroksen = 0;
		Risteys uusiRisteys = new Risteys();
		// Pyöritään 360 astetta etsien kaikki risteyden suunnat
		Moottorit.pyoriSuuntaan(true, 80);
		while (Moottorit.vasenKierrokset() < Suunnat.ympyra) {
			// Moottorin kierrokset yli odotettavan liikkeen ja musta teippi
			// löydett:
			if (odotaKierroksen < Moottorit.vasenKierrokset()
					&& valosensori.onkoTeipilla()) {
				int kierrokset = Moottorit.vasenKierrokset();
				int suunta = Suunnat.palautaSuunta(kierrokset);

				// Jos suunta on 2 (taakseppäin), se on robotin tulosuunta
				// risteykseen.
				if (suunta == 2) {
					uusiRisteys.lisaaTulosuunta(logiikka.palautaRobotinSuunta());
				} else {
					// Uusi suunta risteykselle
					Sound.playTone(1000, 100, 100);
					uusiRisteys.lisaaSuunta(logiikka.oikeaSuuntaRisteys(suunta));
				}
				odotaKierroksen = kierrokset + 200;
			}
		}

		Moottorit.pysahdy();
		return uusiRisteys;
	}

	/**
	 * Kääntää roboottia parametrin suuntaan. Suunnat: ylös 0, oikea 1, vasen -1, alas 2.
	 * @param suunta Suunta johon käännytään.
	 */
	private void kaannySuuntaanRisteydessa(int suunta) {
		// Suunta eteenpäin, ei tarvitse kääntyä;
		if (suunta == 0)
			return;

		//Haetaan moottorin kierroksen arvo raja-arvoon suuntaan.
		int kierroksetRajaan = Suunnat.palautaKierroksetRajaan(suunta);

		//Jos kierros rajaan on positiivinen, pyöritään oikealle, muuten vasemmalle.
		if (kierroksetRajaan > 0) {
			Moottorit.pyoriSuuntaan(true, 80);

			while (Moottorit.vasenKierrokset() < kierroksetRajaan) {
			}
		} else {
			Moottorit.pyoriSuuntaan(false, 80);
			while (Moottorit.vasenKierrokset() > kierroksetRajaan) {
			}
		}
		
		//Liikutaan raja-arvosta eteenpäin suunnan teippiin asti.
		while (!valosensori.onkoTeipilla()) {
		}

		Moottorit.pysahdy();
	}

	/**
	 * Liikkuu risteyksen keskelle ja samalla tarkistaa onko robotti maalissa.
	 */
	private void liikuRisteykseen() {
		int kierroksetRaja = 150;
		Moottorit.liikuEteenpain(80);
		while (Moottorit.vasenKierrokset() < kierroksetRaja) {
			if (valosensori.onkoMaalissa()) {
				Robotti.lopetaOhjelma("MAALI!");
			}
		}
		Moottorit.pysahdy();
	}
}