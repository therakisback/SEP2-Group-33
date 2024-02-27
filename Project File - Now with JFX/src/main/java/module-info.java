module org.example.project_filenow_with_jfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires junit;
    requires org.testng;

    opens org.example.project_filenow_with_jfx to javafx.fxml;
    exports org.example.project_filenow_with_jfx;
}