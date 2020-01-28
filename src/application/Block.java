package application;

public class Block extends Entity{
	private boolean solid;
	
	public Block() {
		
	}

	public boolean isSolid() {
		return solid;
	}

	public void setSolid(boolean solid) {
		this.solid = solid;
	}
}
