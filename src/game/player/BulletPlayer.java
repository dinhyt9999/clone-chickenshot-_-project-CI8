package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.enemymatrix.EnemyMatrix;
import game.enemy.enemytravel.EnemyTravel;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.OvalRenderer;

import java.awt.*;

public class BulletPlayer extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    public BulletPlayer() {
        this.velocity = new Vector2D();
        this.renderer = new OvalRenderer(Color.RED,5,5);
        this.boxCollider = new BoxCollider(5,5);
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 2.5f,this.position.y - 2.5f);
        EnemyMatrix enemyMatrix = GameObjectManager.instance.checkCollision(this.boxCollider, EnemyMatrix.class);
        if (enemyMatrix != null) {
            this.getHit(enemyMatrix);
            enemyMatrix.getHit(this);
        }
        EnemyTravel enemyTravel = GameObjectManager.instance.checkCollision(this.boxCollider, EnemyTravel.class);
        if(enemyTravel != null){
            this.getHit(enemyTravel);
            enemyTravel.getHit(this);
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive=false;
    }

}