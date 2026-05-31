package ui;

import manager.HighscoreManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HighScoreScreen extends JDialog {

    private final HighscoreManager highScoreManager;


    public HighScoreScreen(JFrame owner) {
        super(owner, "High Scores", true);
        this.highScoreManager = new HighscoreManager();
        init();
    }

    /**
     * Initializes the high score screen UI components and loads scores from the file
     */
    public void init() {
        setSize(400, 600);
        setResizable(false);
        setLocationRelativeTo(getOwner());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel jpanel = new JPanel();
        jpanel.setBackground(Color.WHITE);
        jpanel.setLayout(new GridBagLayout());

        JPanel inner = new JPanel(new BorderLayout(0, 12));
        inner.setBackground(Color.WHITE);
        inner.setPreferredSize(new Dimension(300, 480));

        JLabel title = new JLabel("⭐ HIGH SCORES", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.BLACK);

        JPanel listPanel = new JPanel(new GridLayout(0, 1, 0, 6));
        listPanel.setBackground(Color.WHITE);

        List<Integer> scores = highScoreManager.loadScores();

        if (scores.isEmpty()) {
            JLabel empty = new JLabel("No scores yet – play a game!", SwingConstants.CENTER);
            empty.setFont(new Font("Arial", Font.PLAIN, 16));
            empty.setForeground(Color.BLACK);
            listPanel.add(empty);
        } else {
            for (int i = 0; i < scores.size(); i++) {
                JLabel scoreLabel = new JLabel(String.format("%d. %d", i + 1, scores.get(i)));
                scoreLabel.setFont(new Font("Arial", Font.BOLD, 18));
                scoreLabel.setForeground(Color.BLACK);
                listPanel.add(scoreLabel);
            }
        }

        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setBorder(null);

        // Close button
        JButton closeButton = new JButton("CLOSE");
        closeButton.setFont(new Font("Arial", Font.BOLD, 16));
        closeButton.setBackground(Color.BLACK);
        closeButton.setForeground(Color.WHITE);
        closeButton.addActionListener(e -> dispose());

        inner.add(title, BorderLayout.NORTH);
        inner.add(scrollPane, BorderLayout.CENTER);
        inner.add(closeButton, BorderLayout.SOUTH);

        jpanel.add(inner);
        add(jpanel);
        setVisible(true);
    }
}
