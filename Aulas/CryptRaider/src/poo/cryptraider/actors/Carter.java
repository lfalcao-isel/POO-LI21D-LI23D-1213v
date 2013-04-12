package poo.cryptraider.actors;

import poo.cryptraider.CryptRaider;
import poo.cryptraider.Point;

public class Carter extends MovableActor {

	

	public Carter(char c, Point pos, CryptRaider game) {
		super(c, pos, game);
	}

	@Override
	public void move(char key) {
		switch(key) {
			case CryptRaider.UP : _direction = new Point(-1,0); break;
			case CryptRaider.DOWN : _direction = new Point(1,0); break;
			case CryptRaider.LEFT : _direction = new Point(0,-1); break;
			case CryptRaider.RIGHT : _direction = new Point(0,1); break;
		}
		
		_pos = _pos.add(_direction);
		
		_game.moveTo(this);
	}

	@Override
	public void colide(Actor a) {
		
	}
	
}
