package game.enemy.growupenemy;

import base.Attribute;
import base.FrameCounter;

import java.util.Random;

public class EnemyGrowUpGrow implements Attribute<EnemyGrowUp> {
    private Random random = new Random();
    private FrameCounter frameCounter = new FrameCounter(50 + random.nextInt(150));
    @Override
    public void run(EnemyGrowUp enemyGrowUp) {
        if (this.frameCounter.checkCounter()) {
            enemyGrowUp.width+=20;
            enemyGrowUp.height+=20;
            enemyGrowUp.boxCollider.set(enemyGrowUp.width,enemyGrowUp.height);
            this.frameCounter.resetCount();
        }
    }
}
