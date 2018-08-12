package game.enemy.enemymatrix;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import renderer.OvalRenderer;

import java.awt.*;

public class EnemyMatrix extends GameObject {
    public Vector2D velocity;
    private Vector2D temp;

    public EnemyMatrix() {
        this.velocity = new Vector2D(2.5f,0);
        this.boxCollider = new BoxCollider(16,16);
        this.renderer = new OvalRenderer(Color.WHITE, 16, 16);
        this.temp = new Vector2D(this.position.x,this.position.y);
        this.attributes.add(new EnemyMatrixShoot());
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
        this.boxCollider.position.set(this.position.x - 8,this.position.y - 8);
        this.updateVelocity();
    }
    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
    }
    public void updateVelocity() {
        if (Math.abs(this.position.x - this.temp.x) >= 575){
            this.velocity.set(0,2.5f);
            this.temp.set(this.position);
        }
        if (this.position.y - this.temp.y>=100)
        if (this.position.x>=500){
            this.velocity.set(-2.5f, 0);
            this.temp.set(this.position);
        }else{
            this.velocity.set(2.5f,0);
            this.temp.set(this.position);
        }
        if (this.position.y>1025){
            this.isAlive = false;
        }
    }
}

