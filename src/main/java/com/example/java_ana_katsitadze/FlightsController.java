package com.example.java_ana_katsitadze;

import com.example.java_ana_katsitadze.Classes.Flights;
import com.example.java_ana_katsitadze.Classes.FlightsUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class FlightsController {
    @FXML
    private TextField tbFlightDate;
    @FXML
    private TextField tbPlaces;
    @FXML
    private TextField tbDirection;
    @FXML
    private TextField tbStartCity;
    @FXML
    private TextField tbPrice;

    @FXML
    protected void onSaveButtonClick() throws ParseException {
        SimpleDateFormat formatter6=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        Date date=formatter6.parse(tbFlightDate.getText());
        Flights flight = new Flights(tbDirection.getText(),date,Integer.parseInt(tbPrice.getText()),tbStartCity.getText(),Integer.parseInt(tbPlaces.getText()));
        FlightsUtil.insert(flight);
    }
    @FXML
    protected  void onShowGraphButtonClick(ActionEvent event) throws ParseException, IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                GraphController.class.getResource("Graph.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("My modal window");
        stage.initModality((Modality.APPLICATION_MODAL));
        stage.initOwner(
                ((Node)event.getSource()).getScene().getWindow() );
        stage.show();
    }
}
