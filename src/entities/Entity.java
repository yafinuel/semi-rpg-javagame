package entities;

// Mulai dari Eps 7
public abstract class Entity {

    protected float x,y;
    protected int maxHealth;
    protected int currentHealth;

    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }

}
