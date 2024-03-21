import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Map extends JPanel implements ActionListener {
    private JLabel upL, downL, rightL, leftL, ghostBlueL, ghostRedL, ghostYellowL, ghostPinkL;


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void showImages() {
        upL = new JLabel(new ImageIcon("images/pm-up.png"));
        downL = new JLabel(new ImageIcon("images/pm-down.png"));
        rightL = new JLabel(new ImageIcon("images/pm-right.png"));
        leftL = new JLabel(new ImageIcon("images/pm-left.png"));
        ghostBlueL = new JLabel(new ImageIcon("images/blue ghost.png"));
        ghostRedL = new JLabel(new ImageIcon("images/red ghost.png"));
        ghostYellowL = new JLabel(new ImageIcon("images/yellow ghost.png"));
        ghostPinkL = new JLabel(new ImageIcon("images/pink ghost.png"));

        add(upL);
        add(downL);
        add(rightL);
        add(leftL);
        add(ghostBlueL);
        add(ghostRedL);
        add(ghostYellowL);
        add(ghostPinkL);
        setLayout(null);

        upL.setBounds(30,30,20,60);
        downL.setBounds(30,30,20,60);
        ghostBlueL.setBounds(30,30,50,100);
    }

    public JLabel getGhostPinkL() {
        return ghostPinkL;
    }

    public JLabel getGhostBlueL() {
        return ghostBlueL;
    }

    public JLabel getGhostRedL() {
        return ghostRedL;
    }
}