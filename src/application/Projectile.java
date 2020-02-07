package application;

public class Projectile extends Entity {
    private int damage;
    private Type type;

    public Projectile(int entityID, String spriteID, int health, int xPosition, int yPosition, int damage, Type type) {
		super(entityID, spriteID, health, xPosition, yPosition);
        this.damage = damage;
        this.type = type;
        this.spriteID = spriteID;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
