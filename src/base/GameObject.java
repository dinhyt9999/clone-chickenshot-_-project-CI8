package base;

import physic.BoxCollider;
import renderer.Renderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObject{
    public boolean isAlive;
    public Vector2D position;
    public Renderer renderer;
    public List<Attribute> attributes;

    public GameObject() {
        this.position = new Vector2D();
        this.attributes = new ArrayList<>();
        this.isAlive = true;
    }

    public void run() {
        this.attributes.forEach(attribute -> attribute.run(this));
    }
    public void render(Graphics graphics) {
        if (this.renderer != null)
            this.renderer.render(graphics, this.position);
    }
}
