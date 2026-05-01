package FallingObjects;

import Player.Player;

import java.awt.*;

public class NormalBadObject extends Object implements CatchingItem{

    public NormalBadObject(int x, int y, int a, int speed, boolean catched) {
        super(x, y, a, speed, catched);
    }

    @Override
    public void catched(Player p) {

    }
}
