package ui;

import Player.Player;

import javax.swing.*;
import java.awt.*;

public class GameScreen {
    private JFrame frame;
    private GamePanel gamePanel;

    public GameScreen(){
        frame = new JFrame();
        init();
    }

    /**
     * Initializes the game screen UI components
     */
    public void init(){
        frame.setSize(600,1000);
        frame.setPreferredSize(new Dimension(600,1000));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        gamePanel = new GamePanel(this);
        frame.add(gamePanel);

        frame.setVisible(true);
        frame.pack();
    }

    /**
     * Displays the window and starts the game
     */
    public void startGame() {
        frame.setVisible(true);
        gamePanel.startGame();
    }

    /**
     * Handles game over and displays the end screen with the final score
     * @param score final score
     */
    public void gameOver(int score){
        EndScreen es = new EndScreen(score);
        frame.dispose();
    }

}
