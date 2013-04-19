package poo.cryptraider.actors;

import poo.cryptraider.CryptRaider;
import poo.cryptraider.Point;

public class Artifact extends MovableActor {

	public Artifact(char c, Point pos, CryptRaider game) {
		super(c, pos, game);
		_direction = DOWN_DIR;
	}

	@Override
	public void move(char key) {
		Point pos = _pos.add(_direction);
		if(_game.moveTo(this, pos))
			_game.changeActor(this, pos);
		
		
	}
	
	@Override
	public boolean colide(Actor a) {
		if(a instanceof Carter) {
			Point pos = _pos.add(a._direction);
			if(_game.moveTo(this, pos))
				_game.changeActor(this, pos);
			return true;
		}
		return false;
		
		
	}
	
	
}
