package game.enemy.enemymatrix;

import base.Attribute;
import base.Vector2D;

public class EnemyMatrixMove implements Attribute<EnemyMatrix> {
    public Vector2D temp = new Vector2D();
    @Override
    public void run(EnemyMatrix gameObject) {
//        if (Math.abs(gameObject.position.x - this.temp.x) >= 1000) {
//            gameObject.velocity.set(0, 2.5f);
//            this.temp.set(gameObject.position);
//            //System.out.println(this.temp.x - gameObject.position.x + " " + this.temp.y + " " + gameObject.position.y);
//        }
//        if (gameObject.position.y - this.temp.y >= 100){
//            if (gameObject.position.x >= 500) {
//                gameObject.velocity.set(-2.5f, 0);
//                this.temp.set(gameObject.position);
//            } else {
//                gameObject.velocity.set(2.5f, 0);
//                this.temp.set(gameObject.position);
//            }
//        }
//        if (gameObject.position.y > 610) {
//            gameObject.isAlive = false;
//        }
    }
}
