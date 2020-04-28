package GameObject;

public class Wall extends GameObject {
    private int height;
    private int width;

    public Wall(int areaX, int areaY){
        height = areaY;
        width = areaX;
        position = genWallsPos(0, 0, 0, new int[(2*areaX) + ((2*areaY)-2)], new int[(2*areaX) + ((2*areaY)-2)]);

    }

    private Position genWallsPos(int y, int x, int pos, int[] xVals, int[] yVals){
            boolean change=false;
            if (x<width) {
                change = true;
                xVals[pos] = x;
                yVals[pos] = 0;
                pos++;
            }
            if (y<height) {
                change = true;
                xVals[pos] = 0;
                yVals[pos] = y;
                pos++;
            }
            if (x<width-1) {
                change = true;
                xVals[pos] = width - 1 - x;
                yVals[pos] = height - 1;
                pos++;
            }
            if (y<height-1) {
                change = true;
                xVals[pos] = width - 1;
                yVals[pos] = height - 1 - y;
                pos++;
            }
            if (change) return genWallsPos(++y, ++x, pos, xVals, yVals);
            else return new Position(xVals, yVals, xVals.length);
    }

    @Override
    public int getColor() {
        return 7;
    }


    @Override
    public boolean isTouching(GameObject o) {
        return false;
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void collected() {

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

    }

};
