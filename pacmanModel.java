import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class pacmanModel {
    private final Images images;
    private static final int blockSize = 25;
    public int px = 13;
    public int py = 17;
    private int currentDirection;
    private Map map; //map obj
    private Ghosts ghosts; //ghost obj

    public pacmanModel(Map map, Ghosts ghosts) {
        images = new Images();
        this.map = map;
        this.ghosts = ghosts;
    }

    public JLabel getpacman() {
        return images.getpacman();
    }

    public void pacmanMovement(int direction) {
        currentDirection = direction;
    }

    public void movePacman(int[][] map) {
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
                Pacman.score++;
                Pacman.updateScore(Pacman.score);
            }
            int pacmanSize = blockSize + 2;
            int pacmanX = px * blockSize + (blockSize - pacmanSize) / 2;
            int pacmanY = py * blockSize + (blockSize - pacmanSize) / 2;
            images.getpacman().setBounds(pacmanX, pacmanY, pacmanSize, pacmanSize);
            images.repaint();

        }

    }

    public void resetPacman() {
        px = 13;
        py = 17;
    }

    public void drawPacman(Graphics g, int blockSize) {
        Image pacmanImage = ((ImageIcon) images.getpacman().getIcon()).getImage();
        int pacmanSize = blockSize + 2;
        int pacmanX = px * blockSize + (blockSize - pacmanSize) / 2;
        int pacmanY = py * blockSize + (blockSize - pacmanSize) / 2;
        g.drawImage(pacmanImage, pacmanX, pacmanY, pacmanSize, pacmanSize, null);
    }

    boolean checkCollisionWithGhost(int x, int y) {
        boolean collided = (x == ghosts.bx && y == ghosts.by) || (x == ghosts.pix && y == ghosts.piy) || (x == ghosts.cx && y == ghosts.cy) || (x == ghosts.ix && y == ghosts.iy);
        if (collided) {
            Pacman.lives--;
            if (Pacman.lives > 0) {
                this.map.resetGame();
            } else {
                this.map.gameOver();
            }
        }
        return collided;
    }
}
