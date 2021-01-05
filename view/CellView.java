package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CellView extends JPanel implements MouseListener {
    private int x;
    private int y;
    private Color color;

    public CellView(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.addMouseListener(this);
        this.setSize(10, 10);
        this.setBackground(color);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setVisible(true);
    }

    public int getCordX() {
        System.out.println("la coordonnee X est " + this.x);
        return this.x;
    }

    public int getCordY() {
        System.out.println("la coordonnee Y est " + this.y);
        return this.y;
    }

    public void setColor(Color c) {
        this.color = c;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("HELLO");
        int x = e.getX();
        int y = e.getY();
        this.setBackground(new Color(0, 255, 0));
        System.out.println("вот оно из селл" + x);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}