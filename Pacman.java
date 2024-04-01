import java.awt.*;
import javax.swing.*;

public class Pacman extends JFrame {
static JFrame a;
static JLabel l;
static int lives = 3;
static int score;



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
    a.getContentPane().add(gameP);
    gameP.setBounds(0, 0, 400, 400);
    gameP.setBorder(BorderFactory.createLineBorder(Color.blue));
    gameP.setBackground(Color.black);

    JLabel shlives = new JLabel(" Lives: " + lives, JLabel.LEFT);
    shlives.setForeground(Color.yellow);
    shlives.setFont(new Font("Arial", Font.PLAIN, 15));
    gameP.add(shlives);
    JLabel shscore = new JLabel("Score: " +score, JLabel.RIGHT);
    shscore.setForeground(Color.yellow);
    shscore.setFont(new Font("Arial", Font.PLAIN, 15));
    gameP.setLayout(new FlowLayout(FlowLayout.CENTER));
    gameP.add(shscore);

    l = new JLabel(resizedIcon);
    p.add(l, BorderLayout.NORTH);
    a.add(p);
    p.add(l);
    a.setSize(800, 800);
    a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    a.setVisible(true);
    a.show();

}
}

