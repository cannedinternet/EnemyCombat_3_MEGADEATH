package application;

public class Player extends Entity{
    //private boolean powerUP;
	private String name; //name chosen by the player
	
    public Player(int entityID, String spriteID, int health, String name, int xPosition, int yPosition) {
		super(entityID, spriteID, health, xPosition, yPosition);
    	this.name = name;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
}
