package Snake.Graphics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Square extends JPanel {
    private Random rand = new Random();
    private ArrayList<Color> C =new ArrayList<Color>();
    private int color;
    public Square(int color){
        C.add(Color.BLUE);
        C.add(Color.GREEN);
        C.add(Color.ORANGE);
        C.add(Color.YELLOW);
        C.add(Color.PINK);
        C.add(Color.RED);
        C.add(Color.WHITE);
        C.add(Color.BLACK);
        this.color=color;
        this.setBackground(C.get(this.color));
    }
    public void setColor(int color){
        this.color=color;
        this.setBackground(C.get(this.color));
        this.repaint();
    }
    public int getColor(){
        return color;
    }
    public void randomColor(){
        setColor(rand.nextInt(6));
    }
}
