package model;

public abstract class Shape {
    protected int x;
    protected int y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract boolean notOutOfBoundsUp(int x, int y);

    public abstract boolean notOutOfBoundsDown(Plateau p, int x, int y);

    public abstract boolean notOutOfBoundsLeft(int x, int y);

    public abstract boolean notOutOfBoundsRight(Plateau p, int x, int y);

}

