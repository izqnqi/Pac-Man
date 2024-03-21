import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private Dimension d;
    private final int pallet = 24;
    private final int blockSize = 40;
    private int nGhosts = 4;
    private int[] dx, dy;
    private int[] ghostX, ghostDX, ghostY, ghostDY;
    private int pcX, pcY, pcDX, pxDY;
    private int req_DX, req_DY;
    private boolean game = false;

    public GamePanel() {
        addKeyListener(new TAdapter());
    }

    class TAdapter extends KeyAdapter {
        public void keyControls(KeyEvent e) {
            int key = e.getKeyCode();
            if (game) {
                if (key == KeyEvent.VK_RIGHT) {
                    req_DX = 1;
                    req_DY = 0;
                } else if (key == KeyEvent.VK_LEFT) {
                    req_DX = -1;
                    req_DY = 0;
                } else if (key == KeyEvent.VK_UP) {
                    req_DX = 0;
                    req_DY = -1;
                } else if (key == KeyEvent.VK_DOWN) {
                    req_DX = 0;
                    req_DY = 1;
                }
            }

        }
    }

    private int[][] map = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0},
            {0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (map[row][col] == 1) {
                    g.setColor(Color.BLUE);
                    g.fillRect(col * 35, row * 35, 35, 40);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillRect(col * 35, row * 35, 35, 30);
                    g.setColor(Color.WHITE);
                    g.fillOval(5, 5, 5, 5);
                }
            }
        }
    }
}
