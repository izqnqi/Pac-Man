import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class GamePanel extends JPanel implements ActionListener {

    private Images images;
    private String gameOverr;
    public GamePanel() {
        images = new Images();
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                pacmanMovement(key);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    private final int blockSize = 25;
    int food = 10;
    int score = 0;
    int lives = 3;
    int timer = 150;
    int moves; // move count
    int px = 13; //pacman position x
    int py = 17; //pacman position y

    int bx = 17; // blinky
    int by = 25;
    int cx = 12; // clyde
    int cy = 13;
    int ix = 13; // inky
    int iy = 13;
    int pix = 14; // pinky
    int piy = 13;

//15-inky, 16-pinky, 17-clyde, 18-blinky, 13-pacman
    private int[][] map = {
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            { 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1},
            { 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 18, 0, 1},
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            { 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
            { 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
            { 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 3, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
            { 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 15, 16, 17, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1},
            { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            { 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1},
            { 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            { 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            { 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            { 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            { 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            { 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1},
            { 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            { 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1},
            { 1, 0, 13, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1},
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (map[row][col] == 1) {
                    g.setColor(Color.BLUE);
                    g.fillRect(col * blockSize, row * blockSize, blockSize, blockSize);
                } else if (map[row][col] == 2 || map[row][col] == 3) {
                    g.setColor(Color.BLACK);
                    g.fillRect(col * blockSize, row * blockSize, blockSize, blockSize);
                }
                else if (map[row][col] == 18) {
                    JLabel blinkyLabel = images.getGhostRed();
                    Image blinkyImage = ((ImageIcon) blinkyLabel.getIcon()).getImage();
                    int blinkySize = blockSize + 2;
                    g.drawImage(blinkyImage, col * blockSize + (blockSize - blinkySize) / 2,
                            row * blockSize + (blockSize - blinkySize) / 2,
                            blinkySize, blinkySize, this);

                } else if (map[row][col] == 16){
                    JLabel pinkyLabel = images.getGhostPink();
                    Image pinkyImage = ((ImageIcon) pinkyLabel.getIcon()).getImage();
                    int pinkySize = blockSize + 2;
                    g.drawImage(pinkyImage, col * blockSize + (blockSize - pinkySize) / 2,
                            row * blockSize + (blockSize - pinkySize) / 2,
                            pinkySize, pinkySize, this);

                } else if (map[row][col] == 17) {
                    JLabel clydeLabel = images.getGhostYellow();
                    Image clydeImage = ((ImageIcon) clydeLabel.getIcon()).getImage();
                    int clydeSize = blockSize +2;
                    g.drawImage(clydeImage, col * blockSize + (blockSize - clydeSize) / 2,
                            row * blockSize + (blockSize - clydeSize) / 2,
                            clydeSize, clydeSize, this);

                } else if (map[row][col] == 15) {
                    JLabel inkyLabel = images.getGhostBlue();
                    Image inkyImage = ((ImageIcon) inkyLabel.getIcon()).getImage();
                    int inkySize = blockSize + 2;
                    g.drawImage(inkyImage, col * blockSize + (blockSize - inkySize) / 2,  row * blockSize + (blockSize - inkySize) / 2, inkySize, inkySize, this);
                }
                else if (map[row][col] == 13){
                    JLabel pacmanLabel = images.getpacman();
                    Image pacmanImage = ((ImageIcon) pacmanLabel.getIcon()).getImage();
                    int pacmanSize = blockSize + 2;
                    int pacmanX = px * blockSize + (blockSize - pacmanSize) / 2; // calculate pacman x position
                    int pacmanY = py * blockSize + (blockSize - pacmanSize) / 2; //calculate pacman y position
                    g.drawImage(pacmanImage, pacmanX, pacmanY, pacmanSize, pacmanSize, this);
                }
                else {
                    g.setColor(Color.BLACK);
                    g.fillRect(col * blockSize, row * blockSize, blockSize, blockSize);
                    g.setColor(Color.WHITE);
                    g.fillOval(col * blockSize + (blockSize / 2 - 2), row * blockSize + (blockSize / 2 - 2), 5, 5);
                }

            }
        }
    }


    public void pacmanMovement(int direction){
        //px
        // py
        int newX = px;
        int newY = py;

       //new coordinates
        switch (direction) {
            case KeyEvent.VK_UP:
                newY--;
                break;
            case KeyEvent.VK_DOWN:
                newY++;
                break;
            case KeyEvent.VK_LEFT:
                newX--;
                break;
            case KeyEvent.VK_RIGHT:
                newX++;
                break;
            default:
                break;
        }

        //proverka na prostranstvoto (steni)
        if (newX >= 0 && newY >= 0 && newX < map[0].length && newY < map.length && map[newY][newX] != 1) {

            px = newX;
            py = newY;

            // check if pacman ate the dot
            if (map[py][px] == 0) {
                map[py][px] = 2;
                score++;
                Pacman.updateScore(score);
            }

            // update the location of the pacman JLabel
            int pacmanSize = blockSize + 2;
            int pacmanX = px * blockSize + (blockSize - pacmanSize) / 2;
            int pacmanY = py * blockSize + (blockSize - pacmanSize) / 2;
            images.getpacman().setBounds(pacmanX, pacmanY, pacmanSize, pacmanSize);
            System.out.println("Pacman Position: (" + pacmanX + ", " + pacmanY + ")");
            repaint();
        }
    }
    private void gameOver(){
        lives--;
        if (lives == 0){
        JLabel stopGame = new JLabel("GAME OVER!");
        stopGame.setForeground(Color.yellow);
        stopGame.setFont(new Font("Arial", Font.PLAIN, 55));
        }
    }

    public void blinkyMovement() {

    }

    public void pinkyMovement(){

    }
    public void clydeMovement(){

    }
    public void inkyMovement(){

    }
    public void gameCondition(){
        if (lives == 0){
            gameOver();
        }
    }
}
