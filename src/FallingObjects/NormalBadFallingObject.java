package FallingObjects;

import Player.Player;

import java.awt.*;

public class NormalBadFallingObject extends FallingObject implements CatchingItem{

    private final Color primary = new Color(12, 200, 36);
    private final Color border = new Color(0,0,0);

    public NormalBadFallingObject(int x, int y, float speed) {
        super(x, y, 20, speed, false);
    }

    @Override
    public Color getColor() {
        return primary;
    }

    /**
     * Returns the text displayed when the object is caught
     * @return text with points decrease
     */
    @Override
    public String playerCatcheObjectString() {
        return "-500⭐";
    }

    /**
     * Handles object being caught by player - removes 500 points
     * @param p player who caught the object
     */
    @Override
    public void catched(Player p) {
        p.loseScore(500);
        playerCatcheObject();
    }
}
