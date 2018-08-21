package game.player;

import base.GameObject;
import base.Vector2D;
import game.enemy.enemybehind.EnemyBehind;
import game.enemy.meteor.Meteor;
import game.enemy.enemymatrix.EnemyMatrix;
import game.enemy.enemytravel.EnemyTravel;
import game.enemy.growupenemy.EnemyGrowUp;
import game.enemy.roundshootenemy.RoundShootEnemy;
import physic.BoxCollider;
import physic.HitPoints;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.OvalRenderer;

import java.awt.*;

public class BulletPlayer extends GameObject implements PhysicBody, HitPoints {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;
    public int force;
    public BulletPlayer() {
        this.force = 1;
        this.velocity = new Vector2D();
        this.renderer = new OvalRenderer(Color.RED,5,5);
        this.boxCollider = new BoxCollider(5,5);
        this.runHitObject = new RunHitObject(
                EnemyMatrix.class,
                EnemyTravel.class,
                RoundShootEnemy.class,
                EnemyGrowUp.class,
                Meteor.class,
                EnemyBehind.class
        );
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 2.5f,this.position.y - 2.5f);
        this.runHitObject.run(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive=false;
    }

    @Override
    public void getHitPoint(GameObject gameObject) {

    }
}