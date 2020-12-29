package controller;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

//Controler le plateau;
import model.Plateau;
//import sun.tools.tree.ThisExpression;
import view.BoardView;
import view.BoardViewOld;
import view.CellView;
import view.CellViewOld;
public class Controller extends JFrame implements MouseListener {
	 Plateau plateau;
	 BoardView view;
	 JFrame frame = new JFrame();
	
	public Controller(Plateau p, BoardView view) {
		this.plateau=p;
		this.view=view;
		this.init();
		//this.view.addMouseListener(this);
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
		
		this.view.cellViews[i][j].addMouseListener(this);}}

	}
	public void init() {
	view = new BoardView(plateau);
	
	this.frame.add(view.gridPanel);
	frame.setSize(400, 400);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}	
		
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		Object source = e.getSource();
		Object source1 =(CellView) source;
		/* Pour obtenir les coordonnees */
		System.out.println(((CellView) source1).getCordX());
	    ( (CellView) source1).getCordY();
	    /*****************/
		int x=((CellView) source1).getCordX();
	    //this.view.cellViews[1][1].setBackground(new Color(255,0,0));
	       if(x==2) {
         e.getComponent().setBackground(new Color(255, 255, 255));}
		//this.view.cellViews[1][2].setBackground(new Color(255, 255, 255));
		 
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent u) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {

		Plateau p= new Plateau(8,8);
        BoardView boardView = new BoardView(new Plateau(8, 8));
        CellView cellView = new CellView(9, 9 , new Color(0,6,0));
        Controller c= new Controller(p,boardView);
        System.out.println("there is hers");
    }

}
