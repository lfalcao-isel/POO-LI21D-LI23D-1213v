package poo.cryptraider;

import poo.cryptraider.actors.Actor;
import poo.cryptraider.actors.MovableActor;
import poo.cryptraider.viewers.Viewer;

public class Board {
	Actor[][] _actorsBoard;
	MovableActor[] _movableActors;
	private Viewer[] _viewers = new Viewer[10];
	private int _numViewers = 0;
	
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
		for(int i = 0; i < _numViewers; ++i) {
			_viewers[i].show(this);
		}
	}



	


	public void moveActors(char c) {
		for(int i = 0; i < _movableActors.length; ++ i) {
			_movableActors[i].move(c);
		}
	}
	
	public Actor getActor(Point p) {
		return getActor(p.getRow(), p.getCol());
	}
	
	public Actor getActor(int row, int col) {
		return _actorsBoard[row][col];
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




	public int getWidth() {
		return _actorsBoard[0].length;
	}


	public int getHeigh() {
		return _actorsBoard.length;
	}


	public void addViewers(Viewer[] viewers) {
		for(int i = 0; i < viewers.length; ++i) {
			_viewers[_numViewers++] = viewers[i];
		}
	}


}
