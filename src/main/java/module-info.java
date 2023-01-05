module com.example.java_ana_katsitadze {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;
    requires static lombok;

    opens com.example.java_ana_katsitadze to javafx.fxml;
    exports com.example.java_ana_katsitadze;
}