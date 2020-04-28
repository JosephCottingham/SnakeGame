package Snake.GameObject;

import java.util.Random;

public class Coin extends GameObject{
    private Position position;
    private Random rand = new Random();
    private int ID;

    public Coin(int ID, int areaX, int areaY){
        this.areaX = areaX;
        this.areaY = areaY;
        this.ID = ID;
        position = new Position(new int[]{rand.nextInt(this.areaY-2)+1}, new int[]{rand.nextInt(this.areaX-2)+1}, 1);
        randomPos();
    }

    @Override
    public void collected(){
        randomPos();
    }

    @Override
    public void setDir(int dir) {
        this.dir = dir;
    }

    @Override
    public int getDir() {
        return dir;
    }

    @Override
    public void move() {
        randomPos();
    }

    public void randomPos(){
        position.setX(0,rand.nextInt(areaX-2)+1);
        position.setY(0,rand.nextInt(areaY-2)+1);
    }

    @Override
    public int getColor() {
        return 3;
    }

    @Override
    public Position getPos() {
        return position;
    }



    @Override
    public int getID() {
        return ID;
    }
}
