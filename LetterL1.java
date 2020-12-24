public class LetterL1 extends Shape {
    int x;
    int y;

    public LetterL1() {

    }

    public LetterL1 (Plateau p, int x, int y) {
        this.x = x;
        this. y = y;
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
        if (x >= p.hauteur-1) {
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
        if (y >= p.largeur-2) {
            res = false;
        }
        return res;
    }
}
