module com.battleship {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.battleship to javafx.fxml;
    exports com.battleship;
}
