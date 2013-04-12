package poo.cryptraider.actors;

import poo.cryptraider.CryptRaider;
import poo.cryptraider.Point;

public class Sand extends Actor {

	public Sand(char c, Point pos, CryptRaider game) {
		super(c, pos, game);
	}

	@Override
	public void colide(Actor a) {
		_game.putActorInBoard(a);
		
		_game.putActorInBoard(new Space(' ', a.getPreviousPosition(), _game));
		
	}

}
