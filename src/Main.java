// CSE 205: 11333 | Tue/Thu 4:30 PM
// Assignment: Six Final Project
// Author: Joseph H Cottingham | 1216723703
// Description: Main Class designed to start program

import Snake.GameManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Snake Game management
        GameManager gameManager = new GameManager();
        gameManager.configureGame(16, 16);
        gameManager.run();
        // Currently their is no reason to run a second thread, but I would for example like to build a model that will
        // perfectly beat this game or provide more features
        while (gameManager.isAlive()) {
            Thread.sleep(1000);
        }
    }
}
