package FallingObjects;

import Player.Player;

import java.awt.*;

public class BombObject extends Object implements CatchingItem{

    private final Color primary = new Color(67,68,69);
    private final Color border = new Color(0,0,0);

    public BombObject(int x, int y, int a, int speed, boolean catched) {
        super(x, y, 20, speed, false);
    }

    @Override
    public Color getColor() {
        return primary;
    }

    @Override
    public String playerCatcheObjectString() {
        return "-1\uD83D\uDC94";
    }

    @Override
    public void catched(Player p) {
        p.looseHeart();
        playerCatcheObject();
    }
}
