package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CellViewOld extends JPanel implements MouseListener {
    int x;
    int y;
    public boolean isPressed;
    Color color;

    public CellViewOld() {

    }

    public CellViewOld(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.isPressed = false;
        this.color = color;
        this.addMouseListener(this);
        this.setSize(10,10);
        this.setBackground(color);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println("HELLO");
//        int x = e.getX();
//        int y = e.getY();
        isPressed = true;
//        System.out.println("X :" + x + isPressed);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        isPressed = true;
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
