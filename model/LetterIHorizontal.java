package model;

public class LetterIHorizontal extends Shape {

    public LetterIHorizontal(int x, int y) {
        super(x, y);
    }

    public boolean notOutOfBoundsUp(int x, int y) {
        boolean res = true;
        if (x < 0) {
            res = false;
        }
        return res;
    }

    public boolean notOutOfBoundsDown(Plateau p, int x, int y) {
        boolean res = true;
        if (x >= p.getHauteur() - 1) {
            res = false;
        }
        return res;
    }

    public boolean notOutOfBoundsLeft(int x, int y) {
        boolean res = true;
        if (y < 0) {
            res = false;
        }
        return res;
    }

    public boolean notOutOfBoundsRight(Plateau p, int x, int y) {
        boolean res = true;
        if (y >= p.getLargeur() - 3) {
            res = false;
        }
        return res;
    }
}
