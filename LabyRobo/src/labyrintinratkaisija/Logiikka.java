package labyrintinratkaisija;

import java.util.Stack;

import laitehallinta.Virhetilanne;

public class Logiikka {
	
	private Stack<Risteys> risteydet;
	private boolean seuraavaUusiRisteys;
	
	//ylos: 0, oikea: +1, vasen: -1, alas: +2
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
	
	public int liikuSuuntaan() {
	        Risteys r = risteydet.pop();
	        int seuraavaKaannos = oikeaSuuntaKaannos(r.palautaSuunta());
	        
	        if (risteydet.isEmpty() && r.kaikkiKayty()) Virhetilanne.virhe("ohi on");
	        
	        //Seurarava käännös takaisin mistä tultiin risteykseen
	        //Kaikki vaihtoehdot on käyty.
	        if (r.kaikkiKayty()) {
	        	//Seuraava risteys ei siis ole uusi.
	        	seuraavaUusiRisteys = false;
	        } else { 	
	        	//Muuten uusi risteys ja risteys takaisin stäkkiin.
	        seuraavaUusiRisteys = true;
	        risteydet.push(r);
	        }
	        paivitaRobotinSuunta(seuraavaKaannos);
	        return seuraavaKaannos;
	    }
	    
	    public int oikeaSuuntaRisteys(int suunta) {
	    	return Suunnat.kaannaSuuntaa(suunta, robotinSuunta);
	    }
	    
	    public int oikeaSuuntaKaannos(int suunta) {
	    	return Suunnat.kaannaSuuntaa(suunta, robotinSuunta * -1);
	    }
	    
	    /* 
	     * Päivittää robotin suunnan.
	     * Eli kääntää robotinSuuntaa robotinKaannoksen verran.
	     */
	    public void paivitaRobotinSuunta(int robotinKaannos) {
	    	robotinSuunta = Suunnat.kaannaSuuntaa(robotinSuunta, robotinKaannos);
	    }
	    
	    public int palautaRobotinSuunta() {
	    	return robotinSuunta;
	    }

}