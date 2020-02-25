package application;

public class Player extends Entity{
    //private boolean powerUP;
	private String name; //name chosen by the player
	private String ip;
    public Player(int entityID, String spriteID, String name,String ip ) {
		super(entityID, spriteID, 100, 0, 0);
    	this.name = name;
    	this.ip = ip;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
