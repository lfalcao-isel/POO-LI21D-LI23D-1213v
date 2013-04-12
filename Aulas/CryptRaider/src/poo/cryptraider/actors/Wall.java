package poo.cryptraider.actors;

import poo.cryptraider.CryptRaider;
import poo.cryptraider.Point;
import poo.cryptraider.actors.Actor;

public class Wall extends Actor {

	public Wall(char c, Point pos, CryptRaider game) {
		super(c, pos, game);
	}

	@Override
	public void colide(Actor a) {
		a.moveToPreviousPosition();
		
	}
}
