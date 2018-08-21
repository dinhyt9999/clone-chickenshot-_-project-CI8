import base.GameObjectManager;
import game.background.Background;
import game.enemy.enemymatrix.CreatEnemyMatrix;
import game.enemy.enemytravel.CreatEnemyTravel;
import game.enemy.growupenemy.CreateEnemyGrowUp;
import game.enemy.roundshootenemy.CreateRoundShootEnemy;
import game.enemy.Meteor.CreateMeteor;
import game.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    public Player player;
    private BufferedImage backBuffered;
    private Graphics graphics;

    private void setupPlayer() {
        this.player = new Player();
        this.player.position.set(200, 300);
        GameObjectManager.instance.add(player);
    }

    public void runAll() {
        GameObjectManager.instance.runAll();
    }

    public GameCanvas() {
        this.setSize(1024, 600);
        setupBackBuffered();
        setupCharacter();
        this.setVisible(true);
    }

    private void setupCharacter() {
        GameObjectManager.instance.add(new Background());
        setupPlayer();
        GameObjectManager.instance.add(new CreatEnemyMatrix());
        GameObjectManager.instance.add(new CreatEnemyTravel());
        GameObjectManager.instance.add(new CreateEnemyGrowUp());
        GameObjectManager.instance.add(new CreateRoundShootEnemy());
        GameObjectManager.instance.add(new CreateMeteor());
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(graphics);
        this.repaint();
    }
}
