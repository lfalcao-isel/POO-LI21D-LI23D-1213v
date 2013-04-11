package poo.cryptraider.aula;

public class Wall extends Actor {

	public Wall(char c, Point pos, CryptRaider game) {
		super(c, pos, game);
	}

	@Override
	public void colide(Actor a) {
		a.moveToPreviousPosition();
		
	}
}
