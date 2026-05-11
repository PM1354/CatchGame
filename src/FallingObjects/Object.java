package FallingObjects;

import java.awt.*;

public abstract class Object {
    private int a;
    private int x;
    private int y;
    private float speed;
    private boolean catched;

    public Object(int x, int y, int a,float speed,boolean catched) {
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

    public float getSpeed() {
        return speed;
    }

    public boolean isCatched() {
        return catched;
    }

    public void drawCircle(Graphics2D g2d, Color fill, Color border) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(fill);
        g2d.fillOval(x - a / 2, y - a / 2, a, a);
        g2d.setColor(border);
        g2d.setStroke(new java.awt.BasicStroke(2f));
        g2d.drawOval(x - a / 2, y - a / 2, a, a);
    }
}
