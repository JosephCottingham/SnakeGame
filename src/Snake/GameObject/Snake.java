package Snake.GameObject;

public class Snake extends GameObject{
    private int headX;
    private int headY;

    public Snake(int ID, int areaX, int areaY){
        this.areaX = areaX;
        this.areaY = areaY;
        this.ID = ID;
        headY = areaY/2;
        headX = areaX/2;
        position = new Position(new int[]{headY}, new int[]{headX}, 1);
    }


    @Override
    public void collected(){
        for (int y = 0; y < position.length; y++){
            System.out.print(position.getX(y));
        }
        for (int y = 0; y < position.length; y++){
            System.out.print(position.getY(y));
        }
        int[] tempX = new int[position.length+1];
        int[] tempY = new int[position.length+1];
        for (int x = 0; x < position.length; x++){
            tempX[x] = position.getX(x);
            tempY[x] = position.getY(x);
        }
        position.setYX(tempY, tempX, position.length+1);
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
    public void move(){
        System.out.println("MOVE");
        for (int x = position.length-1; x > 0; --x){
            position.setY(x, position.getY(x-1));
            position.setX(x, position.getX(x-1));
        }
        switch (dir){
            case 0:
                headY--;
                position.setY(0, headY);
                position.setX(0, headX);
                break;
            case 1:
                headX++;
                position.setY(0, headY);
                position.setX(0, headX);
                break;
            case 2:
                headY++;
                position.setY(0, headY);
                position.setX(0, headX);
                break;
            case 3:
                headX--;
                position.setY(0, headY);
                position.setX(0, headX);
                break;
        }
    }


    @Override
    public int getID() {
        return ID;
    }

    @Override
    public int getColor() {
        return 1;
    }

    @Override
    public Position getPos() {
        return position;
    }
}
