package application;
import java.io.*;
import java.net.*;

public class Server {
    private String ip;
    private InputStream in;
    private OutputStream out;
    private Socket socket;
    private ServerSocket serverSocket;


    private Player players1=null;
    private Player player2=null;

    public Server(String ip, Player players1, Player player2) {
        this.ip = ip;
        this.players1 = players1;
        this.player2 = player2;
    }


    public Server(String ip) {
        this.ip = ip;

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
}
