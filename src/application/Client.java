package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.net.InetAddress;


public class Client extends Application {
    private Server server;
    private InetAddress ipAddress;

    @Override
    public void start(Stage primaryStage) {
        try {
            ipAddress = InetAddress.getLocalHost();
            String ip =ipAddress.getHostAddress().trim();
            System.out.println(ip);
            System.out.println(ipAddress.getHostName());

            //starting menu

            Button p1 = new Button("1 player");
            Button p2 = new Button("2 players");
            Button online = new Button("Online");

            p2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    server = new Server("Local Host", new Player("1", "Player 1"),
                            new Player("2", "Player 2"));

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
                server = new Server("Local Host", new Player("1", "Player 1"), null);


            });

            online.setOnAction((ActionEvent e) -> {

            });
            Button quit = new Button("quit");

            quit.setOnAction((ActionEvent e)->{
                primaryStage.close();

            });
            HBox hList = new HBox();
            VBox vBox = new VBox();
            hList.setSpacing(325);
            hList.getChildren().addAll(p1, p2, online);
            Group root = new Group();
            vBox.getChildren().addAll(hList,quit);
            vBox.setPadding(new Insets(100));
            root.getChildren().add(vBox);
            Scene scene = new Scene(root, 400, 400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setFullScreen(true);
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
}
