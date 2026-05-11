package FallingObjects;

import Player.Player;

import java.awt.*;

public class LargerPlatformFallingObject extends FallingObject implements CatchingItem {

    private final Color primary = new Color(50,100,255);
    private final Color border = new Color(0,0,0);

    public LargerPlatformFallingObject(int x, int y, float speed) {
        super(x, y, 20, speed, false);
    }

    @Override
    public Color getColor() {
        return primary;
    }

    @Override
    public String playerCatcheObjectString() {
        return "+10px";
    }

    @Override
    public void catched(Player p) {
        p.biggerPlatform();
        playerCatcheObject();
    }
}
