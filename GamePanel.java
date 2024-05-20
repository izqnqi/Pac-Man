import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    private final Images images;
    private int blinkyMoveCounter = 0;

    private final Timer moveTimer;
    private int currentDirection;

    public GamePanel() {
        images = new Images();
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                pacmanMovement(key);
            }
        }); moveTimer = new Timer(150, this);
        moveTimer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        movePacman();
        blinkyMovement();
        pinkyMovement();
        clydeMovement();
        inkyMovement();
        repaint();
    }

    private final int blockSize = 25;
    int score = 0;
    int px = 13; // pacman position x
    int py = 17; // pacman position y

    int bx = 17; // blinky x
    int by = 25;
    int cx = 12; // clyde
    int cy = 13;
    int ix = 20; // inky
    int iy = 10;
    int pix = 5; // pinky
    int piy = 23;


    private int[][] map = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
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
                } else {
                    g.setColor(Color.BLACK);
                    g.fillRect(col * blockSize, row * blockSize, blockSize, blockSize);
                    g.setColor(Color.WHITE);
                    g.fillOval(col * blockSize + (blockSize / 2 - 2), row * blockSize + (blockSize / 2 - 2), 5, 5);
                }
            }
        }

        //draw pacman on the map
        JLabel pacmanLabel = images.getpacman();
        Image pacmanImage = ((ImageIcon) pacmanLabel.getIcon()).getImage();
        int pacmanSize = blockSize + 2;
        int pacmanX = px * blockSize + (blockSize - pacmanSize) / 2;
        int pacmanY = py * blockSize + (blockSize - pacmanSize) / 2;
        g.drawImage(pacmanImage, pacmanX, pacmanY, pacmanSize, pacmanSize, this);
        //draw blinky
        JLabel ghostRedLabel = images.getGhostRed();
        ImageIcon ghostRedIcon = (ImageIcon) ghostRedLabel.getIcon();
        Image ghostRedImage = ghostRedIcon.getImage();
        g.drawImage(ghostRedImage, bx * blockSize + 1, by * blockSize,
                blockSize + 2, blockSize + 2, this);

        // draw pinky
        JLabel pinkyLabel = images.getGhostPink();
        ImageIcon pinkyIcon = (ImageIcon) pinkyLabel.getIcon();
        Image ghostPinkyImage = pinkyIcon.getImage();
        g.drawImage(ghostPinkyImage, pix * blockSize +1, piy * blockSize ,
                blockSize + 2, blockSize + 2, this);

        //draw inky
        JLabel inkyLabel = images.getGhostBlue();
        ImageIcon inkyIcon = (ImageIcon) inkyLabel.getIcon();
        Image ghostInkyImage = inkyIcon.getImage();
        g.drawImage(ghostInkyImage, ix * blockSize + 1, iy * blockSize ,
                blockSize + 2, blockSize + 2, this);

        // draw clyde
        JLabel clydeLabel = images.getGhostYellow();
        ImageIcon clydeIcon = (ImageIcon) clydeLabel.getIcon();
        Image ghostClydeImage = clydeIcon.getImage();
        g.drawImage(ghostClydeImage, cx * blockSize + 1, cy * blockSize ,
                blockSize + 2, blockSize + 2, this);
    }


    public void pacmanMovement(int direction) {
        currentDirection = direction;
    }

    public void movePacman() {
        int newX = px;
        int newY = py;

        switch (currentDirection) {
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

        if (newX >= 0 && newY >= 0 && newX < map[0].length && newY < map.length && map[newY][newX] != 1) {
            if (checkCollisionWithGhost(newX, newY)) {
                return;
            }
            px = newX;
            py = newY;

            if (map[py][px] == 0) {
                map[py][px] = 2;
                score++;
                Pacman.updateScore(score);
            }

            int pacmanSize = blockSize + 2;
            int pacmanX = px * blockSize + (blockSize - pacmanSize) / 2;
            int pacmanY = py * blockSize + (blockSize - pacmanSize) / 2;
            images.getpacman().setBounds(pacmanX, pacmanY, pacmanSize, pacmanSize);
            repaint();
        }
    }



    //method for checking if pacman collides with any of the ghosts
    private boolean checkCollisionWithGhost(int x, int y) {
        boolean collided = (x == bx && y == by) || (x == pix && y == piy) || (x == cx && y == cy) || (x == ix && y == iy);
        if (collided) {
            Pacman.lives--;
            if (Pacman.lives > 0) {
                resetGame();
            } else {
                gameOver();
            }
        }
        return collided;
    }

    //reseting the game to it's starting point
    public void resetGame() {
        px = 13;
        by = 25;
        cx = 12;
        cy = 13;
        ix = 20;
        iy = 10;
        pix = 5;
        piy = 23;
        Pacman.updateLives();
        repaint();
    }
    public void gameOver() {
        moveTimer.stop();
        JOptionPane.showMessageDialog(this, "GAME OVER!", "game over",JOptionPane.INFORMATION_MESSAGE);
    }


    public void blinkyMovement() {
        blinkyMoveCounter++;
        if (blinkyMoveCounter % 2 == 0) { //speed of blinky
            if (bx < px) {
                bx++;
            } else if (bx > px) {
                bx--;
            }
            if (by < py) {
                by++;
            } else if (by > py) {
                by--;
            }
        }
    }

    public void pinkyMovement() {
        Random random = new Random();
        int direction = random.nextInt(4);
        int newPx = pix;
        int newPy = piy;
        switch (direction) {
            case 0:
                newPy--;
                break;
            case 1:
                newPy++;
                break;
            case 2:
                newPx--;
                break;
            case 3:
                newPx++;
                break;
            default:
                break;
        }

        //checks for walls
        if (newPx >= 0 && newPy >= 0 && newPx < map[0].length && newPy < map.length && map[newPy][newPx] != 1) {
            pix = newPx;
            piy = newPy;
            //update pinky position
        }
    }



    public void clydeMovement() {
        Random random = new Random();
        int direction = random.nextInt(4);
        int newCx = cx;
        int newCy = cy;
        switch (direction) {
            case 0:
                newCy--;
                break;
            case 1:
                newCy++;
                break;
            case 2:
                newCx--;
                break;
            case 3:
                newCx++;
                break;
            default:
                break;
        } if (newCx >= 0 && newCy >= 0 && newCx < map[0].length && newCy < map.length && map[newCy][newCx] != 1) {
            cx = newCx;
            cy = newCy;
        }
    }



    public void inkyMovement() {
        Random random = new Random();
        int direction = random.nextInt(4);
        int newIx = ix;
        int newIy = iy;

        switch (direction) {
            case 0: newIy--;
                break;
            case 1:newIy++;
                break;
            case 2: newIx--;
                break;
            case 3: newIx++;
                break;
            default:
                break;
        }
        if (newIx >= 0 && newIy >= 0 && newIx < map[0].length && newIy < map.length && map[newIy][newIx] != 1) {
            //update inky position
            ix = newIx;
            iy = newIy;
        }
    }
}
