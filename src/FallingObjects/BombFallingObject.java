package FallingObjects;

import Player.Player;

import java.awt.*;

public class BombFallingObject extends FallingObject implements CatchingItem{

    private final Color primary = new Color(67,68,69);
    private final Color border = new Color(0,0,0);

    public BombFallingObject(int x, int y, float speed) {
        super(x, y, 20, speed, false);
    }

    @Override
    public Color getColor() {
        return primary;
    }

    /**
     * Returns the text displayed when the bomb is caught
     * @return text with heart loss
     */
    @Override
    public String playerCatcheObjectString() {
        return "-1\uD83D\uDC94";
    }

    /**
     * Handles bomb being caught by player - removes 1 heart
     * @param p player who caught the bomb
     */
    @Override
    public void catched(Player p) {
        p.loseHeart();
        playerCatcheObject();
    }
}
