import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter {
    private final static int RIGHT = 1;
    private final static int LEFT = 1;
    private final static int UP = 1;
    private final static int DOWN = 1;


    private final static int W = 87;
    private final static int UPARROW = 38;
    private final static int S = 83;
    private final static int DOWNARROW = 40;
    private final static int A = 65;
    private final static int LEFTARROW = 37;
    private final static int D = 68;
    private final static int RIGHTARROW = 39;
    public final static int BACKSPACE = 8;
    public final static int SPACE = 32;
    public final static int ENTER = 10;
    public final static int BACKSLASH = 92;

    @Override
    public void keyPressed(KeyEvent keyEvent){
        switch (keyEvent.getExtendedKeyCode()){
            case RIGHTARROW:
                GameManager.gameObjects.setSnakeDir(1);
                break;
            case D:
                GameManager.gameObjects.setSnakeDir(1);
                break;
            case UPARROW:
                GameManager.gameObjects.setSnakeDir(0);
                break;
            case W:
                GameManager.gameObjects.setSnakeDir(0);
                break;
            case LEFTARROW:
                GameManager.gameObjects.setSnakeDir(3);
                break;
            case A:
                GameManager.gameObjects.setSnakeDir(3);
                break;
            case DOWNARROW:
                GameManager.gameObjects.setSnakeDir(2);
                break;
            case S:
                GameManager.gameObjects.setSnakeDir(2);
                break;
            case BACKSPACE:
                if(GameManager.gameRunning.booleanValue()==false) GameManager.input = BACKSPACE;
                break;
            case SPACE:
                if(GameManager.gameRunning.booleanValue()==false) GameManager.input = SPACE;
                break;
            case ENTER:
                if(GameManager.gameRunning.booleanValue()==false) GameManager.input = ENTER;
                break;
            case BACKSLASH:
                if(GameManager.gameRunning.booleanValue()==false) GameManager.input = BACKSLASH;
                break;
        }
    }
}
