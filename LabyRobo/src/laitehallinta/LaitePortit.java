package laitehallinta;

import lejos.nxt.MotorPort;
import lejos.nxt.SensorPort;

/**
 * Luokka pitää sisällään tiedot käytettävien laitteiden porteista.
 * @author Antti
 *
 */
public final class LaitePortit {

	/**
	 * Oikean moottorin portti.
	 */
	public final static MotorPort moottoriOikea = MotorPort.C;
	/**
	 * Vasemman moottorin portti.
	 */
	public final static MotorPort moottoriVasen = MotorPort.A;
	/**
	 * Valosensorin portti.
	 */
	public final static SensorPort valosensori = SensorPort.S3;
	
}
