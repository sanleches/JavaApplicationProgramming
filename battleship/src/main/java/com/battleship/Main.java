package com.battleship;

import com.battleship.ui.MainStage;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App tu jfa es wonita
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