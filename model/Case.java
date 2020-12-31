package model;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Case  {


    private String colorCase;
    public boolean isAnimal;

    public Case() {
        this.colorCase = "white";
        isAnimal = false;
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
    public String toString () {
        String ch = String.valueOf(colorCase.charAt(0));
        return ch.toUpperCase();
    }
		
	}
