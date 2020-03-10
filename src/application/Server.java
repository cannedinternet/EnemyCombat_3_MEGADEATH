package application;

import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class Server extends Application{
    //Socket
    private String ip;
    private Socket socket;
    private ServerSocket serverSocket;

    //Map
    private int w, h;
    private Pane map;
    private final int blockSize = 60;

    private HashMap<Integer, Entity> entityMap = new HashMap<Integer, Entity>();
    //player
    private Player players1 = null;
    private Player player2 = null;

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

    public static Integer generateEntityID() {
        lastEntityID++;
        return lastEntityID;
    }

    public void buildMap(String mapID) {
        this.map = new Pane();
        Image mapImg = new Image(getClass().getResourceAsStream("/" + mapID + ".png"));
        this.w = (int) mapImg.getWidth();
        this.h = (int) mapImg.getHeight();
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++) {
                Integer pixel = mapImg.getPixelReader().getArgb(j, i);
                if (pixel != 0)
                    addEntity(new Wall(generateEntityID(), Integer.toString(pixel), -1000, j * blockSize, i * blockSize));
            }
    }

    public void addEntity(Entity entity) {
        this.map.getChildren().add(entity);
        entity.setLayoutX(entity.getXPosition());
        entity.setLayoutY(entity.getYPosition());
        entityMap.put(entity.getEntityID(), entity);
    }

    public Image createSprite(String spriteID) {
        return new Image(getClass().getResourceAsStream("/" + spriteID + ".png"));
    }

    public void gameLoop(Stage game, String mapID) {
    	System.out.println("gl");
    	buildMap(mapID);
    	
    	AnimationTimer loop = new AnimationTimer() {
    		private long lastUpdate ;
    	    private double speed = 50 ; // pixels per second -- generic right now should be changed

    	    @Override
    	    public void start() {
    	        lastUpdate = System.nanoTime();
    	        super.start();
    	    }

    	    @Override
    	    public void handle(long now) {
    	        long elapsedNanoSeconds = now - lastUpdate ;
    	        double elapsedSeconds = elapsedNanoSeconds / 1_000_000_000.0 ; // needs to be looked into - used for handling inconsistencies between frame timings
    		
    	        
    	        
    	        lastUpdate = now;
    	    }
    	};
    	
    	Scene scene = new Scene(map, 1920, 1080);
    	game.setScene(scene);
    	game.show();
		loop.start();
    }

    public static void serverStart() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444, 5, InetAddress.getByAddress(new byte[4]));
            //noinspection InfiniteLoopStatement
            System.out.println("Starting server on " + serverSocket.getLocalSocketAddress());
            Socket socket = null;
//            int playersReady = 0;
            while (true) {
                try {                	
                    socket = serverSocket.accept();
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    String name = "client-" + socket.getRemoteSocketAddress().toString();
                    System.out.println(name);
                    Thread clientThread = new Thread(new ClientHandler(in, out, socket), name);
                    clientThread.start();
//                    if(in.readInt() == 1)
//                    {
//                        playersReady++;
//                        System.out.println(playersReady);
//                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(serverSocket);
        }

    }


    static void closeQuietly(Closeable c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (IOException ignored) {
        }
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
    	System.out.print("SKIP SERVER LAUNCH? (Y/N)   ");
	    primaryStage.setTitle("My First JavaFX App");
	
	    primaryStage.show();
	}

    public static void main(String[] args) {
    	System.out.print("SKIP SERVER LAUNCH? (Y/N)   ");
    	Scanner s = new Scanner(System.in);
    	if(s.next().equals("Y"))
    		Game.m(args);
    	else
    		serverStart();
    }
}