package FallingObjects;

import java.awt.*;

public abstract class Object {
    private int a;
    private int x;
    private int y;
    private int speed;
    private boolean catched;

    public Object(int x, int y, int a,int speed,boolean catched) {
        this.a=a;
        this.x=x;
        this.y=y;
        this.speed=speed;
        this.catched = false;
    }

    public abstract Color getColor();

    public void falling(){
        y+=speed;
    }

    public void playerCatcheObject(){
        catched=true;
    }


    public abstract String playerCatcheObjectString();

    public int getA() {
        return a;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isCatched() {
        return catched;
    }
}
