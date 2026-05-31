package FallingObjects;

import java.awt.*;

public abstract class FallingObject {
    private int a;
    private int x;
    private int y;
    private float speed;
    private boolean catched;

    public FallingObject(int x, int y, int a, float speed, boolean catched) {
        this.a=a;
        this.x=x;
        this.y=y;
        this.speed=speed;
        this.catched = false;
    }

    public abstract Color getColor();

    /**
     * Moves the object downward (falling)
     */
    public void falling(){
        y+=speed;
    }

    /**
     * Marks the object as caught
     */
    public void playerCatcheObject(){
        catched=true;
    }


    public abstract String playerCatcheObjectString();

    /**
     * Updates the object's position
     */
    public void update() {

        y += (int) speed;
    }

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

    /**
     * Draws the object as a circle on the screen
     * @param g2d the graphics context
     * @param fill fill color
     */
    public void drawCircle(Graphics2D g2d, Color fill) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(fill);
        g2d.fillOval(x - a / 2, y - a / 2, a, a);
        g2d.drawOval(x - a / 2, y - a / 2, a, a);
    }
}
