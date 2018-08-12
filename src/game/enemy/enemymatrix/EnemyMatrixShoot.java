package game.enemy.enemymatrix;

import base.Attribute;
import base.FrameCounter;
import base.GameObjectManager;
import game.enemy.BulletEnemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyMatrixShoot implements Attribute<EnemyMatrix> {
    private FrameCounter frameCounter = new FrameCounter();
    private Random random = new Random();

    @Override
    public void run(EnemyMatrix enemyMatrix) {
        if (this.frameCounter.compare(160 + random.nextInt(150))) {
            BulletEnemy bulletEnemy = new BulletEnemy();
            bulletEnemy.position.set(enemyMatrix.position);
            bulletEnemy.velocity.set(0, random.nextInt(2)+1);
            GameObjectManager.instance.add(bulletEnemy);
        }
        this.frameCounter.run();
    }
}

