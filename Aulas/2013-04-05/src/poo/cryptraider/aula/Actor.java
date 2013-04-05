package poo.cryptraider.aula;

public abstract class Actor {
	private char _c;
	protected Point _pos;
	protected Point _direction;
	
	protected CryptRaider _game;
	
	
	public Actor(char c, Point pos, CryptRaider game) {
		_c = c;
		_game = game;
		_pos = pos;
		_direction = new Point(0,0);
	}
	
	public char getChar() {
		return _c;
	}
	
	public Point getPosition() { return _pos; }
	
	public void move(char key) { }

	public void show() {
		System.out.print(_c);
	}
}
