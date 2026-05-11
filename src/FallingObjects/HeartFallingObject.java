package FallingObjects;

import Player.Player;

import java.awt.*;

public class HeartFallingObject extends FallingObject implements CatchingItem {

    private final Color primary = new Color(255, 0, 0);
    private final Color border = new Color(0,0,0);

    public HeartFallingObject(int x, int y, float speed) {
        super(x, y, 20, speed, false);
    }

    @Override
    public Color getColor() {
        return primary;
    }

    @Override
    public String playerCatcheObjectString() {
        return "+1❤️";
    }

    @Override
    public void catched(Player p) {
        p.addHears(1);
        playerCatcheObject();
    }
}

