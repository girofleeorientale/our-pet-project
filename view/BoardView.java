package view;

import model.Plateau;
import util.SerializationUtil;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class BoardView extends JPanel implements Observer, ActionListener{
    private Plateau plateau;
    private GridLayout gridLayout = new GridLayout(9, 9);
    private JPanel gridPanel = new JPanel(gridLayout);
    private CellView [][] cellViews = new CellView[9][9];
    private JLabel score;
    private JLabel fusees;

    public BoardView (Plateau plateau) {
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
        if (plateau.getLevel() == 1) {
            plateau.placeShapes();
        }
        else if (plateau.getLevel() == 2) {
            plateau.placeShapesL2();
        }
        else if (plateau.getLevel() == 3) {
            plateau.placeShapesL3();
        }
        else if (plateau.getLevel() == 4) {
            plateau.placeShapesL4();
        }
        else if (plateau.getLevel() == 5) {
            plateau.placeShapesL5();
        }}
        this.draw(plateau);
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

                gridPanel.add(cellViews[i][j]);
                if (plateau.getColors()[i][j] != null && (plateau.getColors()[i][j].getColor()).equals("azure")) {
                    ImageIcon icon = new ImageIcon("kura.png");
                    JLabel label2 = new JLabel(icon);
                    cellViews[i][j].add(label2);
                }
                else if (plateau.getColors()[i][j] != null && (plateau.getColors()[i][j].getColor()).equals("orchid")) {
                    ImageIcon icon = new ImageIcon("persik.png");
                    JLabel label2 = new JLabel(icon);
                    cellViews[i][j].add(label2);
                }
                else if (plateau.getColors()[i][j] != null && (plateau.getColors()[i][j].getColor()).equals("marron")) {
                    ImageIcon icon = new ImageIcon("toile.png");
                    JLabel label2 = new JLabel(icon);
                    cellViews[i][j].add(label2);
                }
            }
        }

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


    @Override
    public void update(Observable o, Object level) {
        // 	Object arg1 c'est peut etre l'identifiant
        // Du changement à effectuer


        if(o instanceof Plateau) {

            Plateau a =(Plateau)o;

            for(int i=0;i<plateau.getHauteur();i++) {
                for(int j=0;j<plateau.getLargeur();j++) {

                    this.cellViews[i][j].setBackground(knowColor(a.getColors()[i][j].getColor()));
                    this.cellViews[i][j].removeAll();
                    this.cellViews[i][j].repaint();
                }
            }

            for(int i=0;i<plateau.getHauteur();i++) {
                for(int j=0;j<plateau.getLargeur();j++) {
                    if ((a.getColors()[i][j].getColor().equals("azure"))) {

                        ImageIcon icon = new ImageIcon("kura.png");
                        JLabel label2 = new JLabel(icon);
                        this.cellViews[i][j].add(label2);
                        this.cellViews[i][j].revalidate();

                    }

                    if ((a.getColors()[i][j].getColor().equals("orchid"))) {

                        ImageIcon icon = new ImageIcon("persik.png");
                        JLabel label2 = new JLabel(icon);
                        this.cellViews[i][j].add(label2);
                        this.cellViews[i][j].revalidate();
                    }
                    else if ((plateau.getColors()[i][j].getColor()).equals("marron")) {
                        ImageIcon icon = new ImageIcon("toile.png");
                        JLabel label2 = new JLabel(icon);
                        cellViews[i][j].add(label2);
                        this.cellViews[i][j].revalidate();
                    }
                }
            }


            JLabel l = new JLabel();
            String stock =String.valueOf( a.getStockFusee());
            l.setText(stock);
            fusees.setText(String.valueOf( a.getStockFusee()));
            
            JLabel k = new JLabel();
            String Score = String.valueOf(a.getSaveScore());
            k.setText(Score);
            score.setText(String.valueOf(a.getSaveScore()));

           if (a.getIsWinner()) {
               this.gridPanel.revalidate();
               ImageIcon icon = new ImageIcon("sea.png");
               JLabel label2 = new JLabel(icon);
               this.gridPanel.add(label2);
//               System.out.println("VOUS AVEZ GAGNE");
           }
        }
        this.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("");
    }
}
