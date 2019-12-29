package client;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

        @Override
        public void start(Stage primaryStage) {
            ClientGUI clientGUI = new ClientGUI();

            clientGUI.display();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }


