package game.enemy.enemytravel;

import base.GameObject;
import base.Vector2D;
import game.player.BulletPlayer;
import game.player.Player;
import physic.BoxCollider;
import physic.HitPoints;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.OvalRenderer;

import java.awt.*;

public class EnemyTravel extends GameObject implements PhysicBody, HitPoints {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;
    private int hitPoints;

    public EnemyTravel() {
        this.hitPoints = 3;
        this.velocity = new Vector2D(2.5f,2.5f);
        this.boxCollider = new BoxCollider(16,16);
        this.renderer = new OvalRenderer(Color.WHITE, 16, 16);
        this.attributes.add(new EnemyTravelShoot());
        this.runHitObject = new RunHitObject(Player.class);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
        this.boxCollider.position.set(this.position.x - 8,this.position.y - 8);
        this.runHitObject.run(this);
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
        this.getHitPoint(gameObject);
        if(this.hitPoints == 0)
            this.isAlive = false;
    }

    @Override
    public void getHitPoint(GameObject gameObject) {
        if(gameObject instanceof Player)
            this.hitPoints=0;
        if(gameObject instanceof BulletPlayer)
            this.hitPoints-=((BulletPlayer) gameObject).force;
    }
}
