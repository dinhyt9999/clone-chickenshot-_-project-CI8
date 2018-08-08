package game.enemy.enemymatrix;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

public class CreatEnemyMatrix extends GameObject {
    private int i;
    private FrameCounter frameCounter = new FrameCounter();
    @Override
    public void run() {
        super.run();
        if (this.frameCounter.compare(3000)) {
            for(i=0;i<=15;i++) {
                EnemyMatrix enemyMatrix = new EnemyMatrix();
                enemyMatrix.position.set((i%4)*25,(i/4)*25);
                GameObjectManager.instance.add(enemyMatrix);
            }
        }
        this.frameCounter.run();
    }
}
