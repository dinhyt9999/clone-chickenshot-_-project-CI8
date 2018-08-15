package game.enemy.enemytravel;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;

import java.util.Random;

public class CreatEnemyTravel extends GameObject {
    private int i;
    private Random random = new Random();
//    private Vector2D tempPosition = new Vector2D();
    private Vector2D tempPosition = new Vector2D().set(random.nextInt(2)*600,random.nextInt(100));
    private Vector2D tempVelocity = new Vector2D();
    private FrameCounter frameCounter = new FrameCounter();

    @Override
    public void run() {
        // Initialise value của tempPos vs tempVel trên Attribute luôn không cần phải tạo riêng 1 con enemyTravel đi đàu nữa
        super.run();
        if (this.frameCounter.compare(400)) {
            if(this.tempPosition.x == 600){
                this.tempVelocity.set(-5f,2.5f);
            }else{
                this.tempVelocity.set(5f,2.5f);
            }
            for (i = 0; i <= 9; i++) {
                EnemyTravel enemyTravel = new EnemyTravel();
                enemyTravel.position.set(this.tempPosition.x - this.tempVelocity.x*i*10,this.tempPosition.y - this.tempVelocity.y*i*10);
                enemyTravel.velocity.set(this.tempVelocity);
                GameObjectManager.instance.add(enemyTravel);
            }
        }
        this.frameCounter.run();
    }
}