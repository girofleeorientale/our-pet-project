package model;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Case extends JFrame implements MouseListener {


    private String colorCase;
    public boolean isPressed;

    public Case() {
        this.isPressed = false;
        this.colorCase = "white";
    }

    public Case(String color) {
        this.colorCase = color;
    }

    public String getColor() {
        return this.colorCase;
    }

    public void setColor(String color) {
        this.colorCase = color;
    }

    public String toString() {
        String ch = String.valueOf(colorCase.charAt(0));
        return ch.toUpperCase();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        this.isPressed = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.isPressed = true;
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
