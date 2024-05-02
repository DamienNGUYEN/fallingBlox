module org.example.fallingblox {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.fallingblox to javafx.fxml;
    exports org.example.fallingblox;
}