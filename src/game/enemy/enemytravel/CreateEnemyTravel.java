package game.enemy.enemytravel;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;

import java.util.Random;

public class CreateEnemyTravel extends GameObject {
    private int i;
    private Random random = new Random();
    private Vector2D tempPosition = new Vector2D().set(random.nextInt(2)*600,random.nextInt(100));
    private Vector2D tempVelocity = new Vector2D();
    private FrameCounter frameCounter = new FrameCounter(400);

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.checkCounter()) {
            if(this.tempPosition.x == 600){
                this.tempVelocity.set(-5f,2.5f);
            }else{
                this.tempVelocity.set(5f,2.5f);
            }
            for (i = 0; i <= 9; i++) {
                EnemyTravel enemyTravel = GameObjectManager.instance.recycle(EnemyTravel.class);
                enemyTravel.position.set(this.tempPosition.x - this.tempVelocity.x*i*10,this.tempPosition.y - this.tempVelocity.y*i*10);
                enemyTravel.velocity.set(this.tempVelocity);
            }
            this.frameCounter.resetCount();
        }
    }
}