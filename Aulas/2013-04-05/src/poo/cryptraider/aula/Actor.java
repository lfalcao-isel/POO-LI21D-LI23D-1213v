package poo.cryptraider.aula;

public abstract class Actor {
	private char _c;
	private int _row;
	private int _col;
	
	public Actor(char c, int row, int col) {
		_c = c;
		_col = col;
		_row = row;
	}
	
	public char getChar() {
		return _c;
	}
	
	public void move(char key) { }

	public void show() {
		System.out.print(_c);
	}
}
