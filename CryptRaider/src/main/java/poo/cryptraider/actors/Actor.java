package poo.cryptraider.actors;

import poo.cryptraider.CryptRaider;
import poo.cryptraider.Point;
import poo.cryptraider.exceptions.InvalidCharActorException;

public abstract class Actor {
	private char _c;
	protected Point _pos;
	protected Point _direction;
	
	protected CryptRaider _game;
	
	
	public Actor(char c, Point pos, CryptRaider game) {
		_c = c;
		_game = game;
		_pos = pos;
		_direction = new Point(0,0);
	}
	
	public char getChar() {
		return _c;
	}
	
	public Point getPosition() { return _pos; }
	

	

	public void show() {
		System.out.print(_c);
	}

	public boolean colide(Actor a) {
		return false;
	}

	public void moveToPreviousPosition() {
		_pos = _pos.add(_direction.invert());
		
	}

	public Point getPreviousPosition() {
		return _pos.add(_direction.invert());
	}

	public static Actor createActor(char c, int row, int col, CryptRaider g) 
		throws InvalidCharActorException
	{
		switch(c) {
			case '#': return new Wall(c, new Point(row, col), g); 
			case '$': return new Stone(c, new Point(row, col), g);
			case ' ': return new Space(c, new Point(row, col), g);
			case 'C': return new Carter(c, new Point(row, col), g);
			case 'A': return new Artifact(c, new Point(row, col), g);
			case '*': return new Sand(c, new Point(row, col), g); 
			case 'P': return new Portal(c, new Point(row, col), g);
			case 'B': return new Bug(c, new Point(row, col), g);
			default:
				throw new InvalidCharActorException("Invalid char for actor: " +  c);
		}
	}

	public void setPosition(Point newPos) {
		_pos = newPos;
	}
}
