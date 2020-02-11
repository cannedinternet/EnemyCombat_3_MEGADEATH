package application;
import java.io.*;
import java.net.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Server {
	//Socket
    private String ip;
    private InputStream in;
    private OutputStream out;
    private Socket socket;
    private ServerSocket serverSocket;

    //Map
    private int w,h,blockSize;
	private Pane map;

    private Player players1=null;
    private Player player2=null;
    
    private static int lastEntityID;

    public Server(String ip, Player players1, Player player2) {
        this.ip = ip;
        this.players1 = players1;
        this.player2 = player2;
        lastEntityID = 0;
    }


    public Server(String ip) {
        this.ip = ip;
        lastEntityID = 0;
    }

    public void setPlayers1(Player players1) {
        this.players1 = players1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public String getIp() {
        return ip;
    }

    public Player getPlayers1() {
        return players1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Socket getSocket() {
        return socket;
    }
    
    public static int generateEntityID() {
    	lastEntityID++;
    	return lastEntityID;
    }
    
    public void buildMap(String mapID) {
    	this.map = new Pane();
		Image mapImg = new Image(getClass().getResourceAsStream("/" + mapID + ".png"));
		this.w = (int) mapImg.getWidth();
		this.h = (int) mapImg.getHeight();
		for(int i = 0; i < h; i++)
			for(int j = 0; j < w; j++) {
				Integer pixel = mapImg.getPixelReader().getArgb(j, i);
				if(pixel != 0)
					addEntity(new Wall(generateEntityID(), Integer.toString(pixel), -1000, j*blockSize, i*blockSize));
			}
    }
    
    public void addEntity(Entity entity) {
		//find a way to do this
	}
}
