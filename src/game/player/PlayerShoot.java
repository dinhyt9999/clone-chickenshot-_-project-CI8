package game.player;

import base.Attribute;
import base.GameObjectManager;
import input.KeyboardEvent;

public class PlayerShoot implements Attribute<Player> {

    @Override
    public void run(Player gameObject) {
        if (KeyboardEvent.instance.isSpace) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(gameObject.position);
            bulletPlayer.velocity.set(0,-4.5f);
            GameObjectManager.instance.add(bulletPlayer);
        }
    }
}
