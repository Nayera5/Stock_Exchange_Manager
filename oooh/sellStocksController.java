package com.example.oooh;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class sellStocksController {
    private Scene scene;
    private Stage stage;
    private Parent root;
    public static ArrayList<sellComoany> sellList = new ArrayList<>();
    public static sellComoany sell;
    @FXML
    private Label ch1;

    @FXML
    private Label ch2;

    @FXML
    private Label ch3;

    @FXML
    private Label close1;

    @FXML
    private Label close2;

    @FXML
    private Label close3;

    @FXML
    private ComboBox<String> comboCompany = new ComboBox();

    @FXML
    private ComboBox<Integer> comboQuantity = new ComboBox();
    @FXML
    private Label open1;

    @FXML
    private Label open2;

    @FXML
    private Label open3;

    @FXML
    private Label price1;

    @FXML
    private Label price2;

    @FXML
    private Label price3;

    @FXML
    private Label quantity1;

    @FXML
    private Label quantity2;

    @FXML
    private Label quantity3;
    @FXML
    private Label timer=new Label();

    public void initialize() throws IOException {
        comboCompany.setItems(FXCollections.observableArrayList("AAPL", "AMZN", "NVDIA"));

        comboQuantity.setItems(FXCollections.observableArrayList(1 ,3, 5 , 10 , 15 , 20));
        TimerManager timerManager = TimerManager.getInstance();
        timerManager.elapsedTimeProperty().addListener((observable, oldValue, newValue) -> {
            updateTimer(newValue.longValue());
        });
    }
    private void updateTimer(long elapsedTime) {
        long hours = elapsedTime / 3600;
        long minutes = (elapsedTime % 3600) / 60;
        long seconds = elapsedTime % 60;
        timer.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }








}
