package model;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Case  {
    private String colorCase;
    private boolean isAnimal;

    public Case() {
        this.colorCase = "white";
        this.isAnimal = false;
    }

    public Case(String color) {
        this.colorCase = color;
    }

    public String getColor() {
        return this.colorCase;
    }

    public void setIsAnimal(boolean animal) {
        this.isAnimal = animal;
    }

    public boolean getIsAnimal() {
        return this.isAnimal;
    }

    public void setColor(String color) {
        this.colorCase = color;
    }
    public String toString () {
        String ch = String.valueOf(colorCase.charAt(0));
        return ch.toUpperCase();
    }
		
	}
