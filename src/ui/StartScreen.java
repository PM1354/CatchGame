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
        frame.setSize(600,1000);
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
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        title.setForeground(Color.BLACK);


        JButton jbstart = new JButton("START");
        jbstart.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
       // jbstart.setBackground( new Color(235, 175, 255, 0));
        jbstart.setBackground(Color.BLACK);
        jbstart.setForeground(Color.WHITE);

        JButton jbhighscore = new JButton("HIGHSCORE");
        jbhighscore.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        //jbhighscore.setBackground( new Color(235, 175, 255, 0));
        jbhighscore.setBackground(Color.BLACK);
        jbhighscore.setForeground(Color.WHITE);

        jbstart.addActionListener(e -> {
            frame.dispose();
            GameScreen gs = new GameScreen();
            gs.startGame();
        });

        jbhighscore.addActionListener(e->{
            HighScoreScreen hss = new HighScoreScreen(frame);
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

