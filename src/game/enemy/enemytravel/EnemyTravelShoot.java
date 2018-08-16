package game.enemy.enemytravel;

import base.Attribute;
import base.FrameCounter;
import base.GameObjectManager;
import game.enemy.BulletEnemy;

import java.util.Random;

public class EnemyTravelShoot implements Attribute<EnemyTravel>{
    private Random random = new Random();
    private FrameCounter frameCounter = new FrameCounter(50 + random.nextInt(150));

    @Override
    public void run(EnemyTravel enemyTravel) {
        if (this.frameCounter.checkCounter()) {
            BulletEnemy bulletEnemy = new BulletEnemy();
            bulletEnemy.position.set(enemyTravel.position);
            bulletEnemy.velocity.set(0, random.nextInt(3)+1);
            GameObjectManager.instance.add(bulletEnemy);
            this.frameCounter.resetCount();
        }
    }
}
