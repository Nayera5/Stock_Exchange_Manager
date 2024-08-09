package com.example.oooh;

import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
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

public class AdminController {
    private Scene scene;
    private Stage stage;
    private Parent root;
    private Parent root1;
    private Parent root3;

    String fnameOld, lnameOld, emailOld, genderOld;
    double  balanceOld;
    int k;
    @FXML
    private Label balance1;

    @FXML
    private Label balance2;

    @FXML
    private Label balance3;

    @FXML
    private Label balance4;

    @FXML
    private Label email1;

    @FXML
    private Label email2;

    @FXML
    private Label email3;

    @FXML
    private Label email4;

    @FXML
    private Label gender1;

    @FXML
    private Label gender2;

    @FXML
    private Label gender3;

    @FXML
    private Label gender4;

    @FXML
    private Label name1;

    @FXML
    private Label name2;

    @FXML
    private Label name3;

    @FXML
    private Label name4;
    @FXML
    MenuItem stock2;

    @FXML
    private Label timer1 = new Label();
    HelloController hello = new HelloController();
    CompanyController comp = new CompanyController();
    public void initialize() {
        TimerManager timerManager = TimerManager.getInstance();
        timerManager.elapsedTimeProperty().addListener((observable, oldValue, newValue) -> {
            updateTimer(newValue.longValue());
        });
    }

    @FXML
    private void startStopwatch() throws IOException {
        TimerManager.getInstance().start();
        comp.New = false;
    }

    @FXML
    private void stopStopwatch() throws IOException {
        TimerManager.getInstance().stop();
        comp.New = true;
    }

    private void updateTimer(long elapsedTime) {
        long hours = elapsedTime / 3600;
        long minutes = (elapsedTime % 3600) / 60;
        long seconds = elapsedTime % 60;
        timer1.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }

    public void goToUserMan(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("User Management.fxml"));
            root1 = loader.load();
            AdminController con = loader.getController();

            setUserDetails(con, x);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root1);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();        }
    }

    private void setUserDetails(AdminController con, int userIdx) {
        switch (userIdx) {
            case 1:
                con.setUser1(userList.get(0).getFirst(), userList.get(0).getLast(), userList.get(0).getEmail(), userList.get(0).getBalance(), userList.get(0).getGender());
                break;
            case 2:
                con.setUser1(userList.get(0).getFirst(), userList.get(0).getLast(), userList.get(0).getEmail(), userList.get(0).getBalance(), userList.get(0).getGender());
                con.setUser2(userList.get(1).getFirst(), userList.get(1).getLast(), userList.get(1).getEmail(), userList.get(1).getBalance(), userList.get(1).getGender());
                break;
            case 3:
                con.setUser1(userList.get(0).getFirst(), userList.get(0).getLast(), userList.get(0).getEmail(), userList.get(0).getBalance(), userList.get(0).getGender());
                con.setUser2(userList.get(1).getFirst(), userList.get(1).getLast(), userList.get(1).getEmail(), userList.get(1).getBalance(), userList.get(1).getGender());
                con.setUser3(userList.get(2).getFirst(), userList.get(2).getLast(), userList.get(2).getEmail(), userList.get(2).getBalance(), userList.get(2).getGender());
                break;
            case 4:
                con.setUser1(userList.get(0).getFirst(), userList.get(0).getLast(), userList.get(0).getEmail(), userList.get(0).getBalance(), userList.get(0).getGender());
                con.setUser2(userList.get(1).getFirst(), userList.get(1).getLast(), userList.get(1).getEmail(), userList.get(1).getBalance(), userList.get(1).getGender());
                con.setUser3(userList.get(2).getFirst(), userList.get(2).getLast(), userList.get(2).getEmail(), userList.get(2).getBalance(), userList.get(2).getGender());
                con.setUser4(userList.get(3).getFirst(), userList.get(3).getLast(), userList.get(3).getEmail(), userList.get(3).getBalance(), userList.get(3).getGender());
                break;
        }
    }

    public void goTobonds(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("bonds.fxml"));
        root = loader.load();
        Scene scene2 = new Scene(root);
        Stage stage = (Stage) stock2.getParentPopup().getOwnerWindow();
        stage.setScene(scene2);
        stage.show();
    }

    public void logOut(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setUser1( String fname,String lname,String  email,double balance, String gender ) {
        //System.out.println(fname + lname);
        name1.setText(fname+" "+lname);
        email1.setText(email);
        gender1.setText(gender);
        balance1.setText(Double.toString(balance));

    }
    public void setUser2( String fname,String lname,String  email,double balance,String gender ) {

        name2.setText(fname+" "+lname);
        email2.setText(email);
        gender2.setText(gender);
        balance2.setText(Double.toString(balance));

    }
    public void setUser3( String fname,String lname,String  email,double balance,String gender ) {

        name3.setText(fname+" "+lname);
        email3.setText(email);
        gender3.setText(gender);
        balance3.setText(Double.toString(balance));

    }
    public void setUser4( String fname,String lname,String  email,double balance, String gender ) {

        name4.setText(fname+" "+lname);
        email4.setText(email);
        gender4.setText(gender);
        balance4.setText(Double.toString(balance));
    }
    public void goHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("adminPage3.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void deleteUser1(ActionEvent event) throws IOException {
        userList.remove(0);
        x--;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("User Management.fxml"));
        root1 = loader.load();
        AdminController con2 = loader.getController();
        setUserDetails(con2, x);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();


    }
    public void deleteUser2(ActionEvent event) throws IOException {
        userList.remove(1);
        x--;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("User Management.fxml"));
        root1 = loader.load();
        AdminController con2 = loader.getController();
        setUserDetails(con2, x);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();

    }
    public void deleteUser3(ActionEvent event) throws IOException {

        userList.remove(2);
        x--;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("User Management.fxml"));
        root1 = loader.load();
        AdminController con2 = loader.getController();
        setUserDetails(con2, x);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }
    public void deleteUser4(ActionEvent event) throws IOException {

        userList.remove(3);
        x--;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("User Management.fxml"));
        root1 = loader.load();
        AdminController con2 = loader.getController();
        setUserDetails(con2, x);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }
    public void goToOrders(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("transOrders.fxml"));
        root3 = loader.load();
        OrderController con = loader.getController();
        con.setOrder(con, UserController.y);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root3);
        stage.setScene(scene);
        stage.show();
    }
    public void chart(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chartpage.fxml"));
        root = loader.load();
        ChartsController con = loader.getController();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void buy(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("company.fxml"));
        root = loader.load();
        CompanyController con = loader.getController();
        if (CompanyController.i == 1)
            con.com_Initialize();
        else
            con.companies();

        con.calc_Change();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
