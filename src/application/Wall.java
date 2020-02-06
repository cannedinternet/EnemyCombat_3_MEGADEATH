package application;

public class Wall extends Entity{ //Probably can be removed entirely and just have walls be generic entities
	
	public Wall(int entityID, String spriteID, int health, int xPosition, int yPosition) {
		super(entityID, spriteID, health, xPosition, yPosition);
	}

}
