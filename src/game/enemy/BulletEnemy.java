package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;
import renderer.OvalRenderer;

import java.awt.*;

public class BulletEnemy extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    public BulletEnemy() {
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(5,5);
        this.renderer = new OvalRenderer(Color.WHITE,5,5);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x -2.5f,this.position.y-2.5f);
        Player player = GameObjectManager.instance.checkCollision(this.boxCollider, Player.class);
        if(player != null){
            this.getHit(player);
            player.getHit(this);
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }
}