package game.enemy.roundshootenemy;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class CreateRoundShootEnemy extends GameObject {
    private Random random = new Random();
    private FrameCounter frameCounter = new FrameCounter(800);

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.checkCounter()) {
            RoundShootEnemy enemy = GameObjectManager.instance.recycle(RoundShootEnemy.class);
            enemy.position.set(random.nextInt(1024), random.nextInt(300));
            enemy.velocity.set(random.nextInt(2)+1, 0);
            this.frameCounter.resetCount();
        }
    }
}
