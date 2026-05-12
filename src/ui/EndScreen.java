package ui;

import Player.Player;
import ui.backgrounds.BackgroundOne;

import javax.swing.*;
import java.awt.*;

    public class EndScreen {
    private JFrame frame;
    private int score;


    public EndScreen(int score){
        frame = new JFrame();
        this.score = score;
        innit();
    }

    public void innit(){

        JPanel jp = new BackgroundOne();
        jp.setLayout(new GridBagLayout());
        JPanel inner = new JPanel(new GridLayout(2,1,10,15));
        inner.setBackground(new Color(255, 255, 255, 0));
        inner.setPreferredSize(new Dimension(250,400));

        frame.setSize(600,1000);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(800,1000));

        JLabel jl = new JLabel("SCORE: "+score);
        jl.setFont(new Font("Comic Sans",Font.PLAIN,30));
        jl.setForeground(Color.BLACK);

        JButton jbmenu = new JButton("MENU");
        jbmenu.setFont(new Font("Comic Sans",Font.PLAIN,30));
        jbmenu.setBackground(Color.BLACK);
        jbmenu.setForeground(Color.WHITE);

        inner.add(jl);
        inner.add(jbmenu);
        jp.add(inner);



        frame.add(jp);
        frame.setVisible(true);
        frame.pack();
    }
}
