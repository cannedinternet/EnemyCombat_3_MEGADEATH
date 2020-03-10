package application;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * client handling
 */
public class ClientHandler implements Runnable {
    final DataInputStream in;
    final DataOutputStream out;
    final Socket socket;

    public ClientHandler(DataInputStream dis, DataOutputStream dos, Socket s) {
        this.in = dis;
        this.out = dos;
        this.socket = s;
    }

    /**
     *
     */
    public void run() {
        try {
            int playersReady = 0;

            while (true) {
                out.writeUTF("you have connected to the server");
                Thread.sleep(5000);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void closeQuietly(Closeable c) {
        try {
            c.close();
        } catch (IOException ignored) {
        }
    }

}
class ready implements Runnable {
    final DataInputStream in;
    final DataOutputStream out;
    final Socket socket;
     public static int playersReady;

    public ready(DataInputStream dis, DataOutputStream dos, Socket s) {
        this.in = dis;
        this.out = dos;
        this.socket = s;
    }


    public void run() {
        int n = 0;
        try {
            while (true) {
                String line = in.readUTF();
                System.out.println("Received " + line);

                if (line != null)
                    n = Integer.parseInt(line);

                playersReady += n;
                if (playersReady == 4) {
                    break;
                }
                out.writeChars("players ready: " + playersReady);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


