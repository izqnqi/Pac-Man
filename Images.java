import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Images extends JPanel implements ActionListener {
    private JLabel upL, downL, rightL, leftL, ghostBlue, ghostRed, ghostYellow, ghostPink;

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
        ghostBlue = new JLabel(new ImageIcon("images/blue ghost.png"));
        ghostRed = new JLabel(new ImageIcon("images/red ghost.png"));
        ghostYellow = new JLabel(new ImageIcon("images/yellow ghost.png"));
        ghostPink = new JLabel(new ImageIcon("images/pink ghost.png"));

        add(upL);
        add(downL);
        add(rightL);
        add(leftL);
        add(ghostBlue);
        add(ghostRed);
        add(ghostYellow);
        add(ghostPink);
        setLayout(null);


        upL.setBounds(10, 10, 10, 20);
        downL.setBounds(30, 30, 20, 60);
        ghostBlue.setBounds(100, 100, 30, 60);
        ghostRed.setBounds(200, 200, 30, 60);
        ghostYellow.setBounds(300, 300, 30, 60);
        ghostPink.setBounds(400, 400, 30, 60);


    }

    public JLabel getGhostPinkL() {
        return ghostPink;
    }

    public JLabel getGhostBlueL() {
        return ghostBlue;
    }

    public JLabel getGhostRedL() {
        return ghostRed;
    }
    public JLabel getGhostYellow(){
    return ghostYellow;
    }
}