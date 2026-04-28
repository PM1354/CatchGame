package ui;

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
        frame.setPreferredSize(new Dimension(800,1200));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel,BoxLayout.Y_AXIS));
        frame.setBackground(Color.blue);

        JButton jbstart = new JButton("START");
        jbstart.setForeground( new Color(133, 126, 126));
        jbstart.setBackground(Color.RED);

        JButton jbhighscore = new JButton("HIGHEST SCORE");
        jbhighscore.setForeground( new Color(133, 126, 126));
        jbhighscore.setBackground(Color.RED);
        jpanel.add(jbstart);
        jpanel.add(jbhighscore);

        frame.add(jpanel);
        frame.setVisible(true);
        frame.pack();

    }
}
