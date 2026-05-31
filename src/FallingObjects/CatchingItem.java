package FallingObjects;

import Player.Player;

public interface CatchingItem {
    /**
     * Method called when an object is caught by the player
     * @param p player who caught the object
     */
    public void catched(Player p);
}
