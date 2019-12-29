package client;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class ClientGUI {
    NetworkCommunication networkCommunication = new NetworkCommunication();
    Controller controller = new Controller();
    Label label = new Label();

public void display() {
    Stage primaryStage = new Stage();

        label.setText("0");
        Button button = new Button("Press");
        button.setOnAction(e -> {
            controller.setQueueLength(controller.getQueueLength());
            label.setText(controller.getQueueLength());
            networkCommunication.connect(controller);
            networkCommunication.sendQueueLength(controller.getQueueLength());
            try {
                networkCommunication.closeConnection(networkCommunication.getSocket());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        Button button1 = new Button("Delete");
        button1.setOnAction(e -> {
            controller.remove();
            label.setText(controller.getQueueLength());
            System.out.println(controller.getQueueLength());
        });




        BorderPane borderPane = new BorderPane();

        HBox hBox = new HBox();
        hBox.getChildren().addAll(button, button1);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10, 10, 10, 10));

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(label, hBox);

        borderPane.setCenter(vBox);
        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane, 400, 300);

        primaryStage.setTitle("Queue");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}




