package game.background;

import base.GameObject;
import renderer.ImageRenderer;
import renderer.RectRenderer;

import java.awt.*;

public class Background extends GameObject {
    public Background() {
        //this.renderer = new ImageRenderer("image/BG.png", 1024, 600);
        this.renderer = new RectRenderer(Color.BLACK,1024,600);
    }
}
