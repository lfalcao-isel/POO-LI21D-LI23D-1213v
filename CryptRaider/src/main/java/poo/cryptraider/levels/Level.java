package poo.cryptraider.levels;

import poo.cryptraider.Board;
import poo.cryptraider.CryptRaider;
import poo.cryptraider.actors.Actor;
import poo.cryptraider.exceptions.CryptRaiderException;
import poo.cryptraider.exceptions.InvalidCharActorException;
import poo.cryptraider.exceptions.LoadLevelException;

public abstract class Level {
	
	protected abstract String[] getLevel() throws CryptRaiderException;
	
	public Board getBoard(CryptRaider game) throws CryptRaiderException {
		String[] levelStr = getLevel();
		Actor[][] actors = getActors(levelStr, game);
		Board b = new Board(actors);
		return b;

	}
	
	private Actor[][] getActors(String[] levelStrs, CryptRaider game) throws InvalidCharActorException {
		int width = levelStrs[0].length();
		Actor[][] actors = new Actor[levelStrs.length][width];
		
		
		for(int row = 0; row < levelStrs.length; ++ row) {
			String rowStr = levelStrs[row]; 
			for(int col = 0; col < width; ++ col) {
				char c = rowStr.charAt(col);
				
				try {
					actors[row][col] = Actor.createActor(c, row, col, game);
				} catch (InvalidCharActorException e) {
					System.out.println(e.toString() + ". Creating a Wall instead at row " + row + " - col " + col);
					//e.printStackTrace();
					actors[row][col] = Actor.createActor('#', row, col, game);
				}
			}
		}
		return actors;
	}
}
