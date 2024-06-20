import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class pacmanModel {
    private final Images images;
    private static final int blockSize = 25;
    public int px = 13;
    public int py = 17;
    private int currentDirection;
    private Map map;

    public pacmanModel() {
        images = new Images();
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
            px = newX;
            py = newY;

            if (map[py][px] == 0) {
                map[py][px] = 2;
                Pacman.score++;
                Pacman.updateScore(Pacman.score);
            }
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
    public int bx = 14, by = 11;
    public int pix = 14, piy = 13;
    public int ix = 12, iy = 13;
    public int cx = 16, cy = 13;


    boolean checkCollisionWithGhost(int x, int y) {
        boolean collided = (x == bx && y == by) || (x == pix && y == piy) || (x == cx && y == cy) || (x == ix && y == iy);
        if (collided) {
            Pacman.lives--;
            if (Pacman.lives > 0) {
                map.resetGame();
            } else {
                map.gameOver();
            }
        }
      return collided;
    }


}
