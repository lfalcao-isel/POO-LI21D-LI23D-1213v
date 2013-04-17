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
		_board = level.getBoard(this);
	}
	
	

	public void moveActors(char c) {
		_board.moveActors(c);
	}

	private char readKey() {
		return _input.next().charAt(0);
	}

	
	
	public void start(Level level) {
		loadLevel(level);
		
		while(true) {
			_board.showBoard();
			char c = readKey();
			moveActors(c);
		}
	}

	public boolean moveTo(Actor a, Point pos) {
		Actor colidedActor = _board.getActor(pos);
		return colidedActor.colide(a);
	}
	
	

	public void changeActor(Actor a, Point pos) {
		_board.changeActor(a, pos);
		
	}

	public void putActorInBoard(Actor a) {
		_board.putActorInBoard(a);
	}

	public Actor getActor(Point pos) {
		return _board.getActor(pos);
	}
}
