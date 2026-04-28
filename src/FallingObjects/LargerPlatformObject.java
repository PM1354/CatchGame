package FallingObjects;

import Player.Player;

import java.awt.*;

public class LargerPlatformObject extends Object implements GoodItem{
    private Color clr = new Color(0, 149, 255);

    public LargerPlatformObject(int hitboxesX, int hitboxesY) {
        super(hitboxesX, hitboxesY);
    }

    @Override
    public void catched(Player p) {
        p.setHitboxesX(p.getHitboxesX()*2);
    }
}
