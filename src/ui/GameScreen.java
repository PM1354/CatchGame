package ui;

import Player.Player;

import javax.swing.*;
import java.awt.*;

public class GameScreen {
    private JFrame frame;
    private GamePanel gamePanel;

    public GameScreen(){
        frame = new JFrame();
        innit();
    }

    public void innit(){
        frame.setSize(600,1000);
        frame.setPreferredSize(new Dimension(600,1000));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setBackground(Color.DARK_GRAY);

        gamePanel = new GamePanel();
        frame.add(gamePanel);

        frame.setVisible(true);
        frame.pack();
    }

    public void startGame() {
        frame.setVisible(true);
        gamePanel.startGame();
    }

}
