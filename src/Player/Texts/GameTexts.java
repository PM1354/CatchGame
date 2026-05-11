package Player.Texts;

import java.awt.*;

public class GameTexts {

    private final int timeVisible = 45;
    private final float rising =1.2f;
    private float x;
    private float y;
    private final String text;
    private final Color color;
    private int ticksVisible;

    public GameTexts(String text, Color color, float y, float x) {
        this.text = text;
        this.color = color;
        this.y = y;
        this.x = x;
    }

    public void timerplus(){
        ticksVisible++;
    }

    public boolean notActive(){
        return ticksVisible>=timeVisible;
    }

    public void draw(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font("SansSerif", Font.BOLD, 16));
        g2d.setColor(color);
        g2d.drawString(text, x, y);

    }
}
