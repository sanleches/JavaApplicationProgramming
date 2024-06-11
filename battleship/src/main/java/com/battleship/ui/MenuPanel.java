package com.battleship.ui;

import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class MenuPanel extends VBox {
    private boolean isMenuVisible = false;

    public MenuPanel() {
        setAlignment(Pos.TOP_RIGHT);
        setSpacing(0);
        setPadding(new Insets(60, 0, 0, 0));  // 40 pixels padding from the top

        VBox settingsContainer = new VBox();
        settingsContainer.setPrefSize(525, 62);  // Adjust size directly on VBox
        settingsContainer.setMaxSize(525, 62);   // Set the maximum size to prevent stretching
        settingsContainer.setMinSize(525, 62);   // Set the minimum size to ensure it doesn't shrink
        settingsContainer.setStyle("-fx-background-color: #243E5A; -fx-padding: 10px;");

        Label settingsLabel = new Label("Settings");
        settingsLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
        settingsLabel.setAlignment(Pos.CENTER);
        settingsLabel.setMaxWidth(Double.MAX_VALUE);
        settingsLabel.setMaxHeight(Double.MAX_VALUE);
        settingsLabel.setPrefWidth(525 - 20);  // Adjust for padding
        settingsLabel.setPrefHeight(62 - 20);  // Adjust for padding
        settingsContainer.getChildren().add(settingsLabel);
        settingsContainer.setAlignment(Pos.CENTER);  // Align content center to ensure label is centered within the box

        VBox dropdownMenu = new VBox();
        dropdownMenu.setPrefWidth(525);
        dropdownMenu.setVisible(false);  // Initially hidden
        dropdownMenu.setStyle("-fx-background-color: #3B6491; -fx-border-color: #101B27; -fx-border-width: 1px;");

        String[] menuOptions = {
            "Change language", "Save game", "Restart game",
            "Help", "About", "Match", "Host", "Offline mode"
        };

        for (String optionText : menuOptions) {
            Label menuItem = new Label(optionText);
            menuItem.setPrefHeight(62);
            menuItem.setPrefWidth(525);
            menuItem.setAlignment(Pos.CENTER);
            menuItem.setStyle("-fx-background-color: #3B6491; -fx-text-fill: white; -fx-font-size: 16px;");
            applyHoverEffect(menuItem, "#3B6491");
            menuItem.setOnMouseClicked(event -> {
                System.out.println(menuItem.getText() + " clicked!");
                // Add more functionality here as needed
            });
            dropdownMenu.getChildren().add(menuItem);
        }

        settingsContainer.setOnMouseClicked(event -> {
            isMenuVisible = !isMenuVisible;
            dropdownMenu.setVisible(isMenuVisible);
        });

        getChildren().addAll(settingsContainer, dropdownMenu);
    }

    // Method to apply hover effect to a Label
    private void applyHoverEffect(Label label, String color) {
        String hoverColor = lightenColor(color, 0.2);
        label.setOnMouseEntered(event -> label.setStyle("-fx-background-color: " + hoverColor + "; -fx-text-fill: white; -fx-font-size: 16px;"));
        label.setOnMouseExited(event -> label.setStyle("-fx-background-color: " + color + "; -fx-text-fill: white; -fx-font-size: 16px;"));
    }

    // Method to lighten a color by a certain factor
    private String lightenColor(String color, double factor) {
        javafx.scene.paint.Color c = javafx.scene.paint.Color.web(color);
        double red = Math.min(c.getRed() + factor, 1.0);
        double green = Math.min(c.getGreen() + factor, 1.0);
        double blue = Math.min(c.getBlue() + factor, 1.0);
        return String.format("#%02X%02X%02X",
                (int) (red * 255),
                (int) (green * 255),
                (int) (blue * 255));
    }
}

