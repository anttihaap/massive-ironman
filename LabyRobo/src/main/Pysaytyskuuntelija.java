package main;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;

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
