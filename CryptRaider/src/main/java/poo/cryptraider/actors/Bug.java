package poo.cryptraider.actors;

import poo.cryptraider.CryptRaider;
import poo.cryptraider.Point;

public class Bug extends MovableActor {

	public Bug(char c, Point pos, CryptRaider game) {
		super(c, pos, game);
	}

	@Override
	public void move() {
		int dRow = (int)(Math.random() * 3) - 1;
		int dCol = (int)(Math.random() * 3) - 1;
		
		Point newPos = new Point(_pos.getRow() + dRow, _pos.getCol() + dCol);
		
		if(_game.moveTo(this, newPos))
			_game.changeActor(this, newPos);

	}

}
