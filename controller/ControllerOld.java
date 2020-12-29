package controller;
//Controler le plateau;
import model.Case;
import model.Plateau;
import view.BoardViewOld;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerOld {
	 Plateau plateau;
	 BoardViewOld boardView;
	 Selection selection;
	 Case[][] cases = new Case[8][8];
	
	public ControllerOld(Plateau p, int x, int y) {
//		Selection selection = new Selection();
		this.plateau=p;
//		this.boardView = new BoardView(p);
//		boardView.cellViews.addMouseListener(selection);
		cases[x][y]=new Case();
		cases[x][y].addMouseListener(selection);
	}

	class Selection implements MouseListener {
		public Selection () {
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("hola");
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

	public static void main(String[] args) {
		ControllerOld c = new ControllerOld(new Plateau(8, 8), 0, 0);
	}

}
