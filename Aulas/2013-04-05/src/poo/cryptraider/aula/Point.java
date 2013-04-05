package poo.cryptraider.aula;

public class Point {
	private int _row;
	protected int _col;
	
	public Point(int row, int col) {
		_row = row;
		_col = col;
	}

	public int getRow() {
		return _row;
	}

	public int getCol() {
		return _col;
	}


	public void add(Point p) {
		_row += p._row;
		_col += p._col;
	}

	public void invert() {
		_row = -_row;
		_col = -_col;
	}
	
}
