package Snake;

import Snake.LeaderBoard.LeaderBoardAdaptor;
import Snake.LeaderBoard.LeaderBoardManager;

public class GameManager extends Thread{
    private int areaY = 16;
    private int areaX = 16;

    static public GameObjectManager gameObjects;
    private GameGraphicsManager gameGraphics = new GameGraphicsManager(areaX, areaY);;

    private LeaderBoardAdaptor leaderBoardAdaptor = new LeaderBoardAdaptor();

    public static Boolean gameRunning=false;
    public static Integer input=0;

    public GameManager(){

    }

    public void configureGame(int areaX, int areaY){
        this.areaX = areaX;
        this.areaY = areaY;
    }

    @Override
    public void run() {
        runGame();
        System.exit(1);
    }

    private void runGame(){
        input = 0;
        gameObjects = new GameObjectManager(areaX, areaY, 3);
        gameGraphics.init();
        gameGraphics.refreshMatrix(gameObjects);
        gameRunning = true;
        while (gameRunning){
            if (gameObjects.runRound()){
                gameOver();
                return;
            }

            gameGraphics.refreshMatrix(gameObjects);
            try {
                sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void gameOver(){
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
                        if (leaderBoardAdaptor.loadLeaderBoard()) new LeaderBoardManager(leaderBoardAdaptor).addToLeaderboard(gameObjects.getScore());
                        input=0;
                        break;
                    case KeyboardListener.BACKSLASH:
                        if (leaderBoardAdaptor.loadLeaderBoard()) new LeaderBoardManager(leaderBoardAdaptor).showLeaderboard();
                        input=0;
                        break;
                }
            }
            System.out.print("");
        } while (temp != KeyboardListener.SPACE);
    }
}
