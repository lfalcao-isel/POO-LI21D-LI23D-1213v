package poo.cryptraider;

import poo.cryptraider.actors.Actor;
import poo.cryptraider.actors.MovableActor;

public class Board {
	Actor[][] _actorsBoard;
	MovableActor[] _movableActors;
	
	private int getMovablesNumber(Actor[][] actors) {
		int movables = 0;
		for(int row = 0; row < _actorsBoard.length; ++ row) {
			for(int col = 0; col < _actorsBoard[0].length; ++ col) {
				if(_actorsBoard[row][col] instanceof MovableActor)
					++movables;
			}
		}
		return movables;
	}
	
	
	public Board(Actor[][] actors) {
		_actorsBoard = actors;
		
		int movables = getMovablesNumber(actors);
		
		_movableActors = new MovableActor[movables];
		
		int width = _actorsBoard[0].length;
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
	
	public void showBoard() {
		for(int row = 0; row < _actorsBoard.length; ++ row) {
			for(int col = 0; col < _actorsBoard[0].length; ++ col) {
				//System.out.print(_board[row][col].getChar());
				_actorsBoard[row][col].show();
			}
			System.out.println();
		}
		
		System.out.println();
		
	}



	


	public void moveActors(char c) {
		for(int i = 0; i < _movableActors.length; ++ i) {
			_movableActors[i].move(c);
		}
	}
	
	public Actor getActor(Point p) {
		return _actorsBoard[p.getRow()][p.getCol()];
	}


	public void changeActor(Actor a, Point pos) {
		Actor actorToChange = getActor(pos);
		Point posActor = a.getPosition();
		
		actorToChange.setPosition(posActor);
		a.setPosition(pos);
		
		putActorInBoard(a);
		putActorInBoard(actorToChange);
		
	}


	public void putActorInBoard(Actor a) {
		Point pos = a.getPosition();
		_actorsBoard[pos.getRow()][pos.getCol()] = a;
	}
}
