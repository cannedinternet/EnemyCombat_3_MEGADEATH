package application;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Shape;

public class Entity extends Shape{
    protected String spriteID; // image ID
    protected int xPosition,yPosition,speed,health,entityID;
    protected Image img;
    protected ImageView display;
    
    public Entity(int entityID, String spriteID, int health, int xPosition, int yPositon) { //all entities need to be constructed with these
    	this.spriteID = spriteID;
    	this.health = health;
    	    	
    	this.img = generateSprite(spriteID);
    	this.display = new ImageView(img);
    }

    public int getEntityID() {
    	return entityID;
    }
    
    public void setEntityID(int entityID) {
    	this.entityID = entityID;
    }
    
    public int getHealth() {
    	return health;
    }
    
    public void setHealth(int health) {
    	this.health = health;
    }
    
    public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public ImageView getDisplay() {
		return display;
	}

	public void setDisplay(ImageView display) {
		this.display = display;
	}

	public String getspriteID() {
        return spriteID;
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

    public void setspriteID(String spriteID) {
        this.spriteID = spriteID;
    }
    
    public boolean intersects(Bounds b) {
    	return this.getBoundsInLocal().contains(b);
    }

	public Image generateSprite(String file) {
		return new Image(getClass().getResourceAsStream("/" + file + ".png"));
	}
    
	@Override
	public com.sun.javafx.geom.Shape impl_configShape() {
		// TODO Auto-generated method stub
		return null;
	}
}
