package poo.cryptraider.actors;

import poo.cryptraider.CryptRaider;
import poo.cryptraider.Point;

public abstract class MovableActor extends Actor {

	public MovableActor(char c, Point pos, CryptRaider game) {
		super(c, pos, game);
	}

	public abstract void move(char key);
}
