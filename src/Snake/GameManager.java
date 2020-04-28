// CSE 205: 11333 | Tue/Thu 4:30 PM
// Assignment: Six Final Project
// Author: Joseph H Cottingham | 1216723703
// Description: Manages the game thought directing interactions between GameObject, Graphics, and Leaderboard packages

package Snake;

import Snake.LeaderBoard.LeaderBoardAdaptor;
import Snake.LeaderBoard.LeaderBoardManager;

// I decieded to extend thread because it gives the future option to add this on to a larger project more easly with
// for example a general game management window or multiple systems going at once such as notifations from messaging
public class GameManager extends Thread {
    // Size go game grid
    private int areaY = 16;
    private int areaX = 16;

    static public GameObjectManager gameObjects;
    private GameGraphicsManager gameGraphics = new GameGraphicsManager(areaX, areaY);

    private LeaderBoardAdaptor leaderBoardAdaptor = new LeaderBoardAdaptor();

    public static Boolean gameRunning = false;
    public static Integer input = 0;

    public GameManager() {
        // game grid defaults to 16x16
    }

    public void configureGame(int areaX, int areaY) {
        this.areaX = areaX;
        this.areaY = areaY;
    }

    @Override
    public void run() {
        // runs game in a recursive fashion on this thread
        runGame();
        // for now once recursion is done, the whole program stops
        System.exit(0);
    }

    private void runGame() {
        input = 0;
        gameObjects = new GameObjectManager(areaX, areaY, 3);
        // setup graphics
        gameGraphics.init();
        gameGraphics.refreshMatrix(gameObjects);
        gameRunning = true;
        while (gameRunning) {
            // runs the game round, and if true is returned then gameover event occured
            if (gameObjects.runRound()) {
                gameOver();
                return;
            }

            // refresh graphics for current round movements
            gameGraphics.refreshMatrix(gameObjects);
            try {
                // waits 250 ms to allow player to fallow game
                // TODO this could be set a seting the same as graph size to give more/less challenge
                sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void gameOver() {
        gameGraphics.gameOver(gameObjects.getScore());

        gameRunning = false;
        try {
            sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // temp stores the value so another thread can not modify it before our use is done
        int temp;
        do {
            temp = input;
            if (temp != 0) {
                switch (temp) {
                    case KeyboardListener.BACKSPACE:
                        return;
                    case KeyboardListener.SPACE:
                        runGame();
                        return;
                    case KeyboardListener.ENTER:
                        if (leaderBoardAdaptor.loadLeaderBoard())
                            new LeaderBoardManager(leaderBoardAdaptor).addToLeaderboard(gameObjects.getScore());
                        input = 0;
                        break;
                    case KeyboardListener.BACKSLASH:
                        if (leaderBoardAdaptor.loadLeaderBoard())
                            new LeaderBoardManager(leaderBoardAdaptor).showLeaderboard();
                        input = 0;
                        break;
                }
            }
            System.out.print("");
        } while (temp != KeyboardListener.SPACE);
    }
}
