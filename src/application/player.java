package application;

public class player extends Entity{
    private int health;
    //private boolean powerUP;

    //id player
    public player(int spritID, String name) {
        this.spritID = spritID;
        this.name = name;
    }

    public player(int sprintID, String name, int health, int xPosition, int yPosition) {
        this.spritID = sprintID;
        this.name = name;
        this.health = health;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
