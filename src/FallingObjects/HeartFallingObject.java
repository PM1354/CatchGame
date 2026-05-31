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

    /**
     * Returns the text displayed when the heart is caught
     * @return text with heart addition
     */
    @Override
    public String playerCatcheObjectString() {
        return "+1❤️";
    }

    /**
     * Handles heart being caught by player - adds 1 heart
     * @param p player who caught the heart
     */
    @Override
    public void catched(Player p) {
        p.addHearts(1);
        playerCatcheObject();
    }
}
