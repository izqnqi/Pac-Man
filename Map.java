import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Map extends JPanel implements ActionListener {
    private int score;
    private int lives;

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    private void showImages(){
        ImageIcon up = new ImageIcon("images/pm-up.png");
        ImageIcon down = new ImageIcon("images/pm-down.png");
        ImageIcon right = new ImageIcon("images/pm-right.png");
        ImageIcon left = new ImageIcon("images/pm-left.png");
        ImageIcon ghostBlue = new ImageIcon("images/blue ghost.png");
        ImageIcon ghostRed = new ImageIcon("images/red ghost.png");
        ImageIcon ghostYellow = new ImageIcon("images/yellow ghost.png");
        ImageIcon ghostPink = new ImageIcon("images/pink ghost.png");
    }

    private void showScore(Graphics2D s){
        s.setColor(new Color(255,255,102));
        s.setFont(new Font("Arial",Font.PLAIN, 15));
        String string = "Score: " + score;
        s.drawString(string,20,20);
    }

}
