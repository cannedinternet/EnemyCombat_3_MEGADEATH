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
import javafx.scene.text.Text;
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
    private static DataOutputStream out;
    private static DataInputStream in;

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
                    //server = new Server("Local Host", new Player(generateEntityID(), "Player 1", "player 1"),
                    // new Player(generateEntityID(), "Player 2","player 2"));
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
                //server = new Server("Local Host", new Player(generateEntityID(), "Player 1","player 1"), null);
            });

            online.setOnAction((ActionEvent e) -> {
                settingOnline(primaryStage);
//            setServer();
//                socket = lookForServer();
//                if (socket == null) {
//                    //TODO: let user know
//
//                    Button back =  new Button("Back");
//                    Button again = new Button("Try again");
//                    back.setOnAction((ActionEvent e)->{
//                        start(primaryStage);
//                    });
//                    again.setOnAction((ActionEvent e)->
//                    {
//
//                    });
//                    Text text = new Text("You failed to connect");
//                    Group group = new Group(text);
//                    Scene scene = new Scene(group,400,400);
//                    primaryStage.setScene(scene);
//                    primaryStage.show()
//                    ;
//                } else online(primaryStage);

            });

            online.setOnAction((ActionEvent e) -> {
            	
          
//            setServer();
                socket = lookForServer();
                if (socket == null) {
                    // TODO: let user know
                    Text text = new Text("You failed to connect");
                    Group group = new Group(text);
                    Scene scene = new Scene(group);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                } else online(primaryStage);
            });
            Button quit = new Button("quit");

            quit.setOnAction((ActionEvent e) -> {
                primaryStage.close();

            });
            HBox hList = new HBox();
            VBox vBox = new VBox();
            //hList.setSpacing(325);
            hList.getChildren().addAll(p1, p2, online);
            Group root = new Group();
            vBox.getChildren().addAll(hList, quit);
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



    public static Socket lookForServer() {
        for (int j = 0; j < 5; j++) { //TODO: change the counter to a resonable amoount.
            try {
                final Socket socket = new Socket(ipAddress, 80);
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                System.out.println(in.readUTF());
                return socket;
            } catch (Exception e) {
                //e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        return null;
    }

    public boolean isReady = false;

    public void online(Stage stage) {
        try {
            stage.show();
            Text text = null;
            Text playersConnected = new Text("nobody is ready");
            VBox vBox = null;
            Button quit = new Button("quit");
            Button ready = new Button("Ready");
            //todo: we need to figure out what is wrong with the code
            //  send help abhik

//        while (true) {
//            try {
//                String line = in.readUTF();
//                playersReady.setText(line);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            try {
                String con = in.readUTF();
                text = new Text(con);
            } catch (Exception e) {
                text = new Text("connection failed");
                e.printStackTrace();
            }
            quit.setOnAction((ActionEvent e) -> {
                start(stage);

            });

            ready.setOnAction((ActionEvent e) -> {
                if (!isReady) {
                    isReady = true;
                    try {
                        ready.setText("Unready");
                        out.writeUTF("1");


                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    isReady = false;
                    try {
                        ready.setText("Ready");
                        out.writeUTF("-1");

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                String line = null;
                try {
                    line = in.readUTF();
                    if (line.equals("you have connected to the server"))
                        line = in.readUTF();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println(line);
                playersConnected.setText(line);
            });

            vBox = new VBox();
            vBox.getChildren().addAll(text, quit, ready, playersConnected);
            vBox.setSpacing(10);
            Group root = new Group(vBox);
            Scene scene = new Scene(root, 400, 400);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
          
    public static Socket lookForServer() {
        for (int j = 0; j < 30; j++) {
            try {
                final Socket socket = new Socket(ipAddress, 80);
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                System.out.println(in.readUTF());
                return socket;
            } catch (Exception e) {
                //e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        return null;
    }

    public void online(Stage stage) {
        Text text = null;
//        Text playersConnected = null;
        VBox vBox = null;

        try {
            String con = in.readUTF();
            text = new Text(con);
        } catch (Exception e) {
            text = new Text("connection failed");

    public void settingOnline(Stage primaryStage) {
        socket = lookForServer();
        if (socket == null) {
            //TODO: let user know

            Button back = new Button("Back");
            Button again = new Button("Try again");
            back.setOnAction((ActionEvent e) -> {
                start(primaryStage);
            });
            again.setOnAction((ActionEvent e) ->
            {
                settingOnline(primaryStage);
            });
            Text text = new Text("You failed to connect");
            VBox vBox = new VBox();
            vBox.setSpacing(10);
            vBox.getChildren().addAll(text, again, back);
            Group group = new Group(vBox);
            Scene scene = new Scene(group, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } else online(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);

        stage.setScene(scene);
        stage.show();
    }
}
