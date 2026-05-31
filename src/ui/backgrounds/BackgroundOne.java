package ui.backgrounds;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BackgroundOne extends JPanel {
    private Image image;

    public BackgroundOne() {
        try {
            // Using ClassLoader to find resources is more reliable in Java
            image = ImageIO.read(new File("resources/image.png"));
        } catch (IOException e) {
            System.err.println("Could not load background image: " + e.getMessage());
        }
    }

    /**
     * Draws the background - fills the component with an image
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
