package poo.cryptraider.actors;

import poo.cryptraider.CryptRaider;
import poo.cryptraider.Point;

public abstract class MovableActor extends Actor {

	protected static final Point NO_DIR = new Point(0,0);
	protected static final Point RIGHT_DIR = new Point(0,1);
	protected static final Point LEFT_DIR = new Point(0,-1);
	protected static final Point DOWN_DIR = new Point(1,0);
	protected static final Point UP_DIR = new Point(-1,0);

	public MovableActor(char c, Point pos, CryptRaider game) {
		super(c, pos, game);
	}

	public abstract void move();
}
