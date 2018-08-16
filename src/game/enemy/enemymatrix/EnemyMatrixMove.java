package game.enemy.enemymatrix;

import base.Attribute;
import base.Vector2D;

public class EnemyMatrixMove implements Attribute<EnemyMatrix> {

    @Override
    public void run(EnemyMatrix gameObject) {
        if (Math.abs(gameObject.position.x - gameObject.temp.x) >= 1000) {
            gameObject.velocity.set(0, 2.5f);
            gameObject.temp.set(gameObject.position);
        }
        if (gameObject.position.y - gameObject.temp.y >= 100){
            if (gameObject.position.x >= 500) {
                gameObject.velocity.set(-2.5f, 0);
                gameObject.temp.set(gameObject.position);
            } else {
                gameObject.velocity.set(2.5f, 0);
                gameObject.temp.set(gameObject.position);
            }
        }
        if (gameObject.position.y > 610) {
            gameObject.isAlive = false;
        }
    }
}
