package application;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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

    public void run() {
        try {
            int playersReady = 0;
            out.writeUTF("you have connected to the server");
            while (true) {
                Thread.sleep(5000);
//                if (in.readInt() == 1) {
//                    playersReady++;
//                    System.out.println(playersReady);
////                    out.writeUTF("players connected: "+playersReady);
//                }
                out.writeUTF("players connected: " + playersReady);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeQuietly(this.in);
            closeQuietly(this.out);
            closeQuietly(this.socket);
        }
    }

    void closeQuietly(Closeable c) {
        try {
            c.close();
        } catch (IOException ignored) {
        }
    }

}
