package poo.cryptraider.viewers;



import poo.cryptraider.Board;
import poo.cryptraider.Point;

public class ConsoleViewer implements Viewer {

	@Override
	public void show(Board board) {
		int width = board.getWidth();
		int height = board.getHeigh();
		
		for (int row = 0; row < height; ++row) {
			for (int col = 0; col < width; ++col) {
				board.getActor(new Point(row, col)).show();
			}
			System.out.println();
		}

		System.out.println();

	}

}
