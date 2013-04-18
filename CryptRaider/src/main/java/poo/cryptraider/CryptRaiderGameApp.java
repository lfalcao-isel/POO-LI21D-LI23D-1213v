package poo.cryptraider;

import poo.cryptraider.levels.Level1;

public class CryptRaiderGameApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CryptRaider c = new CryptRaider();
		c.start(new Level1());
		//c.start(new RaiderArtifaColisionLevel());
		

	}

}
