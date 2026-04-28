package FallingObjects;

import Player.Player;

import java.awt.*;

public class BombObject extends Object implements BadItem{
    private Color clr = new Color(181, 151, 151, 26);
    public BombObject(int hitboxesX, int hitboxesY) {
        super(hitboxesX, hitboxesY);
    }

    @Override
    public void catched(Player p) {
        p.setHearts(p.getHearts()-1);
    }
}
