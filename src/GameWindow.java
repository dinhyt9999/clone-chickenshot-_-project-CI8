import input.KeyboardEvent;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
    private long lastTime = 0;
    private GameCanvas gameCanvas;

    public GameWindow() {
        this.setSize(1024, 600);
        setupGameCanvas();
        event();
        this.setVisible(true);
    }

    private void setupGameCanvas() {
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }

    private void keyboardEvent() {
        this.addKeyListener(KeyboardEvent.instance);
    }

    private void mouseEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(60);
            }
        });
    }

    private void event() {
        this.mouseEvent();
        this.keyboardEvent();
    }

    public void gameLoop() {
        while (this.gameCanvas.player.isAlive) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                lastTime = currentTime;
            }
        }
    }
}