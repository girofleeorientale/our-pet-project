package view;

import controller.Controller;
import controller.Launch;
import model.Case;
import model.Plateau;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;

public class BoardView extends JPanel implements Observer, ActionListener{
    // JFrame frame = new JFrame();
    Plateau plateau;
    GridLayout gridLayout = new GridLayout(9, 9);
    public JPanel gridPanel = new JPanel(gridLayout);
    public CellView [][] cellViews = new CellView[9][9];
    Controller b = new Controller(plateau);
    JButton L1;
    JButton L2;
    JButton L3;
    JButton L4;
    JButton L5;
    


    public BoardView (Plateau plateau, int level) {
        this.plateau=plateau;
        this.plateau.addObserver(this);
        if (level == 1) {
            plateau.placeShapes();
        }
        else if (level == 2) {
            plateau.placeShapesL2();
        }
        else if (level == 3) {
            plateau.placeShapesL3();
        }
//        plateau.placeShapes();
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
                if ((plateau.colors[i][j].getColor()).equals("black")) {
                    ImageIcon icon = new ImageIcon("kura.png");
                    JLabel label2 = new JLabel(icon);
                    cellViews[i][j].add(label2);
                }
            }
        }
        
        	/*JButton j = new JButton("az");*/
        	L1 = new JButton ("L1");
        	this.gridPanel.add(L1);
        	L2= new JButton("L2");
        	this.gridPanel.add(L2);
        	L3= new JButton("L3");
        	this.gridPanel.add(L3);
        	L4= new JButton("L4");
        	this.gridPanel.add(L4);
        	L5= new JButton("L5");
        	this.gridPanel.add(L5);
        	
        	
                               
        
        
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
        else if (couleur.equals("black")) {
            c = new Color(0, 0, 0);
        }
        return c;
    }

   /* public static void main(String[] args) {
        BoardView boardView = new BoardView(new Plateau(8, 8));
        CellView cellView = new CellView(9, 9 , new Color(0,6,0));
    }*/



    @Override
    public void update(Observable o, Object level) {
        // 	Object arg1 c'est peut etre l'identifiant
        // Du changement à effectuer
    	
    	
        if(o instanceof Plateau) {

            Plateau a =(Plateau)o;
            if(a.level==2) {
            	System.out.println("You are in level 2");
    L2.addActionListener(new ActionListener() {
            		
            		public void actionPerformed(ActionEvent e) {
            			
            			Plateau p= new Plateau(8,8);
            			
            	       BoardView boardView = new BoardView(p, 3);
            	    try {
            	    	
    					Controller   c = new Controller(p,boardView);
    					
    				} catch (FileNotFoundException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    					
    				}
            		}});
    
            
            }
            	
            
           
            
        
           
            else if(a.level==3) {
        	System.out.println("You are in level 3");
        	
        	
        	
        	
        	 L3.addActionListener(new ActionListener() {
         		
         		public void actionPerformed(ActionEvent e) {
         			
         			Plateau p= new Plateau(8,8);
         			
         	       BoardView boardView = new BoardView(p, 3);
         	    try {
         	    	
 					Controller   c = new Controller(p,boardView);
 					
 				} catch (FileNotFoundException e1) {
 					// TODO Auto-generated catch block
 					e1.printStackTrace();
 					
 				}
         		}});
                
            		}
            		
            
            
            
            


            //System.out.println(a.X);
           
            for(int i=0;i<8;i++) {
                for(int j=0;j<8;j++) {

                    this.cellViews[i][j].setBackground(knowColor(a.colors[i][j].getColor()));
                    this.cellViews[i][j].removeAll();


//                    if ((cellViews[i][j].color.equals(new Color(0,0,0)))) {
//
//                        ImageIcon icon = new ImageIcon("kura.png");
//                        JLabel label2 = new JLabel(icon);
//                        this.cellViews[i][j].add(label2);
////                        System.out.println("ВОТ ОНО");
//                        this.cellViews[i][j].setBackground(new Color(0, 200, 255));
//                    }
                }
            }

            for(int i=0;i<8;i++) {
                for(int j=0;j<8;j++) {
                    if ((a.colors[i][j].getColor().equals("black"))) {


//                        this.cellViews[i][j].invalidate();
//                        this.cellViews[i][j].repaint();
                        this.cellViews[i][j].revalidate();

//                        System.out.println("ВОТ ОНО");
//                        this.cellViews[i][j].setBackground(new Color(0, 200, 255));
                        ImageIcon icon = new ImageIcon("kura.png");
                        JLabel label2 = new JLabel(icon);
                        this.cellViews[i][j].add(label2);
                    }
                }
                }

            // methode pour supprimer les animaux dans GUI
            for(int i=0;i<8;i++) {
                for(int j=0;j<8;j++) {
                    if ((a.colors[i][j].getColor().equals("black")) && i == 7) {
                        cellViews[i][j].removeAll();
                        cellViews[i][j].setColor(new Color(255, 255, 255));
                        a.colors[i][j].setColor("white");
                    }
                }
                }


            JLabel l = new JLabel();
            String score =String.valueOf( a.StockFusee);
            l.setText(score);
            
            //this.cellViews[8][2].add(l);
          
          /* let's try something */
            
           
           
            //            ImageIcon icon = new ImageIcon("kura.png");
//            JLabel label2 = new JLabel(icon);
//            this.cellViews[7][7].add(label2);
        }
//        this.invalidate();
//        this.repaint();
        
        
        
        
        this.revalidate();
    }

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("eeeeee");
		
	}
}
