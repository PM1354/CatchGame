package manager;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighscoreManager {

    private static final String FILE_NAME  = "highscores.txt";
    private static final int    MAX_SCORES = 10;

    public void addScore(int score) {
        if (score <= 0) return;

        List<Integer> scores = loadScores();
        scores.add(score);
        Collections.sort(scores, Collections.reverseOrder());

        while (scores.size() > MAX_SCORES) {
            scores.remove(scores.size() - 1);  // remove lowest
        }

        saveScores(scores);
    }

    public List<Integer> loadScores() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();

        List<Integer> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    scores.add(Integer.parseInt(line.trim()));
                } catch (NumberFormatException e) {
                    System.err.println("HighScoreManager: Invalid score format – " + line);
                }
            }
            Collections.sort(scores, Collections.reverseOrder());
        } catch (IOException e) {
            System.err.println("HighScoreManager: could not read scores – " + e.getMessage());
        }

        return scores;
    }

    private void saveScores(List<Integer> scores) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Integer score : scores) {
                writer.write(score.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("HighScoreManager: could not save scores – " + e.getMessage());
        }
    }
}
