import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Images extends JPanel implements ActionListener {
    private JLabel upL, downL, rightL, leftL, inky, blinky, clyde, pinky;

public Images(){
    showImages();
}

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void showImages() {
        upL = new JLabel(new ImageIcon("images/pm-up.png"));
        downL = new JLabel(new ImageIcon("images/pm-down.png"));
        rightL = new JLabel(new ImageIcon("images/pm-right.png"));
        leftL = new JLabel(new ImageIcon("images/pm-left.png"));
        inky = new JLabel(new ImageIcon("images/blue ghost.png"));
        blinky = new JLabel(new ImageIcon("images/red ghost.png"));
        clyde = new JLabel(new ImageIcon("images/yellow ghost.png"));
        pinky = new JLabel(new ImageIcon("images/pink ghost.png"));

        add(upL);
        add(downL);
        add(rightL);
        add(leftL);
        add(inky);
        add(blinky);
        add(clyde);
        add(pinky);
        setLayout(null);


        upL.setBounds(10, 10, 10, 20);
        rightL.setBounds(1,1,1,1);
        downL.setBounds(30, 30, 20, 60);
        inky.setBounds(100, 100, 30, 60);
        blinky.setBounds(200, 200, 30, 60);
        clyde.setBounds(300, 300, 30, 60);
        pinky.setBounds(40, 40, 20, 40);


    }

    public JLabel getpacman(){
    return rightL;
    }
    public JLabel getGhostPink() {
        return pinky;
    }

    public JLabel getGhostBlue() {
        return inky;
    }

    public JLabel getGhostRed() {
        return blinky;
    }
    public JLabel getGhostYellow(){
    return clyde;
    }
}