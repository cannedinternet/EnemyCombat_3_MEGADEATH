package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import static application.Server.generateEntityID;


public class Client extends Application {
    private static Server server;
    private static InetAddress ipAddress;
    private static Socket socket;

    @Override
    public void start(Stage primaryStage) {
        try {
            ipAddress = InetAddress.getLocalHost();
            String ip = ipAddress.getHostAddress().trim();
            System.out.println(ip);
            System.out.println(ipAddress.getHostName());
            socket = null;
            server = null;
            //starting menu

            Button p1 = new Button("1 player");
            Button p2 = new Button("2 players");
            Button online = new Button("Online");

            p2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    server = new Server("Local Host", new Player(generateEntityID(), "Player 1", "player 1"),
                            new Player(generateEntityID(), "Player 2","player 2"));

                }

            });
//            p1.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//
//                    player player1 = new player(1, "player 1");
//                }
//            });
            p1.setOnAction((ActionEvent e) -> {
                server = new Server("Local Host", new Player(generateEntityID(), "Player 1","player 1"), null);


            });

            online.setOnAction((ActionEvent e) -> {
            setServer();
            });
            Button quit = new Button("quit");

            quit.setOnAction((ActionEvent e)->{
                primaryStage.close();

            });
            HBox hList = new HBox();
            VBox vBox = new VBox();
            //hList.setSpacing(325);
            hList.getChildren().addAll(p1, p2, online);
            Group root = new Group();
            vBox.getChildren().addAll(hList,quit);
            vBox.setPadding(new Insets(100));
            root.getChildren().add(vBox);
            Scene scene = new Scene(root, 400, 400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            //primaryStage.setFullScreen(true);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Image createSprite(String spriteID) {
        return new Image(getClass().getResourceAsStream("/" + spriteID + ".png"));
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void lookForServer(int i)
    {
        try {
            socket = new Socket(ipAddress, 4444);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println(in.readUTF());
        }
        catch (IOException e)
        {
            if(i<30) {
                i++;
                System.out.println("try "+ i);
                lookForServer(i);

            }
            else
                e.printStackTrace();
        }


    }

    public static void setServer()
    {
        Server.serverStart();
        lookForServer(0);
    }
}
