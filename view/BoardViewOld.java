package view;

import controller.ControllerOld;
import controller.MyController;
import model.Plateau;


import javax.swing.*;
import java.awt.*;

public class BoardViewOld extends JFrame {
    JFrame frame = new JFrame();
    Plateau plateau;
    GridLayout gridLayout = new GridLayout(8, 8);
    public JPanel gridPanel = new JPanel(gridLayout);
    public CellViewOld[][] cellViews = new CellViewOld[8][8];
    ControllerOld controller;

    public BoardViewOld(Plateau plateau) {
        MyController controller = new MyController(plateau, this, 0, 0);
        plateau.placeShapes();
        this.draw(plateau);
        frame.add(gridPanel);
        frame.setSize(400, 400);
        frame.setVisible(true);

        if (plateau.colors[0][0].isPressed) {
            System.out.println("бляяяяя");
        }

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void draw (Plateau plateau) {
        for (int i = 0; i< plateau.hauteur; i++) {
            for (int j = 0; j< plateau.hauteur; j++) {
                cellViews[i][j] = new CellViewOld(i, j, knowColor(plateau.colors[i][j].getColor()));
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
        BoardViewOld boardView = new BoardViewOld(new Plateau(8, 8));
        CellViewOld cellView = new CellViewOld(9, 9 , new Color(0,6,0));
    }
}
