package labyrintinratkaisija;

import java.util.Stack;

/*
 * Pahasti kesken.
 */
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
		seuraavaUusiRisteys = false;
		risteydet.push(r);
	}
	
	   public int liikuSuuntaan() {
	        //Mennään uuteen risteykseen, mikäli ei palata taakseppäin.
	        seuraavaUusiRisteys = true;
	        Risteys r = risteydet.pop();
	        int seuraavaKaannos = r.palautaSuunta();
	        
	        //seuraava käännös alaspain, risteyden kaikki vaihtoehdot käyty
	        //risteys pois pinosta
	        if (seuraavaKaannos != 2) {
	            risteydet.push(r);
	        }
	        return palautaOikeaSuunta(seuraavaKaannos);
	    }
	    
	    public int palautaOikeaSuunta(int suunta) {
	        if (robotinSuunta == 0) return suunta;
	        if (robotinSuunta < 0) {
	            suunta +=1;
	            if (suunta == 3) {
	                suunta = -1;
	            }
	        } else {
	            for (int i = 0; i < robotinSuunta; i++) {
	                suunta -= 1;
	                if (suunta == -2) {
	                    suunta = 2;
	                }
	            }
	        }
	        return suunta;
	    }
	    
	    public void paivitaSuunta(int robotinKaannos) {
	        if (robotinKaannos == 0) return;
	        if (robotinKaannos < 0) {
	            robotinSuunta -=1;
	            if (robotinSuunta == -2) {
	                robotinSuunta = 2;
	            }
	        } else {
	            for (int i = 0; i < robotinKaannos; i++) {
	                robotinSuunta +=1;
	                if (robotinSuunta == 3) {
	                    robotinSuunta = -1;
	                }
	            }
	        }       
	    }

}