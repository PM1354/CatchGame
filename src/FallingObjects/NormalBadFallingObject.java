package FallingObjects;

import Player.Player;

import java.awt.*;

public class NormalBadFallingObject extends FallingObject implements CatchingItem{

    private final Color primary = new Color(12, 67, 36);
    private final Color borde = new Color(0,0,0);

    public NormalBadFallingObject(int x, int y, float speed) {
        super(x, y, 20, speed, false);
    }

    @Override
    public Color getColor() {
        return primary;
    }

    @Override
    public String playerCatcheObjectString() {
        return "-500⭐";
    }

    @Override
    public void catched(Player p) {
        p.looseScore(500);
        playerCatcheObject();
    }
}
