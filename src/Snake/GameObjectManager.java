// CSE 205: 11333 | Tue/Thu 4:30 PM
// Assignment: Six Final Project
// Author: Joseph H Cottingham | 1216723703
// Description: Manages the game object, allow data to be quickly gathered such as score, and hands objects over to
// graphics package to be show graphicy in a effecient manor

package Snake;

import Snake.GameObject.Coin;
import Snake.GameObject.GameObject;
import Snake.GameObject.Snake;
import Snake.GameObject.Wall;
import Snake.Support.Stack;

// stores game objects and manages interation
public class GameObjectManager {
    private Stack<GameObject> list;

    public GameObjectManager(int areaX, int areaY, int numOfCoins) {
        list = new Stack<GameObject>();
        list.push(new Wall(areaX, areaY));
        list.push(new Snake(1, areaX, areaY));
        for (int x = 0; x < numOfCoins; x++) list.push(new Coin(x + 2, areaX, areaY));
    }

    public GameObjectManager(int areaX, int areaY) {
        list = new Stack<GameObject>();
        list.push(new Wall(areaX, areaY));
        list.push(new Snake(1, areaX, areaY));
        list.push(new Coin(2, areaX, areaY));
    }

    public GameObject get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }

    public int getScore() {
        return Snake().getPos().length;
    }

    public int getSnakeDir() {
        return Snake().getDir();
    }

    public void setSnakeDir(int dir) {
        Snake().setDir(dir);
    }

    public boolean runRound() {
        // Move the snake
        // check if coin is collected
        gameMove();
        // return/check if gameover condiation is meet
        return isGameOver();
    }

    private boolean isGameOver() {
        // check if snake is touching the wall or itself
        return Snake().isTouching(Wall()) || Snake().isTouching(Snake());
    }

    private void gameMove() {
        // list.size -2 because last two in stack are wall and snake
        for (int x = 0; x < list.size() - 2; x++) {
            // check if snake is touch coin
            if (Snake().isTouching(list.get(x))) {
                Snake().collected();
                list.get(x).collected();
            }
        }
        Snake().move();
    }

    // Key objects shortcuts
    private GameObject Snake() {
        return list.get(list.size() - 2);
    }

    private GameObject Wall() {
        return list.get(list.size() - 1);
    }
}
