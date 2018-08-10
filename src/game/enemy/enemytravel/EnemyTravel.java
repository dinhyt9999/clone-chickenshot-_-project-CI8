package game.enemy.enemytravel;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import renderer.OvalRenderer;

import java.awt.*;

public class EnemyTravel extends GameObject {
    public Vector2D velocity;
    //  private EnemyShoot enemyShoot;

    public EnemyTravel() {
        this.velocity = new Vector2D(2.5f,2.5f);
        this.boxCollider = new BoxCollider(16,16);
        this.renderer = new OvalRenderer(Color.WHITE, 16, 16);
        //    this.enemyShoot = new EnemyAttack();
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
        this.boxCollider.position.set(this.position.x - 8,this.position.y - 8);
        //  this.enemyShoot.run(this);
    }
    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        //  ((EnemyAttack) this.enemyShoot).bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }
}
