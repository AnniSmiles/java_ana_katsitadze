package com.example.java_ana_katsitadze;

import com.example.java_ana_katsitadze.Classes.Flights;
import com.example.java_ana_katsitadze.Classes.FlightsUtil;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Map;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("form.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 800);
        stage.setTitle("Homework 4");
        stage.setScene(scene);
        stage.show();

        FlightsUtil.createTable();



    }

    public static void main(String[] args) {
        launch();
    }




}