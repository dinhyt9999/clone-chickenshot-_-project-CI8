package game.enemy.Meteor;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class CreateMeteor extends GameObject {

    private Random random = new Random();
    private FrameCounter frameCounter = new FrameCounter(1500);

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.checkCounter()) {
            Meteor meteor = new Meteor();
            meteor.position.set(random.nextInt(1024), 0);
            meteor.velocity.set(0,random.nextInt(2) + 2);
            System.out.println(meteor.velocity.x + " , " + meteor.velocity.y);
            GameObjectManager.instance.add(meteor);
            this.frameCounter.resetCount();
        }
    }
}
