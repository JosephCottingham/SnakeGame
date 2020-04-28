package GameObject;

abstract public class GameObject {
    protected int ID, areaX, areaY;
    protected int dir = 2;
    protected Position position;

    abstract public int getColor();
    abstract public int getID();
    abstract public void collected();
    abstract public void setDir(int value);
    abstract public int getDir();
    abstract public void move();
    public Position getPos(){
        return position;
    }

    public boolean isTouching(GameObject o){
        int y = 0;
        if (ID==o.getID()) {
            ++y;
            for (; y < o.getPos().length; y++) {
                if (position.length>0 && position.getX(0) == o.getPos().getX(y) && position.getY(0) == o.getPos().getY(y)) return true;
            }
        } else {
            for (; y < o.getPos().length; y++) {
                for (int x = 0; x < position.length; x++){
                    if (position.getX(x) == o.getPos().getX(y) && position.getY(x) == o.getPos().getY(y)) return true;
                }
            }
        }
        return false;
    }

}
