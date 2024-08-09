package com.example.oooh;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

import static com.example.oooh.HelloController.balance;


public class ChartsController implements Initializable {
    @FXML
    private LineChart<?,?> chart;
    @FXML
    private LineChart<?, ?> chart2;
    @FXML
    private LineChart<?, ?> chart3;
    @FXML
    private Label timer=new Label();
    TimerManager time;
    String x1;
    String x2;
    String x3;
   UserController hi;
    private Scene scene;
    private Stage stage;
    private Parent root;
    public static int j = 1;

    public void initialize() {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series series = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();

     if(TimerManager.timeoff) {
         for (int i = 0; CompanyController.price_arr.size() > i; i++) {
             x1 = Float.toString((float) (i+ 1.2659));
             series.getData().add(new XYChart.Data<>(x1, CompanyController.price_arr.get(i)));
             System.out.println(x1);
             System.out.println(CompanyController.price_arr.get(i));
         }
         for (int i = 0; CompanyController.price_arr2.size() > i; i++) {
             x2 = Float.toString((float) (i+ 0.876));
             series2.getData().add(new XYChart.Data<>(x2, CompanyController.price_arr2.get(i)));
             System.out.println(x2);
             System.out.println(CompanyController.price_arr2.get(i));
         }
         for (int i = 0; CompanyController.price_arr3.size() > i; i++) {
             x3 =Float.toString((float) (i+ 1.167622));
             series3.getData().add(new XYChart.Data<>(x3, CompanyController.price_arr3.get(i)));
             System.out.println(x3);
             System.out.println(CompanyController.price_arr3.get(i));
         }
             chart.getData().add(series);
             chart2.getData().add(series2);
             chart3.getData().add(series3);

     }


    }

    public void goHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("userPage.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}