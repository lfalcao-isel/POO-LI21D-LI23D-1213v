package poo.cryptraider.aula;

public class Carter extends Actor {

	

	public Carter(char c, Point pos, CryptRaider game) {
		super(c, pos, game);
	}

	@Override
	public void move(char key) {
		switch(key) {
			case CryptRaider.UP : _direction = new Point(-1,0); break;
			case CryptRaider.DOWN : _direction = new Point(1,0); break;
			case CryptRaider.LEFT : _direction = new Point(0,-1); break;
			case CryptRaider.RIGHT : _direction = new Point(0,1); break;
		}
		
		_pos.add(_direction);
		
		if(_game.canMoveTo(this)) {
			_game.moveTo(this);
		} else {
			_direction.invert();
			_pos.add(_direction);
		}
	}
	
}
