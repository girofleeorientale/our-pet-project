package controller;
//Controler le plateau;
import model.Plateau;
import view.BoardViewOld;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyController {
	 Plateau plateau;
	 BoardViewOld boardView;
	 Selection selection;

	public MyController(Plateau p, BoardViewOld b, int x, int y) {
//		Selection selection = new Selection();
		this.plateau=p;
		this.boardView = b;

//		boardView.cellViews[x][y].addMouseListener(event -> System.out.println("jjj"));

		}
//		boardView.cellViews.addMouseListener(selection);


	class Selection implements MouseListener {
		public Selection () {
		}

		@Override
		public void mouseClicked(MouseEvent e) {
//			int x = e.getX();
//			int y = e.getY();
//			System.out.println(x+ " <- x ; y-> " + y);

		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}


}
