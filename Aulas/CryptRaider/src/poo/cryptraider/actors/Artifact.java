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
		
		
	}
	
	
}
