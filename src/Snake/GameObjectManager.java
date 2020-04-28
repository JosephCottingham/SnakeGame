package Snake;

import Snake.GameObject.GameObject;
import Snake.GameObject.MyStack;
import Snake.GameObject.*;

// stores game objects and manages interation
public class GameObjectManager {
    private MyStack<GameObject> list;

    public GameObjectManager(int areaX, int areaY, int numOfCoins){
        list = new MyStack<GameObject>();
        list.push(new Wall(areaX, areaY));
        list.push(new Snake(1, areaX, areaY));
        for (int x = 0; x < numOfCoins; x++) list.push(new Coin(x+2, areaX, areaY));
    }

    public GameObjectManager(int areaX, int areaY) {
        list = new MyStack<GameObject>();
        list.push(new Wall(areaX, areaY));
        list.push(new Snake(1, areaX, areaY));
        list.push(new Coin(2, areaX, areaY));
    }

    public GameObject get(int index){
        return list.get(index);
    }

    public int size(){
        return list.size();
    }

    public int getScore(){
        return Snake().getPos().length;
    }
    public int getSnakeDir(){
        return Snake().getDir();
    }
    public void setSnakeDir(int dir){
        Snake().setDir(dir);
    }
    public boolean runRound(){
        gameMove();
        return isGameOver();
    }

    private boolean isGameOver(){
        if (Snake().isTouching(Wall()) || Snake().isTouching(Snake())) return true;
        return false;
    }

    private void gameMove(){
        for (int x = 0; x < list.size()-2; x++){
            if(Snake().isTouching(list.get(x))){
                Snake().collected();
                list.get(x).collected();
            }
        }
        Snake().move();
    }

    private GameObject Snake(){
        return list.get(list.size()-2);
    }
    private GameObject Wall(){
        return list.get(list.size()-1);
    }
}
