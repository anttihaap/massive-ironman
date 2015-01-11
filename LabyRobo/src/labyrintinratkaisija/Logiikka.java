package labyrintinratkaisija;

import java.util.Stack;

import laitehallinta.Robotti;

/**
 * Luokka pitää sisällään kaiken logiikan labyrintissa liikkumista varten.
 * Risteydet-pino pitää sisällään edellsiä risteyksiä.
 * 
 * @author Antti
 * 
 */
public class Logiikka {

	/**
	 * Pino, joka pitää sisällään edellisiä risteyksiä.
	 */
	private Stack<Risteys> risteydet;

	/**
	 * Onko seuraava risteys uusi risteys?
	 */
	private boolean seuraavaUusiRisteys;

	// ylos: 0, oikea: +1, vasen: -1, alas: +2
	/**
	 * Robotin tämän hetkinen suunta. Ylos: 0, oikea: +1, vasen -1, alas +2.
	 */
	private int robotinSuunta;

	public Logiikka() {
		risteydet = new Stack<Risteys>();
		seuraavaUusiRisteys = true;
		robotinSuunta = 0;
	}

	public boolean seuraavaUusiRisteys() {
		return seuraavaUusiRisteys;
	}

	public void lisaaUusiRisteys(Risteys r) {
		seuraavaUusiRisteys = true;
		risteydet.push(r);
	}

	/**
	 * Palauttaa suunnan mihin robotti liikkuu seuraavaksi.
	 * 
	 * @return Suunta.
	 */
	public int liikuSuuntaan() {
		// Otetaan edellinen risteys pinosta.
		Risteys r = risteydet.pop();

		// Pyydetään risteydeltä seuraava suunta ja käännetään se robotin
		// suunnan mukaan.
		int seuraavaKaannos = oikeaSuuntaKaannos(r.palautaSuunta());

		// Jos risteyksiä ei ole pinossa ja nykyisen risteyden kaikki suunnat on
		// käyty,
		// Labyrintilla ei ole ratkaisua: lopetetaan ohjelma.
		if (risteydet.isEmpty() && r.kaikkiKayty())
			Robotti.lopetaOhjelma("Ei ratkaisua!");

		// Seuraava käännös takaisin mistä tultiin risteykseen
		// Kaikki vaihtoehdot on käyty.
		if (r.kaikkiKayty()) {
			// Seuraava risteys ei siis ole uusi.
			seuraavaUusiRisteys = false;
		} else {
			// Muuten uusi risteys ja risteys takaisin stäkkiin.
			seuraavaUusiRisteys = true;
			risteydet.push(r);
		}
		paivitaRobotinSuunta(seuraavaKaannos);
		return seuraavaKaannos;
	}

	/**
	 * Palauttaa todelisen suunnan risteydelle (aloitussuunnan mukaisesti).
	 * 
	 * @param suunta
	 *            Robotin antama suunta
	 * @return Oikea suunta (aloitussuunan mukainen).
	 */
	public int oikeaSuuntaRisteys(int suunta) {
		return Suunnat.kaannaSuuntaa(suunta, robotinSuunta);
	}

	/**
	 * Kääntää todlelisen suunnan robotin suunnan mukaiseksi.
	 * 
	 * @param suunta
	 *            todellinen suunta
	 * @return robotin suunta
	 */
	public int oikeaSuuntaKaannos(int suunta) {
		return Suunnat.kaannaSuuntaa(suunta, robotinSuunta * -1);
	}

	/*
	 * Päivittää robotin suunnan. Eli kääntää robotinSuuntaa robotinKaannoksen
	 * verran.
	 */
	public void paivitaRobotinSuunta(int robotinKaannos) {
		robotinSuunta = Suunnat.kaannaSuuntaa(robotinSuunta, robotinKaannos);
	}

	public int palautaRobotinSuunta() {
		return robotinSuunta;
	}

}