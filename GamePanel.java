import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    private final int blockSize = 30;
    public GamePanel() {
        Images map = new Images();

        add(map.getGhostPinkL());
        add(map.getGhostBlueL());
        add(map.getGhostRedL());
        add(map.getGhostYellow());

    }


    private int[][] map = {
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1},
            { 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1},
            { 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            { 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1},
            { 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            { 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1},
            { 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (map[row][col] == 1) {
                    g.setColor(Color.BLUE);
                    g.fillRect(col * blockSize, row * blockSize, blockSize, blockSize);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillRect(col * blockSize, row * blockSize, blockSize, blockSize);
                    g.setColor(Color.WHITE);
                    g.fillOval(col * blockSize + (blockSize / 2 - 2), row * blockSize + (blockSize / 2 - 2), 5, 5);
                }
            }
        }
    }
}
