package model;

public class LetterIHorizontal extends Shape {
    int x;
    int y;

    public LetterIHorizontal() {

    }

    public LetterIHorizontal(Plateau p, int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean notOutOfBoundsUp (int x, int y) {
        boolean res = true;
        if (x < 0) {
            res = false;
        }
//        System.out.println("notOutOfBoundsLeft " + res);
        return res;
    }

    public boolean notOutOfBoundsDown (Plateau p, int x, int y) {
        boolean res = true;
        if (x >= p.getHauteur()-1) {
            res = false;
        }
//        System.out.println("notOutOfBoundsRight " + res);
        return res;
    }

    public boolean notOutOfBoundsLeft (int x, int y) {
        boolean res = true;
        if (y < 0) {
            res = false;
        }
//        System.out.println("notOutOfBoundsUp " + res);
        return res;
    }

    public boolean notOutOfBoundsRight (Plateau p, int x, int y) {
        boolean res = true;
        if (y >= p.getLargeur()-3) {
            res = false;
        }
//        System.out.println("notOutOfBoundsDown " + res);
        return res;
    }
}
