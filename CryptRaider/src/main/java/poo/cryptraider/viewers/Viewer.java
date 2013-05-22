package poo.cryptraider.viewers;

import poo.cryptraider.Board;
import poo.cryptraider.CryptRaider;
import poo.cryptraider.actors.Actor;

/**
 * Implementor of this interface is Viewer for the CryptRider game
 * 
 * @author lfalcao
 *
 */
public interface Viewer {
	/**
	 * Indicates the game is initializing
	 * 
	 * @param game The CryptRaider game instance
	 */
	void initGame(CryptRaider g);
	
	/**
	 * Updates the CryptRayder game.
	 * 
	 * @param game The CryptRaider game instance
	 */
	void update(CryptRaider g);

	/**
	 * Called when a new level is loaded
	 * 
	 * @param game The CryptRaider game instance
	 */
	void initLevel(CryptRaider game);

	/**
	 * Method called when the given actor moves.
	 * @param a the actor that was moved
	 * 
	 * The actor already is in its new position.
	 */
	void actorsChanged(Actor... a);

	
}
