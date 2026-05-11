package ui;

import ui.backgrounds.BackgroundOne;

import javax.swing.*;
import java.awt.*;

public class StartScreen {
    private JFrame frame;
    public StartScreen(){
        frame = new JFrame();
        innit();
    }

    public void innit(){
        frame.setSize(800,1000);
        frame.setPreferredSize(new Dimension(600,1000));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel jpanel = new BackgroundOne();
        jpanel.setLayout(new GridBagLayout());

        JPanel inner = new JPanel(new GridLayout(3,1,10,15));
        inner.setBackground(new Color(255, 255, 255, 0));
        inner.setPreferredSize(new Dimension(250,400));

        JLabel title = new JLabel("CATCH GAME",SwingConstants.CENTER);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Arial", Font.BOLD,30));

        JButton jbstart = new JButton("▶ START");
        jbstart.setBackground( new Color(235, 175, 255));
        jbstart.setForeground(Color.WHITE);

        JButton jbhighscore = new JButton("⭐HIGHEST SCORE⭐");
        jbhighscore.setBackground( new Color(235, 175, 255));
        jbhighscore.setForeground(Color.WHITE);

        jbstart.addActionListener(e -> {
            frame.dispose();
            GameScreen gs = new GameScreen();
            gs.startGame();
        });

        inner.add(title);
        inner.add(jbstart);
        inner.add(jbhighscore);
        jpanel.add(inner);

        frame.add(jpanel);
        frame.setVisible(true);
        frame.pack();

    }
}
