package ui;

import Player.Player;

import javax.swing.*;
import java.awt.*;

public class GameScreen {
    private JFrame frame;

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

        frame.setVisible(true);
        frame.pack();

        Player p = new Player(20,100);
        while (p.isAlive()){

        }
    }
}
