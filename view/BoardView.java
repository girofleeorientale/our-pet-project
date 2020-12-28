package view;

import controller.Controller;
import model.Case;
import model.Plateau;


import javax.swing.*;
import java.awt.*;

public class BoardView extends JFrame {
    JFrame frame = new JFrame();
    Plateau plateau;
    GridLayout gridLayout = new GridLayout(8, 8);
    JPanel gridPanel = new JPanel(gridLayout);
    public CellView [][] cellViews = new CellView[8][8];
//    Controller controller;

    public BoardView (Plateau plateau) {
//        Controller controller = new Controller(plateau);
        plateau.placeShapes();
        this.draw(plateau);
        frame.add(gridPanel);
        frame.setSize(400, 400);
        frame.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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

    public static void main(String[] args) {
        BoardView boardView = new BoardView(new Plateau(8, 8));
        CellView cellView = new CellView(9, 9 , new Color(0,6,0));
    }
}
