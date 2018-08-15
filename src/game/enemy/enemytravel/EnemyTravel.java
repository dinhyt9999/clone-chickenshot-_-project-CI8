package game.enemy.enemytravel;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.OvalRenderer;

import java.awt.*;

public class EnemyTravel extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider;

    public EnemyTravel() {
        this.velocity = new Vector2D(2.5f,2.5f);
        this.boxCollider = new BoxCollider(16,16);
        this.renderer = new OvalRenderer(Color.WHITE, 16, 16);
        this.attributes.add(new EnemyTravelShoot());
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
        this.boxCollider.position.set(this.position.x - 8,this.position.y - 8);
        Player player = GameObjectManager.instance.checkCollision(this.boxCollider,Player.class);
        if(player != null){
            this.getHit(player);
            player.getHit(this);
        }
    }
    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
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
