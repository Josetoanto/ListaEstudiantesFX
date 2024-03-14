module com.josetoanto.estructuralistasfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.josetoanto.estructuralistasfx to javafx.fxml;
    exports com.josetoanto.estructuralistasfx;
    exports com.josetoanto.estructuralistasfx.controllers;
    opens com.josetoanto.estructuralistasfx.controllers to javafx.fxml;
}