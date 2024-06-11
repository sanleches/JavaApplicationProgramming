module com.battleship {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.battleship to javafx.fxml;
    exports com.battleship;
}
