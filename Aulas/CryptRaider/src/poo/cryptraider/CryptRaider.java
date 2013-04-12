package poo.cryptraider;

import java.util.Scanner;

import poo.cryptraider.actors.Actor;
import poo.cryptraider.actors.Artifact;
import poo.cryptraider.actors.Carter;
import poo.cryptraider.actors.MovableActor;
import poo.cryptraider.actors.Portal;
import poo.cryptraider.actors.Sand;
import poo.cryptraider.actors.Space;
import poo.cryptraider.actors.Stone;
import poo.cryptraider.actors.Wall;
import poo.cryptraider.levels.Level;

public class CryptRaider {
	public static final char UP = 'w';
	public static final char DOWN = 's';
	public static final char LEFT = 'a';
	public static final char RIGHT = 'd';

	Board _board;
	
	
	Scanner _input = new Scanner(System.in);
	
	public void loadLevel(Level level) {
		_board = level.getBoard();
	}
	
	

	public void moveActors(char c) {
		_board.moveActors(c);
	}

	private char readKey() {
		return _input.next().charAt(0);
	}

	private void showBoard() {
		for(int row = 0; row < _actorsBoard.length; ++ row) {
			for(int col = 0; col < _actorsBoard[0].length; ++ col) {
				//System.out.print(_board[row][col].getChar());
				_actorsBoard[row][col].show();
			}
			System.out.println();
		}
		
		System.out.println();
		
	}

	
	public void start(Level level) {
		loadLevel(level);
		
		while(true) {
			showBoard();
			char c = readKey();
			moveActors(c);
		}
	}

	public void moveTo(Actor a) {
		Point p = a.getPosition();
		Actor colidedActor = getActor(p);
		colidedActor.colide(a);
	}
	
	

	public void putActorInBoard(Actor a) {
		Point p = a.getPosition();
		_actorsBoard[p.getRow()][p.getCol()] = a;
		
	}
	
	public Actor getActor(Point p) {
		return _actorsBoard[p.getRow()][p.getCol()];
	}

}
