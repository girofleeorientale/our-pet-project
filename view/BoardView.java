package view;

import controller.Controller;
import controller.Launch;
import model.Case;
import model.Plateau;
import util.SerializationUtil;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class BoardView extends JPanel implements Observer, ActionListener{
    // JFrame frame = new JFrame();
    private Plateau plateau;
    private GridLayout gridLayout = new GridLayout(9, 9);
    private JPanel gridPanel = new JPanel(gridLayout);
    private CellView [][] cellViews = new CellView[9][9];
//    private Controller b = new Controller(plateau);
    private JLabel score;
    private JLabel fusees;



    public BoardView (Plateau plateau /*, int level*/) {
        this.plateau=plateau;
        this.plateau.addObserver(this);
        boolean res = true;
        for (int i = 0; i< plateau.getLargeur(); i++) {
            for (int j =0 ; j< plateau.getHauteur(); j++) {
                if (plateau.getCases()[i][j]) {
                    res = false;
                }
            }
        }
        if (res) {
        if (plateau.level == 1) {
            plateau.placeShapes();
        }
        else if (plateau.level == 2) {
            plateau.placeShapesL2();
        }
        else if (plateau.level == 3) {
            plateau.placeShapesL3();
        }
        else if (plateau.level == 4) {
            plateau.placeShapesL4();
        }
        else if (plateau.level == 5) {
            plateau.placeShapesL5();
        }}
//        plateau.placeShapes();
        this.draw(plateau);
        // this.plateau.addObserver(this);
        //  System.out.println("drawn");
        /*frame.add(gridPanel);
        frame.setSize(400, 400);
        frame.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);*/
    }

    public JPanel getGridPanel() {
        return this.gridPanel;
    }

    public CellView[][] getCellViews() {
        return this.cellViews;
    }

    public void draw (Plateau plateau) {
        for (int i = 0; i< plateau.getHauteur(); i++) {
            for (int j = 0; j< plateau.getHauteur(); j++) {
                cellViews[i][j] = new CellView(i, j,
                        knowColor(plateau.getColors()[i][j] != null ? plateau.getColors()[i][j].getColor() : ""));

//                gridButtons[i][j].setText("hi");
                gridPanel.add(cellViews[i][j]);
                if (plateau.getColors()[i][j] != null && (plateau.getColors()[i][j].getColor()).equals("black")) {
                    ImageIcon icon = new ImageIcon("kura.png");
                    JLabel label2 = new JLabel(icon);
                    cellViews[i][j].add(label2);
                }
                else if (plateau.getColors()[i][j] != null && (plateau.getColors()[i][j].getColor()).equals("rose")) {
                    ImageIcon icon = new ImageIcon("persik.png");
                    JLabel label2 = new JLabel(icon);
                    labels.add(label2);
                    cellViews[i][j].add(label2);
                }
                else if (plateau.getColors()[i][j] != null && (plateau.getColors()[i][j].getColor()).equals("marron")) {
                    ImageIcon icon = new ImageIcon("toile.png");
                    JLabel label2 = new JLabel(icon);
                    labels.add(label2);
                    cellViews[i][j].add(label2);
                }
            }
//            cellViews[0][8]=new CellView(0,8, new Color(204,0,0));
//            cellViews[8][5]=new CellView(8,5, new Color(245,1,45));
//            this.gridPanel.add(cellViews[0][8]);
//            this.gridPanel.add(cellViews[8][5]);
        }


        /*JButton j = new JButton("az");*/
//        L1 = new JButton ("L1");
//        this.gridPanel.add(L1);
//        L2= new JButton("L2");
//        this.gridPanel.add(L2);
//        L3= new JButton("L3");
//        this.gridPanel.add(L3,c);
//        L4= new JButton("L4");
//        this.gridPanel.add(L4);
//        L5= new JButton("L5");
//        this.gridPanel.add(L5,c);

        JLabel labelTxt = new JLabel("Score:");
        this.gridPanel.add(labelTxt);
        score = new JLabel(""+plateau.getSaveScore());
        this.gridPanel.add(score);

        JLabel fuseeTxt = new JLabel("Fusées:");
        this.gridPanel.add(fuseeTxt);
        fusees = new JLabel(""+plateau.getStockFusee());
        this.gridPanel.add(fusees);

        JButton saveButton = new JButton("Save");
        this.gridPanel.add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SerializationUtil.serialize(plateau);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

    }

    public void miseAjourSupp(int x, int y) {
        cellViews[x][y]=new CellView(x,y,new Color(0,255,255))  ;
        gridPanel.add(cellViews[x][y]);

    }
//    public void miseAjour(int[][]tab ,int x, int y) {
//        System.out.println("You are finally here !!");
//        this.b.j=78;
//        System.out.println(tab[1][1]);
//        //this.b.plateau.eliminer_Voisines(i, j);
//        for(int i=0;i<8;i++) {
//            for(int j=0;j<8;j++) {
//                if(tab[i][j]==0) {
//
//                    this.cellViews[i][j].setBackground(new Color(51,0,0));}}}
//	/*this.cellViews[i+1][j].setBackground(new Color(54,15,0));
//	System.out.println(i);
//	System.out.println(j);*/
//
//    }

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
        
        
        else if(couleur.equals("marron")) {
        	c= new Color(51,0,0);
        }
        return c;
    }

   /* public static void main(String[] args) {
        BoardView boardView = new BoardView(new Plateau(8, 8));
        CellView cellView = new CellView(9, 9 , new Color(0,6,0));
    }*/

    ArrayList<JLabel> labels = new ArrayList<>();



    @Override
    public void update(Observable o, Object level) {
        // 	Object arg1 c'est peut etre l'identifiant
        // Du changement à effectuer


        if(o instanceof Plateau) {

            Plateau a =(Plateau)o;

//            labels.remove(0);
//            labels.revalidate();

            for(int i=0;i<8;i++) {
                for(int j=0;j<8;j++) {

                    this.cellViews[i][j].setBackground(knowColor(a.getColors()[i][j].getColor()));
                    this.cellViews[i][j].removeAll();
                    this.cellViews[i][j].repaint();

                }
            }

//            this.revalidate();

            for(int i=0;i<8;i++) {
                for(int j=0;j<8;j++) {
                    if ((a.getColors()[i][j].getColor().equals("black"))) {

                        ImageIcon icon = new ImageIcon("kura.png");
                        JLabel label2 = new JLabel(icon);
                        this.cellViews[i][j].add(label2);
                        this.cellViews[i][j].revalidate();

                    }

                    if ((a.getColors()[i][j].getColor().equals("rose"))) {

                        ImageIcon icon = new ImageIcon("persik.png");
                        JLabel label2 = new JLabel(icon);
                        this.cellViews[i][j].add(label2);
//                        this.cellViews[i][j].invalidate();
                        this.cellViews[i][j].revalidate();
//                        this.cellViews[i][j].repaint();
                    }
                    else if ((plateau.getColors()[i][j].getColor()).equals("marron")) {
                        ImageIcon icon = new ImageIcon("toile.png");
                        JLabel label2 = new JLabel(icon);
                        cellViews[i][j].add(label2);
                        this.cellViews[i][j].revalidate();
                    }
                }
//                this.revalidate();
            }
//            this.invalidate();
//            this.revalidate();
//            this.repaint();
//
//            for(int i=0;i<8;i++) {
//                for(int j=0;j<8;j++) {
//                    if ((a.colors[i][j].getColor().equals("rose"))) {
//                        this.cellViews[i][j].removeAll();
//                        this.cellViews[i][j].revalidate();
//                        this.cellViews[i][j].repaint();
//
//
//                        ImageIcon icon = new ImageIcon("persik.png");
//                        JLabel label2 = new JLabel(icon);
//                        this.cellViews[i][j].add(label2);
//                    }
//                }
////                this.revalidate();
//            }

            // methode pour supprimer les animaux dans GUI
            for(int i=0;i<8;i++) {
                for(int j=0;j<8;j++) {
                    if ((a.getColors()[i][j].getColor().equals("orange")) ) {
                    	a.getColors()[i][j].setColor("white");
                        cellViews[i][j].removeAll();
                        cellViews[i][j].setColor(new Color(255, 255, 255));
                        //a.colors[i][j].setColor("white");
                    }
                }
            }


            JLabel l = new JLabel();
            String stock =String.valueOf( a.getStockFusee());
            l.setText(stock);
//            this.cellViews[0][8].removeAll();
//            this.cellViews[0][8].add(l);
            fusees.setText(String.valueOf( a.getStockFusee()));
            
            JLabel k = new JLabel();
            String Score = String.valueOf(a.getSaveScore());
            k.setText(Score);
//             this.cellViews[8][5].removeAll();
//             this.cellViews[8][5].add(k);
            score.setText(String.valueOf(a.getSaveScore()));
          /*  if(a.LevelUp==true) {
            	this.cellViews[4][4].setBackground(new Color(7,7,8));
            }*/

           if (a.getIsWinner()) {
               this.gridPanel.revalidate();
               ImageIcon icon = new ImageIcon("sea.png");
               JLabel label2 = new JLabel(icon);
               this.gridPanel.add(label2);
//               this.cellViews[2][2].setBackground(new Color(200, 150, 180));
               System.out.println("VOUS AVEZ GAGNE");

           }



            
        }





        this.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("");

    }
}
