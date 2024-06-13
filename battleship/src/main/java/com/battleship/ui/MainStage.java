package com.battleship.ui;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;

public class MainStage {
    private Scene scene;

    public MainStage() {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #101B27;");

        scene = new Scene(root, 1920, 1080);  // Set initial size to 1920x1080

        // Title Banner
        Image logoImage = new Image("file:C:/ALGONQUIN WORKSPACES/LVL4 JAVA APP PROGRAMING/Assignment12/src/main/resources/images/logo.png");
        ImageView titleBanner = new ImageView(logoImage);
        titleBanner.setFitWidth(625);  // Adjust width to be approximately as wide as the grid
        titleBanner.setFitHeight(250); // Ensure height does not exceed 250 pixels
        titleBanner.setPreserveRatio(true);
        VBox titleBox = new VBox(titleBanner);
        titleBox.setStyle("-fx-background-color: #101B27; -fx-padding: 20px;"); //dark blue
        titleBox.setAlignment(Pos.CENTER);
        root.setTop(titleBox);

        // Battlefield Grid
        GridPane battlefieldGrid = new GridPane();
        battlefieldGrid.setAlignment(Pos.CENTER);
        battlefieldGrid.setStyle("-fx-background-color: #799FC9; -fx-border-color: #101B27;"); 
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Button cell = new Button();
                cell.setPrefSize(70, 70);  // Set cell size
                cell.setStyle("-fx-background-color: #799FC9; -fx-border-color: #101B27; -fx-border-width: 1px;");  // Set cell background and border color
                applyHoverEffect(cell, "#799FC9");
                battlefieldGrid.add(cell, j, i);
            }
        }

        String imagePath = "file:battleship/src/main/java/com/battleship/ui/images/";

        addImageToGrid(battlefieldGrid, imagePath + "bow_east.png", 0, 0);
        addImageToGrid(battlefieldGrid, imagePath + "bow_north.png", 0, 1);
        addImageToGrid(battlefieldGrid, imagePath + "bow_south.png", 0, 2);
        addImageToGrid(battlefieldGrid, imagePath + "bow_west.png", 0, 3);
        addImageToGrid(battlefieldGrid, imagePath + "midhull_horiz.png", 1, 0);
        addImageToGrid(battlefieldGrid, imagePath + "midhull_vert.png", 1, 1);
        addImageToGrid(battlefieldGrid, imagePath + "hit.png", 1, 2);
        addImageToGrid(battlefieldGrid, imagePath + "miss.png", 1, 3);
        
        // Username Box
        Label usernameLabel = new Label("Username: **");
        usernameLabel.setStyle("-fx-background-color: #3B6491; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 20px;"); // Increase padding and font size
        usernameLabel.setAlignment(Pos.CENTER);

        VBox usernameBox = new VBox(usernameLabel);
        usernameBox.setAlignment(Pos.CENTER);

        // Change View Button
        Button changeViewButton = new Button("Change View");
        changeViewButton.setStyle("-fx-background-color: #3B6491; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 20px;"); // Increase padding and font size
        changeViewButton.setAlignment(Pos.CENTER);
        applyHoverEffect(changeViewButton, "#3B6491");

        VBox changeViewBox = new VBox(changeViewButton);
        changeViewBox.setAlignment(Pos.CENTER);

        // Center layout with battlefield grid and placeholders
        VBox centerBox = new VBox();
        centerBox.setAlignment(Pos.CENTER);
        centerBox.setSpacing(0);  // Remove spacing between elements

        centerBox.getChildren().addAll(usernameBox, battlefieldGrid, changeViewBox);

        // Side Containers for Chat Log and Settings
        HBox mainContainer = new HBox();
        mainContainer.setAlignment(Pos.TOP_CENTER);  // Adjust alignment to top center
        mainContainer.setSpacing(40);

        // Chat Log and Chat Box
        VBox chatContainer = new VBox();
        chatContainer.setPrefSize(525, 20);  // Set width directly on VBox
        chatContainer.setPadding(new Insets(60, 0, 0, 0));  // 60 pixels padding from the top

        VBox chatLogBox = new VBox();
        chatLogBox.setStyle("-fx-background-color: #3B6491; -fx-padding: 10px;");
        chatLogBox.setPrefHeight(640);  // Adjust height to fit remaining space after adding chat box
        Label chatLogLabel = new Label("Chat Log");
        chatLogLabel.setStyle("-fx-padding: 10px; -fx-text-fill: white; -fx-font-size: 16px;");  // Increase font size
        chatLogLabel.setMaxWidth(Double.MAX_VALUE);
        chatLogLabel.setMaxHeight(Double.MAX_VALUE);
        chatLogLabel.setPrefWidth(312 - 20);  // Adjust for padding
        chatLogLabel.setPrefHeight(62 - 20);  // Adjust for padding
        chatLogLabel.setAlignment(Pos.TOP_LEFT);
        chatLogBox.getChildren().add(chatLogLabel);

        VBox chatBoxPlaceholder = new VBox();
        chatBoxPlaceholder.setPrefHeight(62);  // Adjust height directly on VBox
        chatBoxPlaceholder.setStyle("-fx-background-color: #243E5A; -fx-padding: 10px;");
        Label chatBoxLabel = new Label("Chat Box");
        chatBoxLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");  // Increase font size
        chatBoxLabel.setAlignment(Pos.CENTER);
        chatBoxLabel.setMaxWidth(Double.MAX_VALUE);
        chatBoxLabel.setMaxHeight(Double.MAX_VALUE);
        chatBoxLabel.setPrefWidth(312 - 20);  // Adjust for padding
        chatBoxLabel.setPrefHeight(62 - 20);  // Adjust for padding
        chatBoxPlaceholder.getChildren().add(chatBoxLabel);
        chatBoxPlaceholder.setAlignment(Pos.CENTER);  // Align content center to ensure label is centered within the box

        chatContainer.getChildren().addAll(chatLogBox, chatBoxPlaceholder);
        applyHoverEffect(chatBoxPlaceholder, "#243E5A");

        mainContainer.getChildren().addAll(chatContainer, centerBox, new MenuPanel());
        root.setCenter(mainContainer);
    }

    public Scene getScene() {
        return scene;
    }

    // Method to add an image to a specific cell in the grid
    private void addImageToGrid(GridPane grid, String imagePath, int col, int row) {
        ImageView imageView = new ImageView(new Image(imagePath));
        imageView.setFitWidth(70);
        imageView.setFitHeight(70);
        grid.add(imageView, col, row);
    }

    // Method to apply hover effect to a VBox
    private void applyHoverEffect(VBox box, String color) {
        String hoverColor = lightenColor(color, 0.2);
        box.setOnMouseEntered(event -> box.setStyle("-fx-background-color: " + hoverColor + ";"));
        box.setOnMouseExited(event -> box.setStyle("-fx-background-color: " + color + ";"));
    }

    // Method to apply hover effect to a Button
    private void applyHoverEffect(Button button, String color) {
        String hoverColor = lightenColor(color, 0.2);
        button.setOnMouseEntered(event -> button.setStyle("-fx-background-color: " + hoverColor + "; -fx-border-color: #101B27; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10px;"));
        button.setOnMouseExited(event -> button.setStyle("-fx-background-color: " + color + "; -fx-border-color: #101B27; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10px;"));
    }

    // Method to lighten a color by a certain factor
    private String lightenColor(String color, double factor) {
        Color c = Color.web(color);
        double red = Math.min(c.getRed() + factor, 1.0);
        double green = Math.min(c.getGreen() + factor, 1.0);
        double blue = Math.min(c.getBlue() + factor, 1.0);
        return String.format("#%02X%02X%02X",
                (int) (red * 255),
                (int) (green * 255),
                (int) (blue * 255));
    }
}

