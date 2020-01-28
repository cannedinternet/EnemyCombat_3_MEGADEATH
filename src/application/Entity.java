package application;

public class Entity {
    protected String name; // object ID
    protected int xPosition,yPosition,speed,spritID;

    public int getSprintID() {
        return spritID;
    }

    public int getXPosition() {
        return xPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setSprintID(int sprintID) {
        this.spritID = sprintID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
