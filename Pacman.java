import java.awt.*;
import javax.swing.*;

public class Pacman extends JFrame {
    static JFrame a;
    static JLabel l;
    static int lives = 3;
    static int score;
    static JLabel shscore;

    public static void main(String[] args) {
        a = new JFrame("Pac-man");
        JPanel p = new JPanel();
        ImageIcon originalIcon = new ImageIcon("images/Pac-Man-Logo.png");
        Image originalImage = originalIcon.getImage();

        int newWidth = 500;
        int newHeight = 300;
        Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        GamePanel gameP = new GamePanel();

        p.setBackground(Color.black);
        a.getContentPane().setLayout(new BorderLayout());
        a.getContentPane().add(gameP, BorderLayout.CENTER);
        gameP.setSize(625, 625);
        gameP.setBorder(BorderFactory.createLineBorder(Color.blue));
        gameP.setBackground(Color.black);

        JLabel shlives = new JLabel(" Lives: " + lives, JLabel.LEFT);
        shlives.setForeground(Color.yellow);
        shlives.setFont(new Font("Arial", Font.PLAIN, 15));
        gameP.add(shlives);

        shscore = new JLabel("Score: " + score, JLabel.RIGHT);
        shscore.setForeground(Color.yellow);
        shscore.setFont(new Font("Arial", Font.PLAIN, 15));

        gameP.setLayout(new FlowLayout(FlowLayout.CENTER));
        gameP.add(shscore);

        l = new JLabel(resizedIcon);
        p.add(l, BorderLayout.NORTH);
        a.add(p);
        a.setSize(625, 645);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        a.setLocationRelativeTo(null);

        a.setVisible(true);



    }

    public static void updateScore(int newScore) {
        shscore.setText("Score: " + newScore);
    }

}
