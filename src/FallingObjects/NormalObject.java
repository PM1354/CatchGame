package FallingObjects;

import Player.Player;

import java.awt.*;

public class NormalObject extends Object implements GoodItem{
    private Color clr = new Color(255, 203, 0, 255);

    public NormalObject(int hitboxesX, int hitboxesY) {
        super(hitboxesX, hitboxesY);
        this.clr = clr;
    }

    @Override
    public void catched(Player p) {
        p.setScore(p.getScore()+100);
    }
}
