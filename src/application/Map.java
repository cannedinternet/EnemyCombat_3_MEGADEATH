package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class Map {
	private int w,h;
	private Canvas map;
	private int blockSize;
	public Map(String mapID) {
		this.map = new Canvas();
		Image mapImg = crSp(mapID);
		this.w = (int) mapImg.getWidth();
		this.h = (int) mapImg.getHeight();
		for(int i = 0; i < h; i++)
			for(int j = 0; j < w; j++) {
				Integer pixel = mapImg.getPixelReader().getArgb(j, i);
				if(pixel != 0)
					addWall(new Wall(), j, i);
			}
	}
	public void addWall(Wall wall, int xPos, int yPos) {
		
	}
}
