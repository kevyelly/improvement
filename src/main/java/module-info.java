module com.example.improvement {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.improvement to javafx.fxml;
    exports com.example.improvement;
}