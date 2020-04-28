package Snake;

import Snake.Graphics.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class GameGraphicsManager extends JFrame {
    private Square[][] screenMatrix;
    private Square[][] bufferMatrix;
    private Square[][] gameOverMatrix;
    private int areaX;
    private int areaY;

    public GameGraphicsManager(int areaX, int areaY) {
        this.areaX = areaX;
        this.areaY = areaY;
        setTitle("Snake Game");
        setSize(700,700);
        setVisible(true);

        this.addKeyListener((KeyListener) new KeyboardListener());
    }

    public void init() {
        // populates matrixs with intlized variables
        this.screenMatrix = populateMatrix();
        this.bufferMatrix = populateMatrix();

        // clears pane and filles with screenMatrix
        getContentPane().removeAll();
        getContentPane().setLayout(new GridLayout(areaY,areaX,0,0));
        for(int i=0;i<areaY;i++){
            for(int j=0;j<areaX;j++){
                getContentPane().add(screenMatrix[i][j]);
            }
        }
        SwingUtilities.updateComponentTreeUI(getContentPane());
    }

    private Square[][] populateMatrix(){
        System.out.println("Populate");
        Square[][] tempMatrix = new Square[areaY][areaX];
        for (int i = 0; i < areaY; i++) {
            for (int j = 0; j < areaX; j++) {
                tempMatrix[i][j] = new Square(6);
            }
        }
        return tempMatrix;
    }

    public void refreshMatrix(GameObjectManager gameObjectManager) {
        paintBufferMatrix(6);
        placeObjects(gameObjectManager);
        setDisplayBufferMatrix();
    }

    // Setts entire matrix to color
    private void paintBufferMatrix(int color){
        for (int i = 0; i < areaY; i++) {
            for (int j = 0; j < areaX; j++) {
                this.bufferMatrix[i][j].setColor(color);
            }
        }
    }

    private void placeObjects(GameObjectManager gameObjectManager){
        for (int x = 0; x < gameObjectManager.size(); x++){
            for (int y = 0; y < gameObjectManager.get(x).getPos().length; y++){
                this.bufferMatrix[gameObjectManager.get(x).getPos().getY(y)][gameObjectManager.get(x).getPos().getX(y)].setColor(gameObjectManager.get(x).getColor());
            }
        }
    }

    // sets screenMatrix to the values of buffer to display
    private void setDisplayBufferMatrix(){
        for (int y = 0; y < areaY; y++){
            for (int x = 0; x < areaX; x++){
                this.screenMatrix[y][x].setColor(this.bufferMatrix[y][x].getColor());
            }
        }
    }

    public void gameOver(int Score) {

        paintBufferMatrix(6);

        try {
            flashColor(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        createGameOverMatrix(Score);
        displayGameOverMatrix();

    }

    private void displayGameOverMatrix(){
        getContentPane().removeAll();
        getContentPane().setLayout(new GridLayout(3,3,0,0));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                getContentPane().add(gameOverMatrix[i][j]);
            }
        }
        SwingUtilities.updateComponentTreeUI(getContentPane());
    }

    private void createGameOverMatrix(int Score){
        gameOverMatrix = new Square[5][5];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                gameOverMatrix[i][j] = new Square(1);
            }
        }
        genGameOverSides(0, 0);
        gameOverMatrix[1][1] = new GameOverSquare(7, Score);
    }

    private void genGameOverSides(int y, int x){
        boolean change=false;
        if (x<3) {
            change = true;
            this.gameOverMatrix[x][0].randomColor();
        }
        if (y<3) {
            change = true;
            this.gameOverMatrix[0][y].randomColor();
        }
        if (x<3) {
            change = true;
            this.gameOverMatrix[3 - 1 - x][3 - 1].randomColor();
        }
        if (y<3) {
            change = true;
            this.gameOverMatrix[3 - 1][3 - 1 - y].randomColor();
        }
        if (change) genGameOverSides(++y, ++x);
        else return;
    }

//    public void printScreen() {
//        for (int i = 0; i < areaY; i++) {
//            for (int j = 0; j < areaX; j++) {
//                if (this.screenMatrix[i][j].color==6)
//                    System.out.print(".");
//                else System.out.print(this.screenMatrix[i][j].color);
//            }
//            System.out.println();
//            System.out.println();
//            System.out.println();
//
//        }
//    }

    private void flashColor(int color) throws InterruptedException {
        for (int x = 0; x < 10; x++) {
            paintBufferMatrix(color);
            setDisplayBufferMatrix();
            Thread.sleep(100);
            paintBufferMatrix(6);
            setDisplayBufferMatrix();
            Thread.sleep(20);
        }
    }



    public void clearLocation(int x, int y) {
        this.screenMatrix[y][x] = new Square(6);
    }
}
