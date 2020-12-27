package model;

public class Case {
	
	
	private String colorCase;

    public Case() {
        this.colorCase = "white";
    }

    public Case (String color) {
        this.colorCase = color;
    }

    public String getColor() {
        return this.colorCase;
    }

    public void setColor (String color) {
        this.colorCase = color;
    }

    public String toString () {
        String ch = String.valueOf(colorCase.charAt(0));
        return ch.toUpperCase();
    }
	
	

}
