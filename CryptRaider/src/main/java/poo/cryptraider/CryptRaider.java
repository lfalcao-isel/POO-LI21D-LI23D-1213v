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
import poo.cryptraider.exceptions.CryptRaiderException;
import poo.cryptraider.exceptions.LoadLevelException;
import poo.cryptraider.levels.Level;
import poo.cryptraider.viewers.ConsoleViewer;
import poo.cryptraider.viewers.Viewer;

public class CryptRaider {
	public static final char UP = 'w';
	public static final char DOWN = 's';
	public static final char LEFT = 'a';
	public static final char RIGHT = 'd';

	Board _board;
	String _keys = "";
	
	private Viewer[] _viewers;
	
	
	Scanner _input = new Scanner(System.in);
	
	public void loadLevel(Level level) throws CryptRaiderException  {
		_board = level.getBoard(this);
	}
	
	

	private char readKey() {
		return _input.next().charAt(0);
	}
	
	public void fireInitLevel() {
		for(int i = 0; i < _viewers.length; ++i) {
			_viewers[i].initLevel(this);
		}
		
	}

	public void fireShowBoard() {
		for(int i = 0; i < _viewers.length; ++i) {
			_viewers[i].update(this);
		}
	}
	
	public void fireActorsMoved(Actor... a) {
		for(int i = 0; i < _viewers.length; ++i) {
			_viewers[i].actorsChanged(a);
		}
	}

	public void fireInitGame() {
		for(int i = 0; i < _viewers.length; ++i) {
			_viewers[i].initGame(this);
		}
	}

	
	
	public void moveActors() {
		_board.moveActors();
	}

	public void start(Level level, Viewer... viewers) throws CryptRaiderException  {
		_viewers = viewers;
		Score s = new Score();
		
		
		s.loadHighScore();
		loadLevel(level);
		fireInitGame();
		
		while(true) {
			fireShowBoard();
			waitForNextFrame(1000/30);
			moveActors();
			
			if(endLevel()) {
				loadNextLevel();
			}
			
			if(gameEnded()) {
				s.save();
				return;
			}
		}
	}

	private boolean gameEnded() {
		// TODO Auto-generated method stub
		return false;
	}



	private void loadNextLevel() {
		
	}



	private boolean endLevel() {
		return false;
	}



	private void waitForNextFrame(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			System.exit(-1);
		}
	}

	public boolean moveTo(Actor a, Point pos) {
		Actor colidedActor = _board.getActor(pos);
		return colidedActor.colide(a);
	}
	
	

	public void changeActor(Actor a, Point pos) {
		_board.changeActor(a, pos);
		fireActorsMoved(a, actorToChange);
		
	}

	public void putActorInBoard(Actor a) {
		_board.putActorInBoard(a);
	}

	public Actor getActor(Point pos) {
		return _board.getActor(pos);
	}



	public void addKey(char key) {
		_keys += key;
		
	}



	public char getKey() {
		if(_keys.length() == 0)
			return 0;
		char key = _keys.charAt(0);
		_keys = _keys.substring(1);
		return key;
	}



	public Board getBoard() {
		return _board;
	}
}
