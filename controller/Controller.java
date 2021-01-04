package controller;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

//Controler le plateau;
import model.Plateau;
//import sun.tools.tree.ThisExpression;
import view.BoardView;
import view.CellView;
public class Controller extends JFrame implements MouseListener {
	public Plateau plateau;
	public BoardView view;
	JFrame frame = new JFrame();
	JPanel p = new JPanel();
	public int j;
	int x0;
	int y0;
	int level;

	public Controller(Plateau plateau) {

		this.plateau=plateau;

	}

	public Controller(Plateau p,BoardView view, int level) throws FileNotFoundException {
		this.plateau=p;
		//linge suivante CCC
		this.view=view;
		this.level=level;

		this.init(level);
//		p.showDescendu(7,0);
		//this.view.addMouseListener(this);


	}



	public void init(int level) throws FileNotFoundException {
		view = new BoardView(plateau, level);
		this.p=view.gridPanel;
		this.frame.getContentPane().add(p);
		frame.setSize(500, 500);

		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {

				this.view.cellViews[i][j].addMouseListener(this);}}

		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void ChangeColor(int i, int j) {
		this.view.cellViews[5][5].setBackground(new Color(102,0,153));
		//System.out.println(this.plateau.clickedOn[0][1]);
	}

	public void eliminer(int i , int j) {
		this.plateau.eliminer_Voisines(i, j);

	}
	public void affich(Plateau p) {


		System.out.println("Compter" +p.count_animals(1));

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
		this.x0=((CellView) source1).getCordX();
		this.y0 =((CellView) source1).getCordY();
System.out.println(" x0 "+x0+" y0 "+y0);
		// this.plateau.move();
		boolean b=false;
		if(e.getButton()== MouseEvent.BUTTON3) {this.plateau.tryit(true, x0, y0);}
		else this.plateau.tryit(false,x0, y0);
		if(e.getButton()== MouseEvent.BUTTON3)System.out.println("right click !!");
		if (this.plateau.isWinner) {
			this.frame.getContentPane().removeAll();
			this.frame.getContentPane().revalidate();
			this.frame.getContentPane().repaint();



			ImageIcon icon = new ImageIcon("sea.png");
			JLabel label2 = new JLabel(icon);

			//lignes 111-121 CCC
//			JButton button = new JButton("start");
//			button.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					try {
//						Launch.startNextLevel(level);
//					} catch (FileNotFoundException fileNotFoundException) {
//						fileNotFoundException.printStackTrace();
//					}
//				}
//			});

			this.frame.getContentPane().add(label2);
//			this.frame.getContentPane().add(button);

		}

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
	/*public static void main(String[] args) {
		EventQueue.invokeLater(()-> {
		Plateau p= new Plateau(8,8);
        BoardView boardView = new BoardView(new Plateau(8, 8));
        CellView cellView = new CellView(9, 9 , new Color(0,6,0));
        Controller c= new Controller(p,boardView);
        System.out.println("there is hers");
        c.affich(p);
        });
    }*/

}
