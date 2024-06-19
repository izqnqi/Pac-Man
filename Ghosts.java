import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Ghosts extends Map {
    public Ghosts() {
        super();
        images = new Images();
    }


    private int blinkyMoveCounter = 0;
    private  Images images;
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
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

    public void blinkyMovement() {
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

