package poo.cryptraider.levels;

import poo.cryptraider.Board;
import poo.cryptraider.CryptRaider;
import poo.cryptraider.actors.Actor;

public abstract class Level {
	
	protected abstract Board getBoard(CryptRaider game);
	
	protected Board getBoard(String[] levelStr, CryptRaider game) {
		Actor[][] actors = getActors(levelStr, game);
		Board b = new Board(actors);
		return b;

	}
	
	private Actor[][] getActors(String[] levelStrs, CryptRaider game) {
		int width = levelStrs[0].length();
		Actor[][] actors = new Actor[levelStrs.length][width];
		
		
		for(int row = 0; row < levelStrs.length; ++ row) {
			String rowStr = levelStrs[row]; 
			for(int col = 0; col < width; ++ col) {
				char c = rowStr.charAt(col);
				actors[row][col] = Actor.createActor(c, row, col, game);
			}
		}
		
		return actors;

	}

	
}
