package controller;
//Controler le plateau;
import model.Plateau;
import view.BoardView;
import view.Square;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller {
	 Plateau plateau;
	 BoardView boardView;
	 Selection selection;
	
	public Controller(Plateau p) {
//		Selection selection = new Selection();
//		this.plateau=p;
//		this.boardView = new BoardView(p);
//		boardView.cellViews.addMouseListener(selection);
	}

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
