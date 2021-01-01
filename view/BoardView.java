package view;

import controller.Controller;

import model.Case;
import model.Plateau;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;

public class BoardView extends JPanel implements Observer{
//     JFrame frame = new JFrame();
    Plateau plateau;
    GridLayout gridLayout = new GridLayout(8, 8);
    public JPanel gridPanel = new JPanel(gridLayout);
    public CellView [][] cellViews = new CellView[8][8];
    Controller b = new Controller(plateau);



    public BoardView (Plateau plateau, int level) {
//        JMenuBar menuBottons = new JMenuBar();
//        JButton bouton = new JButton();
//        menuBottons.add(bouton);
//        gridPanel.add(menuBottons);
//        frame.add(gridPanel);

//        menuBottons.setVisible(true);
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
//        frame.setVisible(true);

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
    public void update(Observable o, Object arg1) {
        // 	Object arg1 c'est peut etre l'identifiant
        // Du changement à effectuer
        if(o instanceof Plateau) {

            Plateau a =(Plateau)o;


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


			/*System.out.println("kkkkkkkkkkk"+a.colors[0][0].getColor());
			this.cellViews[0][0].setBackground(new Color(255,255,255));*/
            /*this.cellViews[0][0].setBackground(new Color(0,255,0));*/
            System.out.println("zez");
//            ImageIcon icon = new ImageIcon("kura.png");
//            JLabel label2 = new JLabel(icon);
//            this.cellViews[7][7].add(label2);
        }
//        this.invalidate();
//        this.repaint();
        this.revalidate();
    }
}