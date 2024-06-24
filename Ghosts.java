import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Ghosts {
    private Images images;

    public Ghosts() {
        images = new Images();
    }

    public int bx = 14, by = 11;
    public int pix = 14, piy = 13;
    public int ix = 12, iy = 13;
    public int cx = 16, cy = 13;

    private int blinkyMoveCounter = 0;

    public void blinkyMovement(int px, int py) {
        blinkyMoveCounter++;
        if (blinkyMoveCounter % 4 == 0) { //speed of blinky
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

    public void pinkyMovement(int[][] map) {
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

        if (newPx >= 0 && newPy >= 0 && newPx < map[0].length && newPy < map.length && map[newPy][newPx] != 1) {
            pix = newPx;
            piy = newPy;
        }
    }

    public void clydeMovement(int[][] map) {
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
        }
        if (newCx >= 0 && newCy >= 0 && newCx < map[0].length && newCy < map.length && map[newCy][newCx] != 1) {
            cx = newCx;
            cy = newCy;
        }
    }

    public void inkyMovement(int[][] map) {
        Random random = new Random();
        int direction = random.nextInt(4);
        int newIx = ix;
        int newIy = iy;

        switch (direction) {
            case 0:
                newIy--;
                break;
            case 1:
                newIy++;
                break;
            case 2:
                newIx--;
                break;
            case 3:
                newIx++;
                break;
            default:
                break;
        }
        if (newIx >= 0 && newIy >= 0 && newIx < map[0].length && newIy < map.length && map[newIy][newIx] != 1) {
            ix = newIx;
            iy = newIy;
        }
    }

    public void drawGhosts(Graphics g, int blockSize) {
        drawGhost(g, images.getGhostRed(), bx, by, blockSize);
        drawGhost(g, images.getGhostPink(), pix, piy, blockSize);
        drawGhost(g, images.getGhostBlue(), ix, iy, blockSize);
        drawGhost(g, images.getGhostYellow(), cx, cy, blockSize);
    }

    private void drawGhost(Graphics g, JLabel ghostLabel, int x, int y, int blockSize) {
        ImageIcon ghostIcon = (ImageIcon) ghostLabel.getIcon();
        Image ghostImage = ghostIcon.getImage();
        g.drawImage(ghostImage, x * blockSize + 1, y * blockSize, blockSize + 2, blockSize + 2, null);
    }

    public Images getImages() {
        return images;
    }
}
