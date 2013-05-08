package poo.cryptraider.viewers;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import poo.cryptraider.Board;
import poo.cryptraider.CryptRaider;
import poo.cryptraider.FileSystemResourceManager;
import poo.cryptraider.actors.Actor;

public class CrypraiderSwingViewer extends JFrame implements Viewer, KeyListener {

	private CryptRaider _game;

	public CrypraiderSwingViewer(CryptRaider game) {
		_game = game;
	}
	
	@Override
	public void show(Board b) {
		int rows = b.getHeigh();
		int cols = b.getWidth();
		
		
		setTitle("Cryptraider Glorioso!");
		setLayout(new GridLayout(rows, cols));
		
		
		for(int row = 0; row < rows; ++row) {
			for(int col = 0; col < cols; ++col) {
				JLabel label = new JLabel();
				Icon icon = getActorIcon(b.getActor(row, col));
				label.setIcon(icon);
				add(label);
			}
		}
		
		
		setResizable(false);
		pack();
		setVisible(true);
		
		addKeyListener(this);
		
	}

	private Icon getActorIcon(Actor actor) {
		String actorName = actor.getClass().getSimpleName().toLowerCase();
		String imagePath = FileSystemResourceManager.getResource("levels/images/" + actorName + ".png");
		ImageIcon imageIcon = new ImageIcon(imagePath);
		
		
		
		
		return imageIcon;
	}

	@Override
	public void keyPressed(KeyEvent event) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent event) {
		char key = event.getKeyChar();
		_game.addKey(key);
		
	}

}
