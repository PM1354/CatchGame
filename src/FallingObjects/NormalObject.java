package FallingObjects;

import Player.Player;

import java.awt.*;

public class NormalObject extends Object implements CatchingItem {

    private final Color primary = new Color(255, 150, 0);
    private final Color border = new Color(0,0,0);

    public NormalObject(int x, int y,float speed) {
        super(x, y, 20, speed, false);
    }

    @Override
    public Color getColor() {
        return primary;
    }

    @Override
    public String playerCatcheObjectString() {
        return "+100⭐";
    }

    @Override
    public void catched(Player p) {
        p.addScore(100);
        playerCatcheObject();
    }



    public void drawObject (Graphics2D g2d){
        g2d.drawOval(getX(),getY(),getA(),getA());
        g2d.fillOval(getX(),getY(),getA()-2,getA()-2);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
}
