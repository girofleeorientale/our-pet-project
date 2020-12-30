package view;

import controller.Controller;

import model.Case;
import model.Plateau;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class BoardView extends JPanel implements Observer{
   // JFrame frame = new JFrame();
    Plateau plateau;
    GridLayout gridLayout = new GridLayout(8, 8);
    public JPanel gridPanel = new JPanel(gridLayout);
    public CellView [][] cellViews = new CellView[8][8];
    Controller b = new Controller(plateau);

    public BoardView (Plateau plateau) {
    	this.plateau=plateau;
        this.plateau.addObserver(this);
       plateau.placeShapes();
       this.draw(plateau);
      // this.plateau.addObserver(this);
     //  System.out.println("drawn");
        /*frame.add(gridPanel);
        frame.setSize(400, 400);
        frame.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);*/
    }

    public void draw (Plateau plateau) {
        for (int i = 0; i< plateau.hauteur; i++) {
            for (int j = 0; j< plateau.hauteur; j++) {
                cellViews[i][j] = new CellView(i, j, knowColor(plateau.colors[i][j].getColor()));
//                gridButtons[i][j].setText("hi");
                gridPanel.add(cellViews[i][j]);
            }
        }
    }
public void miseAjourSupp(int x, int y) {
	cellViews[x][y]=new CellView(x,y,new Color(0,255,255))  ;
	gridPanel.add(cellViews[x][y]);
	
	}
public void miseAjour(int[][]tab ,int x, int y) {
	System.out.println("You are finally here !!");
	this.b.j=78;
		System.out.println(tab[1][1]);
	//this.b.plateau.eliminer_Voisines(i, j);
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
		if(tab[i][j]==0) {
			
	this.cellViews[i][j].setBackground(new Color(51,0,0));}}}
	/*this.cellViews[i+1][j].setBackground(new Color(54,15,0));
	System.out.println(i);
	System.out.println(j);*/
	
}
	
public void miseAjour2(int [][]tab, int x, int y) {
	//this.cellViews[7][7].setBackground(new Color(255,255,255));
	for(int i=0;i<8;i++) {
		for(int j=0;j<8;j++) {
	if(tab[i][j]==0) {
		
this.cellViews[i][j].setBackground(new Color(255,255,255));}
	
}}}
    public Color knowColor(String couleur) {
        Color c = new Color(0, 50, 0);

                if (couleur.equals("red")) {
                    c = new Color(255, 0, 0);
                }
                else if (couleur.equals("blue")) {
                    c = new Color(0, 0, 255);
                }
                else if (couleur.equals("green")) {
                    c = new Color(0, 255, 0);
                }
                else if (couleur.equals("yellow")) {
                    c = new Color(255, 255, 0);
                }
    return c;
    }

   /* public static void main(String[] args) {
        BoardView boardView = new BoardView(new Plateau(8, 8));
        CellView cellView = new CellView(9, 9 , new Color(0,6,0));
    }*/

	

	@Override
	public void update(Observable o, Object arg1) {
	  // 	Object arg1 c'est peut etre l'identifiant
		// Du changement à effectuer
		if(o instanceof Plateau) {
			
			Plateau a =(Plateau)o;
			//System.out.println(a.X);
			for(int i=0;i<8;i++) {
				for(int j=0;j<8;j++) {
		this.cellViews[i][j].setBackground(knowColor(a.colors[i][j].getColor()));}
			}
			/*System.out.println("kkkkkkkkkkk"+a.colors[0][0].getColor());
			this.cellViews[0][0].setBackground(new Color(255,255,255));*/
			/*this.cellViews[0][0].setBackground(new Color(0,255,0));*/
			System.out.println("zez");
			}
	}
}