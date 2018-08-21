package game.enemy.growupenemy;

import base.GameObject;
import base.Vector2D;
import game.enemy.enemytravel.EnemyTravelShoot;
import game.player.BulletPlayer;
import game.player.Player;
import physic.BoxCollider;
import physic.HitPoints;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.OvalRenderer;

import java.awt.*;
import java.util.Random;

public class EnemyGrowUp extends GameObject implements PhysicBody, HitPoints {
    public BoxCollider boxCollider;
    public Vector2D velocity;
    private RunHitObject runHitObject;
    private int hitPoints;
    public int width;
    public int height;
    public EnemyGrowUp() {
            Random random=new Random();
            this.hitPoints = 3;
            this.velocity = new Vector2D(random.nextInt(8),random.nextInt(8));
            this.boxCollider = new BoxCollider(16,16);
            this.renderer = new OvalRenderer(Color.WHITE, 10, 10);
            this.height=16;
            this.width=16;
            this.attributes.add(new EnemyGrowUpGrow());
            this.runHitObject = new RunHitObject(Player.class);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
        this.reflexScreen();
        this.boxCollider.position.set(this.position.x - 8,this.position.y - 8);
        this.runHitObject.run(this);
    }

    private void reflexScreen(){
        if(this.position.y<0||this.position.y>590){
            this.velocity.y=-this.velocity.y;
        }
        if(this.position.x<0||this.position.x>1001){
            this.velocity.x=-this.velocity.x;
        }
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        this.renderer=new OvalRenderer(Color.white,this.width,this.height);
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
