package game.enemy;

import base.FrameCounter;
import base.GameObjectManager;
import game.enemy.BulletEnemy;
import game.enemy.enemymatrix.EnemyMatrix;

import java.util.ArrayList;
import java.util.List;

public class EnemyAttack implements EnemyShoot {
    private FrameCounter frameCounter = new FrameCounter();
    private int angle;
    private int i;

    @Override
    public void run(EnemyMatrix enemyMatrix) {
        if (this.frameCounter.compare(160)) {
            for (this.i = 1; this.i <= 10; this.i++) {
                angle += 36;
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(enemyMatrix.position);
                bulletEnemy.velocity.set(0,1.5f);
                GameObjectManager.instance.add(bulletEnemy);
            }
        }
        this.frameCounter.run();
    }
}

