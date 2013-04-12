package poo.cryptraider.test;

import poo.cryptraider.Board;
import poo.cryptraider.CryptRaider;
import poo.cryptraider.levels.Level;

public class RaiderArtifaColisionLevel extends Level {

	@Override
	public Board getBoard(CryptRaider game) {
		
		return getBoard(new String[] {
				"######", 
				"# CA #",
				"######" },
			game);
	}

}
