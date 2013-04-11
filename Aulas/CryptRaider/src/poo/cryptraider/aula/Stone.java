package poo.cryptraider.aula;

public class Stone extends Actor {

	public Stone(char c, Point pos, CryptRaider game) {
		super(c, pos, game);
	}

	@Override
	public void colide(Actor a) {
		a.moveToPreviousPosition();
	}
}
