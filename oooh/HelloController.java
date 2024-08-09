package com.example.oooh;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.control.*;

//import static com.example.oooh.Company.price;

public class HelloController {
    private Scene scene;
    private Stage stage;
    private Parent root;
    public static Parent root1;
    public static String fname, lname, email, pass, gender;
    String fnameOld, lnameOld, emailOld, genderOld;
    double  balanceOld;
    public static String passNew;
      public static double balance;
    public static ArrayList<User> userList = new ArrayList<>();
    public static User user;

     static int x = 0;
    @FXML
    private MenuItem bond;
    @FXML
    private ComboBox<String> combo = new ComboBox();
    @FXML
    PasswordField Pass = new PasswordField();
    @FXML
    TextField Email = new TextField();
    @FXML
    TextField signName0 = new TextField();
    @FXML
    TextField signName1 = new TextField();
    @FXML
    TextField Balance = new TextField();
    @FXML
    private MenuButton Gender;
    @FXML
    private TreeView tree = new TreeView();

    public void initialize() {
         combo.setItems(FXCollections.observableArrayList("Engineer", "Female", "Male"));
    }

    public void goToUserscreen(ActionEvent event) throws IOException {

        boolean isPass = Pass.getText().isEmpty();
        boolean isEmail = Email.getText().isEmpty();
        boolean isName0 = signName0.getText().isEmpty();
        boolean isName1 = signName1.getText().isEmpty();
        boolean isGender= combo.getValue().isEmpty();

        if (!isPass && !isEmail && !isName0 && !isName1 && !isGender) {
            try {
                ay_7aga();
                FXMLLoader loader1 = new FXMLLoader(getClass().getResource("userPage.fxml"));
                root = loader1.load();
                UserController salary = loader1.getController();
                salary.add(balance);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void goToSecondScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void goToadmin(ActionEvent event) throws IOException {

        for (int i = 0; i < userList.size(); i++) {
            user = userList.get(i);
            if (user.getEmail().equals(Email.getText())&&user.getPassword().equals(Pass.getText())){
                passNew = Pass.getText();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("userProfile.fxml"));
                root1 = loader.load();
                userElements();
                UserController con = loader.getController();
                con.setUserProf(fnameOld, lnameOld, emailOld, balanceOld, genderOld);
                System.out.println(".... "+balanceOld + "|| "+ balance);
                FXMLLoader loader1 = new FXMLLoader(getClass().getResource("userPage.fxml"));
                root = loader1.load();
                UserController salary = loader1.getController();
                salary.add(user.getBalance());
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

        }

        String isPass = Pass.getText();
        String isEmail = Email.getText();
        if (isEmail.equals("LATER@gmail.com")&&isPass.equals("1234")){

            Parent root = FXMLLoader.load(getClass().getResource("adminPage3.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void logOut(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void ay_7aga() {
        fname = signName0.getText();
        lname = signName1.getText();
        email = Email.getText();
        pass = Pass.getText();
        gender= combo.getValue();
        balance = Double.parseDouble(Balance.getText());
        x++;
        User c1 = new User(fname, lname, email, pass, gender,balance);

        userList.add(c1);

        String[] headers = {"UserName", "Email", "Password", "Gender","Balance"};
        String fileName = "output.csv";

        try (FileWriter writer = new FileWriter(fileName)) {
            // Write headers
            for (String header : headers) {
                writer.append(header).append(",");
            }
            writer.append("\n");
            for (int i = 0; i < userList.size(); i++) {
                user = userList.get(i);
                writer.append(user.getFirst()+user.getLast()).append(",").append(user.getEmail()).append(",")
                        .append(user.getPassword()).append(",")
                        .append(String.valueOf(user.getGender())) .append(",").append(String.valueOf(user.getBalance())).append("\n");
            }
            System.out.println("CSV file created: " + fileName);

        } catch (IOException e) {
            e.printStackTrace();}




    }
    public void userElements(){
        fnameOld = user.getFirst();
        lnameOld = user.getLast();
        emailOld = user.getEmail();
        balanceOld = user.getBalance();
        genderOld= user.getGender();

    }
    public void get() {
        for (int n = 0; n < x; n++) {
            if (userList.get(n).getBalance()==UserController.bal) {
                fname = userList.get(n).getFirst() + " " + userList.get(n).getLast();
                balance = userList.get(n).getBalance();
                email = userList.get(n).getEmail();
            }
        }
    }
    public void set() {
        for (int n = 0; n < x; n++) {
            if (userList.get(n).getBalance()==UserController.bal) {
                userList.get(n).setBalance(balance);
            }
        }
    }
    public void get1() {
        for (int n = 0; n < x; n++) {
            if (userList.get(n).getFirst().equals(OrderController.nameNew)) {
                fname = userList.get(n).getFirst() + " " + userList.get(n).getLast();
                balance = userList.get(n).getBalance();
                email = userList.get(n).getEmail();
            }
        }
    }
    public void set1() {
        for (int n = 0; n < x; n++) {
            System.out.println(n);
            if (userList.get(n).getFirst().equals(OrderController.nameNew)) {
                userList.get(n).setBalance(balance);
            }

        }
    }


}