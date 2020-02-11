package application;

public class Player extends Entity{
    //private boolean powerUP;
	private String name; //name chosen by the player
	
    public Player(int entityID, String spriteID, String name ) {
		super(entityID, spriteID, 100, 0, 0);
    	this.name = name;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
}
