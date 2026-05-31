package Player.Texts;

import java.awt.*;

public class GameTexts {

    private final int timeVisible = 45;
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

    /**
     * Increases the timer for how long the text is visible
     */
    public void timerplus(){
        ticksVisible++;
    
    }

    /**
     * Checks if text is no longer visible
     * @return true if text is not visible, false otherwise
     */
    public boolean notActive(){
        return ticksVisible>=timeVisible;
    }

    /**
     * Draws text on the screen
     */
    public void draw(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font("SansSerif", Font.BOLD, 16));
        g2d.setColor(color);
        g2d.drawString(text, x, y);

    }
}
