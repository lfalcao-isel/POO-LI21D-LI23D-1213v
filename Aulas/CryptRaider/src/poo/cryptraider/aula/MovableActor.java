package poo.cryptraider.aula;

public abstract class MovableActor extends Actor {

	public MovableActor(char c, Point pos, CryptRaider game) {
		super(c, pos, game);
	}

	public abstract void move(char key);
}
