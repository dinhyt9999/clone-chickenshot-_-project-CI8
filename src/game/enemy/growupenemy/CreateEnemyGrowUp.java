package game.enemy.growupenemy;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class CreateEnemyGrowUp extends GameObject {

    private Random random = new Random();
    private FrameCounter frameCounter = new FrameCounter(500);

    public void run(){
        super.run();
        if (this.frameCounter.checkCounter()) {
            EnemyGrowUp enemyGrowUp = new EnemyGrowUp();
            enemyGrowUp.position.set(this.random.nextInt(1024), 0);
            enemyGrowUp.velocity.set(this.random.nextInt(3) + 1, this.random.nextInt(3) + 1);
            GameObjectManager.instance.add(enemyGrowUp);
            this.frameCounter.resetCount();
        }

    }

}
