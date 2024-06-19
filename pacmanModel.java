import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class pacmanModel extends Map implements ActionListener {
    public pacmanModel() {
        super();
        images = new Images();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private final Images images;
    private static final int blockSize = 25;
    static int px = 13; // pacman position x
    static int py = 17; // pacman position y
    private static int currentDirection;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        JLabel pacmanLabel = images.getpacman();
        Image pacmanImage = ((ImageIcon) pacmanLabel.getIcon()).getImage();
        int pacmanSize = blockSize + 2;
        int pacmanX = px * blockSize + (blockSize - pacmanSize) / 2;
        int pacmanY = py * blockSize + (blockSize - pacmanSize) / 2;
        g.drawImage(pacmanImage, pacmanX, pacmanY, pacmanSize, pacmanSize, this);
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
                Pacman.score++;
                Pacman.updateScore(Pacman.score);
            }

            int pacmanSize = blockSize + 2;
            int pacmanX = px * blockSize + (blockSize - pacmanSize) / 2;
            int pacmanY = py * blockSize + (blockSize - pacmanSize) / 2;
            images.getpacman().setBounds(pacmanX, pacmanY, pacmanSize, pacmanSize);
            repaint();
        }
    }
     boolean checkCollisionWithGhost(int x, int y) {
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
}
