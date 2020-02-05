package application;

public class Player extends Entity{
    //private boolean powerUP;
	private String name; //name chosen by the player
    //id player
    public Player(String spriteID, String name) {
        this.spriteID = spriteID;
        this.name = name;
    }

    public Player(String spriteID, String name, int health, int xPosition, int yPosition) {
        this.spriteID = spriteID;
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
