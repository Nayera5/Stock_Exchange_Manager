package com.example.oooh;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class StockController {

    @FXML
    private Label change1;

    @FXML
    private Label change2;

    @FXML
    private Label change3;

    @FXML
    private Label close1;

    @FXML
    private Label close2;

    @FXML
    private Label close3;

    @FXML
    private Label open1;

    @FXML
    private Label open2;

    @FXML
    private Label open3;
//Company comp=new Company();
HelloController price = new HelloController();

public void isUser(ActionEvent event) throws IOException {
    price.goToUserscreen(event);
    open1.setText("10$");
    open2.setText("5$");
    open3.setText("2$");

}



}
