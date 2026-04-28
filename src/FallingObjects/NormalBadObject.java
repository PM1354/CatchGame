package FallingObjects;

import Player.Player;

import java.awt.*;

public class NormalBadObject extends Object implements BadItem{
    private Color clr = new Color(38, 76, 48, 126);
    public NormalBadObject(int hitboxesX, int hitboxesY) {
        super(hitboxesX, hitboxesY);
    }

    @Override
    public void catched(Player p) {
        p.setScore(p.getScore()-500);
    }
}
