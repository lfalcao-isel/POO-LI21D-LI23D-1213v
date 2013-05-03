package poo.cryptraider.viewers;

import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import poo.cryptraider.Board;
import poo.cryptraider.FileSystemResourceManager;
import poo.cryptraider.actors.Actor;

public class CrypraiderSwingViewer extends JFrame implements Viewer {

	
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
		
	}

	private Icon getActorIcon(Actor actor) {
		String actorName = actor.getClass().getSimpleName().toLowerCase();
		String imagePath = FileSystemResourceManager.getResource("levels/images/" + actorName + ".png");
		ImageIcon imageIcon = new ImageIcon(imagePath);
		
		
		
		
		return imageIcon;
	}

}
