package poo.cryptraider.actors;

import poo.cryptraider.CryptRaider;
import poo.cryptraider.Point;

public class Carter extends MovableActor {

	

	public Carter(char c, Point pos, CryptRaider game) {
		super(c, pos, game);
	}

	@Override
	public void move() {
		char key = _game.getKey();
		switch(key) {
			case CryptRaider.UP : _direction = UP_DIR; break;
			case CryptRaider.DOWN : _direction = DOWN_DIR; break;
			case CryptRaider.LEFT : _direction = LEFT_DIR; break;
			case CryptRaider.RIGHT : _direction = RIGHT_DIR; break;
			default: _direction = NO_DIR;
		}

		Point pos = _pos.add(_direction);
		if(_game.moveTo(this, pos))
			_game.changeActor(this, pos);
	}
}
