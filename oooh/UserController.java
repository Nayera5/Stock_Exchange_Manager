package com.example.oooh;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Optional;

import static com.example.oooh.HelloController.*;

public class UserController {
    private Scene scene;
    private Stage stage = new Stage();
    private Parent root;
    public static float depositVar, withdrawVar;
    static int y = 0;
    HelloController hello = new HelloController();
    public static float bal;

    @FXML
    private TextField deposit;
    @FXML
    private TextField withdraw;
    @FXML
    private Label addBalance=new Label();
    @FXML
    private Label timer=new Label();
    @FXML
    private Label balanceProf;

    @FXML
    private Label emailProf;

    @FXML
    private Label genderProf;

    @FXML
    private Label nameProf;

   public void initialize() {
    TimerManager timerManager = TimerManager.getInstance();
    timerManager.elapsedTimeProperty().addListener((observable, oldValue, newValue) -> {
        updateTimer(newValue.longValue());
    });
}

    void add (double salary)
    {
        addBalance.setText(String.valueOf(salary));
          bal = (float) Double.parseDouble(addBalance.getText());

    }

    public void calc_deposit(){
        hello.balance =  hello.balance + depositVar;
        hello.set1();
    }
    public void calc_withdraw() {
        hello.balance =  hello.balance - withdrawVar;
        hello.set1();
    }

    public void logOut(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void goHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("userPage.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void changeBalance(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Please, Wait for approval...");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isEmpty()){
            System.out.println("Alert closed");
        }

        else if(result.get() == ButtonType.OK){

             if(!(deposit.getText()).isEmpty() && (withdraw.getText()).isEmpty()) {
               
                depositVar =Float.parseFloat( deposit.getText());
                y++;
                Order order = new Order( depositVar, "Deposit" ,fname);
                OrderController.orderList.add(order);
                OrderController.approval = false;

            }
            if (!(withdraw.getText()).isEmpty() && (deposit.getText()).isEmpty()) {
                //hello.get();
                withdrawVar = Float.parseFloat(withdraw.getText());
                y++;
                Order order = new Order( withdrawVar, "Withdraw" ,fname);
                OrderController.orderList.add(order);
                OrderController.approval = true;

                if( hello.balance<0)
                {
                    hello.balance =  hello.balance + withdrawVar;
                    addBalance.setText(String.valueOf(hello.balance));
                }

        } else if(result.get() == ButtonType.CANCEL){
            System.out.println("Never!");
        }

        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("transOrders.fxml"));
        root = loader.load();
        OrderController con = loader.getController();
        con.setOrder(con, UserController.y);

    }
    private void updateTimer(long elapsedTime) {
        long hours = elapsedTime / 3600;
        long minutes = (elapsedTime % 3600) / 60;
        long seconds = elapsedTime % 60;
        timer.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }

    public void goToProf(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("userProfile.fxml"));
        root1 = loader.load();
        UserController con = loader.getController();
        hello.get();
        con.setUserProf(fname, lname, email, balance, gender);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }
    public void setUserProf(String fname,String lname,String  email,double balance, String gender){
        nameProf.setText(fname+" "+lname);
        emailProf.setText(email);
        genderProf.setText(gender);
        balanceProf.setText(Double.toString(balance));

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
    public void sell(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sell.fxml"));
        root = loader.load();
        CompanyController con = loader.getController();
        con.stocks();
        con.calcChangeSell();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
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

}

