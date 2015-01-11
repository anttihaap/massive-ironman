package laitehallinta;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;

/**
 * Pysäyttää ohjelman, kun nappia painetaan.
 * @author Antti
 *
 */
public class Pysaytyskuuntelija implements ButtonListener {

	@Override
	public void buttonPressed(Button b) {
		System.exit(0);
		
	}

	@Override
	public void buttonReleased(Button b) {
		// TODO Auto-generated method stub
		
	}

}
