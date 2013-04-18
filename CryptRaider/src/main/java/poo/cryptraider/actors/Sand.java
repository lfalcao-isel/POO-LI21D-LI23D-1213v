package poo.cryptraider.actors;

import poo.cryptraider.CryptRaider;
import poo.cryptraider.Point;

public class Sand extends Actor {

	public Sand(char c, Point pos, CryptRaider game) {
		super(c, pos, game);
	}

	@Override
	public boolean colide(Actor a) {
		if(a instanceof Carter) {
			_game.putActorInBoard(new Space(' ', _pos, _game));
			return true;
		}
		
		return false;
	}

}
