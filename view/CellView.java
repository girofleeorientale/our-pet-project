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
        this.setSize(10, 10);
        this.setBackground(color);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setVisible(true);
    }

    public int getCordX() {
        return this.x;
    }

    public int getCordY() {
        return this.y;
    }

    public void setColor(Color c) {
        this.color = c;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

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