public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Game Snake");
        GameManager gameManager = new GameManager();
        gameManager.configureGame(16,16);
        gameManager.run();
        while (gameManager.isAlive()){
            Thread.sleep(1000);
        }
    }
}
