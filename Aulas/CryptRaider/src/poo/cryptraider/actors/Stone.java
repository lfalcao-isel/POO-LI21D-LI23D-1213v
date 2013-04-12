package poo.cryptraider.actors;

import poo.cryptraider.CryptRaider;
import poo.cryptraider.Point;

public class Stone extends Actor {

	public Stone(char c, Point pos, CryptRaider game) {
		super(c, pos, game);
	}

	@Override
	public void colide(Actor a) {
		a.moveToPreviousPosition();
	}
}
