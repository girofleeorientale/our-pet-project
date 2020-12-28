package model;


public class Animal {

    private static int numero = 9;
    private int posX;
    private int posY;

    public Animal(int posX, int posY) {

        this.posX = posX;
        this.posY = posY;
    }

    int getNumero() {
        return numero;
    }

    int getPosX() {
        return posX;
    }

    int getPosY() {
        return posY;
    }

    public void setPositions(int x, int y) {
        posX = x;
        posY = y;
    }


}
