package minigames.garden;

import javafx.application.Application;
import javafx.stage.Stage;

public class Gardens extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MainWindow.display();
    }


    public static void main(String[] args) {
        launch(args);
    }
}