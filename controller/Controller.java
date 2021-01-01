package controller;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

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

	public Controller(Plateau plateau) {

		this.plateau=plateau;

	}

	public Controller(Plateau p,BoardView view) throws FileNotFoundException {
		this.plateau=p;
		this.view=view;
		this.init();
		p.showDescendu(7,0);
		//this.view.addMouseListener(this);
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {

				this.view.cellViews[i][j].addMouseListener(this);}}

	}

	public int findLevel (int id) throws FileNotFoundException {
		File devFile = new File("levels.txt");
		Scanner devScanner = new Scanner(devFile);
		int res = 0;
		while (devScanner.hasNext()) {
			String nextLine = devScanner.nextLine();
			String[] devData = nextLine.split(",");
			if (Long.parseLong(devData[0]) == id) {
				res = id;
				System.out.println(devData[1]);
			}
		}
		return res;
	}

	public void init() throws FileNotFoundException {
		view = new BoardView(plateau, findLevel(3));
		this.p=view.gridPanel;
		this.frame.getContentPane().add(p);
		frame.setSize(400, 400);
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
		/*this.plateau.initForCHange();
		this.plateau.fillForChange(x0, y0);*/
		//this.plateau.move();
//		this.plateau.init();
//		/************Let's try something*********************/
//		this.plateau.eliminer_Voisines(x0, y0);
//		this.plateau.use_tab();
//		// this.plateau.reorganisation();
//		for(int i=0;i<64;i++) {
//			this.plateau.use_tab();}
//
//		this.plateau.reorganisation();
//		this.plateau.goDown();
//		this.plateau.pushToLeft();
		/************************************/
		// this.plateau.move();
		this.plateau.tryit(x0, y0);
		/*** c t cela **/
		/* this.plateau.eliminer_Voisines(x0, y0);
		 this.plateau.reorganisation();
		 this.plateau.goDown();
		 this.plateau.pushToLeft();*/
		/******c t cela **/
		//this.plateau.goDown();
		//this.plateau.goDown();
		/* int[][]tab=this.plateau.getTab();
		 for(int i=0;i<8;i++) {
			 for(int j=0;j<8;j++) {
				 System.out.println("Here you are " +tab[i][j]);
		 }}*/
		// this.view.miseAjour(tab,x0, y0);
		// this.plateau.goDown();
		// tab=this.plateau.getTab();
		// this.view.miseAjour2(tab,x0,y0);

		//this.affich(this.plateau);
		/*****************************************/
		/*this.plateau.init();
	    this.plateau.displayColors();
	    this.plateau.eliminer_Voisines(x0, y0);
	    this.view.miseAjourSupp(x0, y0);
	    this.view.update(this.plateau,1);*/
		/********************************************/
		// Controller c= new Controller(this.plateau,this.view);
		//this.view.miseAjourSupp(x0+1,y0);
		// this.frame.remove(p);
		// this.frame.add(view.gridPanel);
		// this.init();
		// this.notifyAll();
		/*************************/
	   /* this.plateau.reorganisation();
	    this.plateau.displayColors();*/
		/***************************/
		//this.plateau.affichetab();
		/********************************************/
	    /*if(this.plateau.tab[x0][y0]==7) {
	    for(int i=0;i<8;i++) {
	    	for(int j=0;j<8;j++) {
	     if(this.plateau.tab[i][j]==7) {
	    this.view.cellViews[i][j].setBackground(new Color(255,255,255));}
	    	}}
	    this.plateau.goDown();
	    for(int i=0;i<8;i++) {
	    	for(int j=0;j<8;j++) {
	    		this.view.cellViews[i][j].setBackground(this.view.knowColor(plateau.colors[i][j].getColor()));
	    }
	    }}*/
		/******************************************************/
		//e.getComponent().setBackground(new Color(255, 255, 255));
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
