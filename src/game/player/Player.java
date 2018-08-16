package game.player;

import base.GameObject;
import base.Vector2D;
import game.enemy.BulletEnemy;
import game.enemy.enemymatrix.EnemyMatrix;
import game.enemy.enemytravel.EnemyTravel;
import physic.BoxCollider;
import physic.HitPoints;
import physic.PhysicBody;
import renderer.ImageRenderer;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject implements PhysicBody, HitPoints {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    public int angle;
    private int hitPoints;

    public Player() {
        this.hitPoints = 20;
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(16, 20);
        this.renderer = new PolygonRenderer(Color.RED,
                new Vector2D(8,0),
                new Vector2D(0, 20),
                new Vector2D(16, 20));
   //     this.renderer=new ImageRenderer("image/NV 2.jpg",16,16);
        this.attributes.add(new PlayerShoot());
        this.attributes.add(new PlayerMove());
    }
    @Override
    public void run(){
        super.run();
        ((PolygonRenderer) this.renderer).angle = this.angle;
        this.boxCollider.position.set(this.position.x - 10, this.position.y -8);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        getHitPoint(gameObject);
        if(this.hitPoints <=0)
            this.isAlive = false;
    }

    @Override
    public void getHitPoint(GameObject gameObject) {
        if(gameObject instanceof EnemyMatrix)
            this.hitPoints-=3;
        if(gameObject instanceof EnemyTravel)
            this.hitPoints-=3;
        if(gameObject instanceof BulletEnemy)
            this.hitPoints--;
    }
}
