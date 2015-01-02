package testit;

import org.junit.Test;

import junit.framework.TestCase;
import labyrintinratkaisija.Risteys;

public class RisteysTesti2 extends TestCase {
	
	Risteys risteys;

	public RisteysTesti2(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void palauttaaSuunnanAlasKunEiMuuta() {
		assertEquals(true, false);
	}

}
