package entities;
import java.awt.image.BufferedImage;

// Mulai dari Eps 7
public class Player extends Entity {
    private BufferedImage[][] animations;
    public Player(float x, float y) {
        super(x, y);
        this.maxHealth = 100;
        this.currentHealth = maxHealth;
    }

    private void updateHealth(){

    }

    public void update() {

    }

    public void render() {

    }


}
