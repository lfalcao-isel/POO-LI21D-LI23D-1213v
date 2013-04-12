package poo.cryptraider;

import poo.cryptraider.actors.Actor;
import poo.cryptraider.actors.MovableActor;

public class Board {
	Actor[][] _actorsBoard;
	MovableActor[] _movableActors;
	
	
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


	private int getMovablesNumber(Actor[][] actors) {
		// TODO Auto-generated method stub
		return 0;
	}


	public void moveActors(char c) {
		for(int i = 0; i < _movableActors.length; ++ i) {
			_movableActors[i].move(c);
		}
		
	}
}
