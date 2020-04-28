package Snake.Graphics;

import javax.swing.*;
import java.awt.*;

public class GameOverSquare extends Square {
    int score;
    JLabel headerLabel;
    JLabel scoreLabel;
    JLabel quitLabel;
    JLabel restartLabel;
    JLabel leaderboardShowLabel;
    JLabel leaderboardAddLabel;

    public GameOverSquare(int color, int score) {
        super(color);
        this.score = score;
        headerLabel = new JLabel("Game Over!");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 30));
        headerLabel.setForeground(Color.WHITE);
        scoreLabel = new JLabel("You Scored " + score);
        scoreLabel.setFont(new Font("Serif", Font.BOLD, 20));
        scoreLabel.setForeground(Color.WHITE);
        quitLabel = new JLabel("Press BACKSPACE to Quit");
        quitLabel.setFont(new Font("Serif", Font.BOLD, 14));
        quitLabel.setForeground(Color.WHITE);
        restartLabel = new JLabel("Press SPACE to Restart");
        restartLabel.setFont(new Font("Serif", Font.BOLD, 14));
        restartLabel.setForeground(Color.WHITE);
        leaderboardShowLabel = new JLabel("Press BACKSLASH to Show Leaderboard");
        leaderboardShowLabel.setFont(new Font("Serif", Font.BOLD, 14));
        leaderboardShowLabel.setForeground(Color.WHITE);
        leaderboardAddLabel = new JLabel("Press ENTER to Add Score To Leaderboard");
        leaderboardAddLabel.setFont(new Font("Serif", Font.BOLD, 12));
        leaderboardAddLabel.setForeground(Color.WHITE);

        add(headerLabel);
        add(scoreLabel);
        add(quitLabel);
        add(restartLabel);
        add(leaderboardShowLabel);
        add(leaderboardAddLabel);

        this.repaint();
    }

}
