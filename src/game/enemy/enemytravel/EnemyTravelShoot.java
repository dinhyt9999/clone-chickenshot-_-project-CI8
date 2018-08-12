package game.enemy.enemytravel;

import base.Attribute;
import base.FrameCounter;
import base.GameObjectManager;
import game.enemy.BulletEnemy;

import java.util.Random;

public class EnemyTravelShoot implements Attribute<EnemyTravel>{
    private FrameCounter frameCounter = new FrameCounter();
    private Random random = new Random();

    @Override
    public void run(EnemyTravel enemyTravel) {
        if (this.frameCounter.compare(50 + random.nextInt(150))) {
            BulletEnemy bulletEnemy = new BulletEnemy();
            bulletEnemy.position.set(enemyTravel.position);
            bulletEnemy.velocity.set(0, random.nextInt(3)+1);
            GameObjectManager.instance.add(bulletEnemy);
        }
        this.frameCounter.run();
    }
}
