import java.awt.*;
import javax.swing.*;

public class Pacman extends JFrame {
    static int lives = 3;
    static int score = 0;
    static JLabel shscore;
    static JLabel shlives;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pac-man");

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.black);
        infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        shlives = new JLabel("Lives: " + lives);
        shlives.setForeground(Color.yellow);
        shlives.setFont(new Font("Arial", Font.PLAIN, 15));
        infoPanel.add(shlives);

        shscore = new JLabel("Score: " + score);
        shscore.setForeground(Color.yellow);
        shscore.setFont(new Font("Arial", Font.PLAIN, 15));
        infoPanel.add(shscore);

        //GamePanel gamePanel = new GamePanel();
        Map gameMap = new Map();

        frame.setLayout(new BorderLayout());
        frame.add(infoPanel, BorderLayout.NORTH);
        frame.add(gameMap, BorderLayout.CENTER);

        frame.setSize(640, 690);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void updateScore(int newScore) {
        score = newScore;
        shscore.setText("Score: " + score);
    }

    public static void updateLives() {
        shlives.setText("Lives: " + lives);
    }
}
