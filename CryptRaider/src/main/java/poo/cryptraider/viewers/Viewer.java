package poo.cryptraider.viewers;

import poo.cryptraider.Board;
import poo.cryptraider.actors.Actor;

/**
 * Implementor of this interface is Viewer for the CryptRider game
 * 
 * @author lfalcao
 *
 */
public interface Viewer {
	
	/**
	 * Show the CryptRayder board for the b board.
	 * 
	 * @param b The board to be shown
	 */
	void show(Board b);

	/**
	 * Called when a new level is loaded
	 * @param _board
	 */
	void initLevel(Board board);

	/**
	 * Method called when the given actor moves.
	 * @param a the actor that was moved
	 * 
	 * The actor already is in its new position.
	 */
	void actorsChanged(Actor... a);
}
