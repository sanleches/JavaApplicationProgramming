package com.battleship;

import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
import javafx.stage.Stage;

//import java.io.IOException;

import com.battleship.ui.MainStage;

/**
 * JavaFX App
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        MainStage mainStage = new MainStage();
        primaryStage.setTitle("Battleship Game");
        primaryStage.setScene(mainStage.getScene());
        primaryStage.setWidth(1920);  // Set window width to 1920
        primaryStage.setHeight(1080); // Set window height to 1080
        primaryStage.setMaximized(false); // Ensure the window is not maximized
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}