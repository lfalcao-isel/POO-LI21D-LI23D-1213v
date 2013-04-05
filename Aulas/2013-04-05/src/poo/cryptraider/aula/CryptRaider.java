package poo.cryptraider.aula;

import java.util.Scanner;

public class CryptRaider {
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
	
	
	Actor[][] _board;
	Scanner _input = new Scanner(System.in);
	
	private void loadLevel() {
		int width = _level[0].length();
		_board = new Actor[_level.length][width];
		
		for(int row = 0; row < _level.length; ++ row) {
			String rowStr = _level[row]; 
			for(int col = 0; col < width; ++ col) {
				char c = rowStr.charAt(col);
				_board[row][col] = createActor(c, row, col);
			}
			
		}
		
	}
	
	private Actor createActor(char c, int row, int col) {
		switch(c) {
			case '#': return new Wall(c, row, col); 
			case '$': return new Stone(c, row, col);
			case ' ': return new Space(c, row, col);
			case 'C': return new Carter(c, row, col);
			case 'A': return new Artifact(c, row, col);
			case '*': return new Sand(c, row, col); 
			case 'P': return new Portal(c, row, col); 
		}
		
		return null;
	}

	public void start() {
		loadLevel();
		
		while(true) {
			showBoard();
			char c = readKey();
			moveActors(c);
		}
	}

	private void moveActors(char c) {
		for(int row = 0; row < _level.length; ++ row) {
			for(int col = 0; col < _board[0].length; ++ col) {
				Actor currentActor  = _board[row][col];
				currentActor.move(c);
			}
		}
		
	}

	private char readKey() {
		return _input.next().charAt(0);
	}

	private void showBoard() {
		for(int row = 0; row < _level.length; ++ row) {
			for(int col = 0; col < _board[0].length; ++ col) {
				//System.out.print(_board[row][col].getChar());
				_board[row][col].show();
			}
			System.out.println();
		}
		
		System.out.println();
		
	}




	

}
