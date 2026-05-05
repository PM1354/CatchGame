package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BackgroundOne extends JPanel {
    private Image image;

    public BackgroundOne(){
        try {
            image = ImageIO.read(getClass().getResource("/image1.jpg"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
