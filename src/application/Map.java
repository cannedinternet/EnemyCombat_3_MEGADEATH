package application;

import javafx.scene.image.Image;

public class Map {
	private int w,h;
	public Map(String mapID) {
		
	}
	public void create(String mapID) {
		Image mapImg = crSp(mapID);
		for(int i = 0; i < h; i++)
			for(int j = 0; j < w; j++) {
				Integer pixel = mapImg.getPixelReader().getArgb(j, i);
			}
	}
	public Image crSp(String file) {return new Image(getClass().getResourceAsStream("/" + file + ".png"));}
}
