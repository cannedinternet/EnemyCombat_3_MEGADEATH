package application;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Shape;

public class Entity extends Shape{
    protected String sprintID, name; // object ID
    protected int xPosition,yPosition,speed;
    protected Image img;
    protected ImageView display;

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
    
    public boolean intersects(Bounds b) {
    	return this.getBoundsInLocal().contains(b);
    }

	@Override
	public com.sun.javafx.geom.Shape impl_configShape() {
		// TODO Auto-generated method stub
		return null;
	}
}
