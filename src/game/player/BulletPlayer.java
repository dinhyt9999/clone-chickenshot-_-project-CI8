package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.enemymatrix.EnemyMatrix;
import physic.BoxCollider;
import renderer.OvalRenderer;
import renderer.Renderer;

import java.awt.*;

public class BulletPlayer extends GameObject {
    public Vector2D velocity;
    private Renderer renderer;
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
        EnemyMatrix enemyMatrix = GameObjectManager.instance.checkCollision2(this);
        if(enemyMatrix != null){
            enemyMatrix.isAlive = false;
            this.isAlive = false;
        }
    }
}
