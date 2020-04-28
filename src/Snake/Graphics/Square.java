// CSE 205: 11333 | Tue/Thu 4:30 PM
// Assignment: Six Final Project
// Author: Joseph H Cottingham | 1216723703
// Description: Square that displays during game run, holds colors in a modifiable way that allows for the Graphics
// manager to quickly change squares color

package Snake.Graphics;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Square extends JPanel {
    private Random rand = new Random();
    private Color[] colorList = new Color[]{Color.BLUE, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.PINK, Color.RED, Color.WHITE, Color.BLACK};
    private int color;

    public Square(int color) {
        this.color = color;
        this.setBackground(colorList[this.color]);
    }

    public void setColor(int color) {
        this.color = color;
        this.setBackground(colorList[this.color]);
        this.repaint();
    }

    public int getColor() {
        return color;
    }

    public void randomColor() {
        setColor(rand.nextInt(6));
    }
}
