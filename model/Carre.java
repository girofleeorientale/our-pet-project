package model;

public class Carre extends Shape {
    int x;
    int y;
    int val = 1;

    public Carre () {

    }

    public Carre (Plateau p, int x, int y) {
        this.x = x;
        this. y = y;
//        if (okToPlace()) {
//            p.valeurs[x][y] = 1;
//            p.valeurs[x][y+1] = 1;
//            p.valeurs[x+1][y] = 1;
//            p.valeurs[x+1][y+1] = 1;
//        }
    }

    public boolean notOutOfBoundsUp (int x, int y) {
        boolean res = true;
        if (x < 0) {
            res = false;
        }
        return res;
    }

    public boolean notOutOfBoundsDown (Plateau p, int x, int y) {
        boolean res = true;
        if (x >= p.getLargeur()) {
            res = false;
        }
        return res;
    }

    public boolean notOutOfBoundsLeft (int x, int y) {
        boolean res = true;
        if (y < 0) {
            res = false;
        }
        return res;
    }

    public boolean notOutOfBoundsRight (Plateau p, int x, int y) {
        boolean res = true;
        if (y >= p.getHauteur()) {
            res = false;
        }
        return res;
    }

}
