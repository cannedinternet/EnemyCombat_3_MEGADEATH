package application;

public class Wall extends Entity{
	
	public Wall(int entityID, String spriteID, int health, int xPosition, int yPosition) {
		this.spriteID = spriteID;
		this.health = health;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

}
