package com.example.oooh;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

import static com.example.oooh.HelloController.*;
import static com.example.oooh.HelloController.gender;

public class OrderController {
    private Scene scene;
    private Stage stage;
    public static ArrayList<Order> orderList = new ArrayList<>();
    public static String nameNew;
    Parent root;
    public static boolean approval = false;
    @FXML
    private Label amount1;

    @FXML
    private Label amount2;

    @FXML
    private Label amount3;

    @FXML
    private Label amount4;

    @FXML
    private Label type1;

    @FXML
    private Label type2;

    @FXML
    private Label type3;

    @FXML
    private Label type4;

    @FXML
    private Label user1;

    @FXML
    private Label user2;

    @FXML
    private Label user3;

    @FXML
    private Label user4;
     UserController user = new UserController();
    HelloController hello = new HelloController();


    public void goHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("adminPage3.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setOrder(OrderController con, int userIdy) {
        switch (userIdy) {
            case 1:
                con.setOrder1(orderList.get(0).getUser(), orderList.get(0).getType(), orderList.get(0).getAmount());
                break;
            case 2:
                con.setOrder1(orderList.get(0).getUser(), orderList.get(0).getType(), orderList.get(0).getAmount());
                con.setOrder2(orderList.get(1).getUser(), orderList.get(1).getType(), orderList.get(1).getAmount());
                break;
            case 3:
                con.setOrder1(orderList.get(0).getUser(), orderList.get(0).getType(), orderList.get(0).getAmount());
                con.setOrder2(orderList.get(1).getUser(), orderList.get(1).getType(), orderList.get(1).getAmount());
                con.setOrder3(orderList.get(2).getUser(), orderList.get(2).getType(), orderList.get(2).getAmount());
                break;
            case 4:
                con.setOrder1(orderList.get(0).getUser(), orderList.get(0).getType(), orderList.get(0).getAmount());
                con.setOrder2(orderList.get(1).getUser(), orderList.get(1).getType(), orderList.get(1).getAmount());
                con.setOrder3(orderList.get(2).getUser(), orderList.get(2).getType(), orderList.get(2).getAmount());
                con.setOrder4(orderList.get(3).getUser(), orderList.get(3).getType(), orderList.get(3).getAmount());
                break;
        }
    }

    public void setOrder1(String name , String type , float amount)  {

        user1.setText(name);
        type1.setText(type);
        amount1.setText(Float.toString(amount));
    }
    public void setOrder2(String name , String type , float amount)  {

        user2.setText(name);
        type2.setText(type);
        amount2.setText(Float.toString(amount));

    }
    public void setOrder3(String name , String type , float amount)  {

        user3.setText(name);
        type3.setText(type);
        amount3.setText(Float.toString(amount));

    }
    public void setOrder4(String name , String type , float amount)  {

        user4.setText(name);
        type4.setText(type);
        amount4.setText(Float.toString(amount));

    }
    public void approve1(ActionEvent event) throws IOException {
        nameNew= user1.getText();
        orderList.remove(0);
        approve(event);
    }
    public void approve2(ActionEvent event) throws IOException {
        nameNew = user2.getText();
        orderList.remove(1);
        approve(event);
    }
    public void approve3(ActionEvent event) throws IOException {
        nameNew = user3.getText();
        orderList.remove(2);
        approve(event);
    }
    public void approve4(ActionEvent event) throws IOException {
        nameNew = user4.getText();
        orderList.remove(3);
       approve(event);
    }
    public  void approve(ActionEvent event) throws IOException {
        hello.get1();
        if(!approval)
            user.calc_deposit();
        else
            user.calc_withdraw();

        UserController.y--;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("transOrders.fxml"));
        root = loader.load();
        OrderController con = loader.getController();
        setOrder(con, UserController.y);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
