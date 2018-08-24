package game.enemy.enemybehind;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;

public class CreateEnemyBehind extends GameObject {

    private Vector2D positionLeft = new Vector2D(200 ,600);
    private Vector2D positionRight = new Vector2D(800,600);
    private FrameCounter frameCounter = new FrameCounter(300);

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.checkCounter()) {
            for (int i=0; i<9; i++) {
                EnemyBehind enemyBehindLeft1 = GameObjectManager.instance.recycle(EnemyBehind.class);
                enemyBehindLeft1.position.set(this.positionLeft.x, this.positionLeft.y+i*30);
                enemyBehindLeft1.velocity.set(0, -5);

                EnemyBehind enemyBehindLeft2 = GameObjectManager.instance.recycle(EnemyBehind.class);
                enemyBehindLeft2.position.set(this.positionLeft.x + 40, this.positionLeft.y+i*30);
                enemyBehindLeft2.velocity.set(0, -5);
                enemyBehindLeft2.upDown = 0;

                EnemyBehind enemyBehindRight1 = GameObjectManager.instance.recycle(EnemyBehind.class);
                enemyBehindRight1.position.set(this.positionRight.x - 40, this.positionRight.y+i*30);
                enemyBehindRight1.velocity.set(0, -5);
                enemyBehindRight1.upDown = 0;
                enemyBehindRight1.leftRight = 0;

                EnemyBehind enemyBehindRight2 = GameObjectManager.instance.recycle(EnemyBehind.class);
                enemyBehindRight2.position.set(this.positionRight.x, this.positionRight.y+i*30);
                enemyBehindRight2.velocity.set(0, -5);
                enemyBehindRight2.leftRight = 0;
            }
            this.frameCounter.resetCount();
        }
    }
}
