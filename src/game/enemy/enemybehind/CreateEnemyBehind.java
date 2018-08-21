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
                EnemyBehind enemyBehind1 = new EnemyBehind();
                enemyBehind1.position.set(this.positionLeft.x, this.positionLeft.y+i*30);
                enemyBehind1.velocity.set(0, -5);
                GameObjectManager.instance.add(enemyBehind1);

                EnemyBehind enemyBehind2 = new EnemyBehind();
                enemyBehind2.position.set(this.positionLeft.x + 40, this.positionLeft.y+i*30);
                enemyBehind2.velocity.set(0, -5);
                enemyBehind2.upDown = 0;
                GameObjectManager.instance.add(enemyBehind2);

                EnemyBehind enemyBehind3 = new EnemyBehind();
                enemyBehind3.position.set(this.positionRight.x - 40, this.positionRight.y+i*30);
                enemyBehind3.velocity.set(0, -5);
                enemyBehind3.upDown = 0;
                enemyBehind3.leftRight = 0;
                GameObjectManager.instance.add(enemyBehind3);

                EnemyBehind enemyBehind4 = new EnemyBehind();
                enemyBehind4.position.set(this.positionRight.x, this.positionRight.y+i*30);
                enemyBehind4.velocity.set(0, -5);
                enemyBehind4.leftRight = 0;
                GameObjectManager.instance.add(enemyBehind4);
            }
            this.frameCounter.resetCount();
        }
    }
}
