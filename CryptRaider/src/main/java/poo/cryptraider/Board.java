package poo.cryptraider;

import poo.cryptraider.actors.Actor;
import poo.cryptraider.actors.MovableActor;
import poo.cryptraider.viewers.Viewer;

public class Board {
	Actor[][] _actors;
	MovableActor[] _movableActors;	
	
	private int getMovablesNumber(Actor[][] actors) {
		int movables = 0;
		for(int row = 0; row < _actors.length; ++ row) {
			for(int col = 0; col < _actors[0].length; ++ col) {
				if(_actors[row][col] instanceof MovableActor)
					++movables;
			}
		}
		return movables;
	}
	
	
	public Board(Actor[][] actors) {
		_actors = actors;
		
		int movables = getMovablesNumber(actors);
		
		_movableActors = new MovableActor[movables];
		
		int width = _actors[0].length;
		int idx = 0;
		for(int row = 0; row < _actors.length; ++ row) {
			for(int col = 0; col < width; ++ col) {
				Actor a = _actors[row][col];
				if(a instanceof MovableActor) {
					_movableActors[idx++] = (MovableActor)a;
				}
			}
		}

		
		
	}
	

	public void moveActors() {
		for(int i = 0; i < _movableActors.length; ++ i) {
			_movableActors[i].move();
		}
	}
	
	public Actor getActor(Point p) {
		return getActor(p.getRow(), p.getCol());
	}
	
	public Actor getActor(int row, int col) {
		return _actors[row][col];
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
		_actors[pos.getRow()][pos.getCol()] = a;
	}




	public int getWidth() {
		return _actors[0].length;
	}


	public int getHeigh() {
		return _actors.length;
	}
}
