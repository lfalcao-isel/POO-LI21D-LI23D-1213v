package poo.cryptraider.aula;

public class Space extends Actor {

	public Space(char c, Point pos, CryptRaider game) {
		super(c, pos, game);
	}

	@Override
	public void colide(Actor a) {
		_game.putActorInBoard(a);
		
		_pos = a.getPreviousPosition();
		_game.putActorInBoard(this);
	}

}
