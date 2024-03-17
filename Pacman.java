import java.awt.*;
import javax.swing.*;

public class Pacman extends JFrame {
static JFrame a;
static JLabel l;
static int lives;
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
    Map mapPanel = new Map();


    p.setBackground(Color.black);
    a.getContentPane().add(mapPanel);
    mapPanel.setBounds(0, 0, 400, 400);
    mapPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
    mapPanel.setBackground(Color.black);

    JLabel shlives = new JLabel(" Lives: " + lives, JLabel.LEFT);
    shlives.setForeground(Color.yellow);
    shlives.setFont(new Font("Arial", Font.PLAIN, 15));
    mapPanel.add(shlives);
    JLabel shscore = new JLabel("Score: " +score, JLabel.RIGHT);
    shscore.setForeground(Color.yellow);
    shscore.setFont(new Font("Arial", Font.PLAIN, 15));
    mapPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    mapPanel.add(shscore);

  //  mapPanel.add(mapPanel.getGhostBlueL());


    l = new JLabel(resizedIcon);
    p.add(l, BorderLayout.NORTH);
    a.add(p);
    p.add(l);

    p.add(mapPanel.getGhostBlueL());
    p.add(mapPanel.getGhostPinkL());
    p.add(mapPanel.getGhostRedL());

    a.setSize(800, 800);
    a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    a.setVisible(true);
    a.show();

}
}

