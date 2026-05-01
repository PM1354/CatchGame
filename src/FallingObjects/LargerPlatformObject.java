package FallingObjects;

import Player.Player;

import java.awt.*;

public class LargerPlatformObject extends Object implements CatchingItem {

    public LargerPlatformObject(int x, int y, int a, int speed, boolean catched) {
        super(x, y, a, speed, catched);
    }

    @Override
    public void catched(Player p) {

    }
}
