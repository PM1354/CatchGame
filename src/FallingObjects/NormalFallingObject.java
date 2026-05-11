package FallingObjects;

import Player.Player;

import java.awt.*;

public class NormalFallingObject extends FallingObject implements CatchingItem {

    private final Color primary = new Color(255, 150, 0);
    private final Color border = new Color(0,0,0);

    public NormalFallingObject(int x, int y, float speed) {
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
}
