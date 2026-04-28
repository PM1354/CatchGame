package FallingObjects;

import Player.Player;

import java.awt.*;

public class HeartObject extends Object implements GoodItem{
    private Color clr = new Color(255,0,0);
    public HeartObject(int hitboxesX, int hitboxesY) {
        super(hitboxesX, hitboxesY);
    }

    @Override
    public void catched(Player p) {

    }
}
