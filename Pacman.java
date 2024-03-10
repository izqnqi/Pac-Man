import java.awt.*;
import javax.swing.*;

public class Pacman extends JFrame {
static JFrame a;
static JLabel l;


public static void main(String[] args) {
    a = new JFrame("Pac-man");
    JPanel p = new JPanel();
    ImageIcon originalIcon = new ImageIcon("images/Pac-Man-Logo.png");
    Image originalImage = originalIcon.getImage();

    int newWidth = 500;
    int newHeight = 300;
    Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

    ImageIcon resizedIcon = new ImageIcon(resizedImage);


    p.setBackground(Color.black);
    l = new JLabel(resizedIcon);
    a.add(p);
    p.add(l);
    a.setSize(800, 800);
    a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    a.setVisible(true);
    a.show();
}
}

