package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Client extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {



            //starting menue

            Button p1 = new Button("1 player");
            Button p2 = new Button("3 players");
            Button online = new Button("Online");

            p2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                }

            });
            p1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    player player1 = new player(1, "player 1");
                }
            });
            online.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                }
            });
            HBox hList = new HBox();
            hList.setSpacing(10);
            hList.getChildren().addAll(p1,p2,online);
            Group root = new Group();
            root.getChildren().add(hList);
            Scene scene = new Scene(root, 400, 400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setFullScreen(true);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
