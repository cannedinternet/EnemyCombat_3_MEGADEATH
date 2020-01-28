package application;

public class Entity {
    protected String sprintID, name; // object ID
    protected int xPosition,yPosition,speed;

    public String getSprintID() {
        return sprintID;
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

    public void setSprintID(String sprintID) {
        this.sprintID = sprintID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
