package poo.cryptraider.aula;

import java.util.Scanner;

import javax.swing.text.Position;

public class CryptRaider {
	public static final char UP = 'w';
	public static final char DOWN = 's';
	public static final char LEFT = 'a';
	public static final char RIGHT = 'd';
	
	private String[] _level = {
			"##################", 
			"#    $#          #",
			"#    $# ***A**** #", 
			"#    $# ******** #", 
			"# C  $#          #",
			"#$$$ $# #### ### #", 
			"#### ##    #P#   #", 
			"#  # #     ###   #",
			"#                #", 
			"#$$$$$$$$$$$$$$$$#", 
			"#****************#",
			"##################"
	};
	
	
	Actor[][] _actorsBoard;
	MovableActor[] _movableActors;
	
	Scanner _input = new Scanner(System.in);
	
	private void loadLevel() {
		int width = _level[0].length();
		_actorsBoard = new Actor[_level.length][width];
		
		
		int movable = 0;
		for(int row = 0; row < _level.length; ++ row) {
			String rowStr = _level[row]; 
			for(int col = 0; col < width; ++ col) {
				char c = rowStr.charAt(col);
				Actor a = _actorsBoard[row][col] = createActor(c, row, col);
				if(a instanceof MovableActor) {
					++movable;
				}
			}
		}
		
		_movableActors = new MovableActor[movable];
		
		int idx = 0;
		for(int row = 0; row < _actorsBoard.length; ++ row) {
			for(int col = 0; col < width; ++ col) {
				Actor a = _actorsBoard[row][col];
				if(a instanceof MovableActor) {
					_movableActors[idx++] = (MovableActor)a;
				}
			}
		}
		
		
	}
	
	private Actor createActor(char c, int row, int col) {
		switch(c) {
			case '#': return new Wall(c, new Point(row, col), this); 
			case '$': return new Stone(c, new Point(row, col), this);
			case ' ': return new Space(c, new Point(row, col), this);
			case 'C': return new Carter(c, new Point(row, col), this);
			case 'A': return new Artifact(c, new Point(row, col), this);
			case '*': return new Sand(c, new Point(row, col), this); 
			case 'P': return new Portal(c, new Point(row, col), this); 
		}
		
		return null;
	}

	private void moveActors(char c) {
		for(int row = 0; row < _level.length; ++ row) {
			for(int col = 0; col < _actorsBoard[0].length; ++ col) {
				Actor currentActor  = _actorsBoard[row][col];
				if(currentActor instanceof MovableActor) {
					((MovableActor)currentActor).move(c);
				}
			}
		}
	}

	private char readKey() {
		return _input.next().charAt(0);
	}

	private void showBoard() {
		for(int row = 0; row < _level.length; ++ row) {
			for(int col = 0; col < _actorsBoard[0].length; ++ col) {
				//System.out.print(_board[row][col].getChar());
				_actorsBoard[row][col].show();
			}
			System.out.println();
		}
		
		System.out.println();
		
	}

	
	public void start() {
		loadLevel();
		
		while(true) {
			showBoard();
			char c = readKey();
			moveActors(c);
		}
	}

	public void moveTo(Actor a) {
		Point p = a.getPosition();
		Actor colidedActor =_actorsBoard[p.getRow()][p.getCol()] ;
		colidedActor.colide(a);
		
		
		
	}

	public void putActorInBoard(Actor a) {
		Point p = a.getPosition();
		_actorsBoard[p.getRow()][p.getCol()] = a;
		
	}


	

}
