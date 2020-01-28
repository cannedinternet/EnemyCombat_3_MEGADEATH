package application;

public class player extends Entity{
    private int health;
    //private boolean powerUP;


    public player(String sprintID, String name) {
        this.sprintID = sprintID;
        this.name = name;
    }

    public player(String sprintID, String name, int health, int xPosition, int yPosition) {
        this.sprintID = sprintID;
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
