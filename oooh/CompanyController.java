package com.example.oooh;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javafx.scene.control.*;


import java.io.FileWriter;


import static com.example.oooh.HelloController.balance;
import static com.example.oooh.HelloController.x;

public class CompanyController {

    private Scene scene;
    private Stage stage;
    private Parent root;
    public static ArrayList<Company> companyList = new ArrayList<>();
    public static Company company;
    public static ArrayList<sellStocks> stockList = new ArrayList<>();
    public static sellStocks stock;
    String companyChoice;
    int quantityChoice, quantitysell;
    int quantityInit = 20, quantity, minP = 100, maxP = 500, minQ = 5, maxQ = 20;

    float price = 0;
    float open = 0, close = 0;
    public static int i = 1;
    public static boolean New = false;
    public static float changeinit1, changeinit2, changeinit3;
    @FXML
    Label closed;
    @FXML
    private Label change1;

    @FXML
    private Label change2;

    @FXML
    private Label change3;

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

    @FXML
    private ComboBox<String> comboCompany = new ComboBox();

    @FXML
    private ComboBox<Integer> comboQuantity = new ComboBox();
    @FXML
    private Label timer = new Label();
    @FXML
    private Label changeSell1;

    @FXML
    private Label changeSell2;

    @FXML
    private Label changeSell3;

    @FXML
    private ComboBox<String> comboCompanySell = new ComboBox();

    @FXML
    private ComboBox<Integer> comboQuantitySell = new ComboBox();

    @FXML
    private Label priceSell1;

    @FXML
    private Label priceSell2;

    @FXML
    private Label priceSell3;

    @FXML
    private Label quantitySell1;

    @FXML
    private Label quantitySell2;

    @FXML
    private Label quantitySell3;
    public static ArrayList<Float> price_arr = new ArrayList<>();
    public static ArrayList<Float> price_arr2 = new ArrayList<>();
    public static ArrayList<Float> price_arr3 = new ArrayList<>();
    HelloController hello = new HelloController();
    LocalDateTime currentTime = HelloApplication.TimeTracker.getCurrentTime();

    public void initialize() throws IOException {
        comboCompany.setItems(FXCollections.observableArrayList("AAPL", "AMZN", "NVDIA"));
        comboQuantity.setItems(FXCollections.observableArrayList(1,2,3,4, 5));
        comboCompanySell.setItems(FXCollections.observableArrayList("AAPL", "AMZN", "NVDIA"));
        comboQuantitySell.setItems(FXCollections.observableArrayList(1, 2, 3,4,5));
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

    public void goHome(ActionEvent event) throws IOException {
        //Parent root = FXMLLoader.load(getClass().getResource("userPage.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("userPage.fxml"));
        root = loader.load();
        UserController u = loader.getController();
        u.add(balance);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void sell(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sell.fxml"));
            root = loader.load();
            CompanyController com = loader.getController();
            setStockDetails(com);
            com.calcChangeSell();
            com.setStock1(stockList.get(0).getQuantity(), stockList.get(0).getPrice());
            com.setStock2(stockList.get(1).getQuantity(), stockList.get(1).getPrice());
            com.setStock3(stockList.get(2).getQuantity(), stockList.get(2).getPrice());
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buy(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("company.fxml"));
            root = loader.load();
            CompanyController com = loader.getController();
            setUserDetails(com);
            com.calc_Change();
            com.setCompany1(companyList.get(0).getQuantity(), companyList.get(0).getPrice(), companyList.get(0).getOpen(), companyList.get(0).getClose());
            com.setCompany2(companyList.get(1).getQuantity(), companyList.get(1).getPrice(), companyList.get(1).getOpen(), companyList.get(1).getClose());
            com.setCompany3(companyList.get(2).getQuantity(), companyList.get(2).getPrice(), companyList.get(2).getOpen(), companyList.get(2).getClose());
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUserDetails(CompanyController com) {
        companyChoice = comboCompany.getValue();
        quantityChoice = comboQuantity.getValue();

        switch (companyChoice) {

            case "AAPL":
                setComValue(0);
                break;
            case "AMZN":
                setComValue(1);

                break;
            case "NVDIA":
                setComValue(2);

                break;
        }
    }

    public void setStockDetails(CompanyController com) {
        companyChoice = comboCompanySell.getValue();
        quantityChoice = comboQuantitySell.getValue();
        switch (companyChoice) {
            case "AAPL":
                setStockValue(0);
                break;
            case "AMZN":
                setStockValue(1);
                break;
            case "NVDIA":
                setStockValue(2);
                break;
        }
    }

    public void setCompany1(int quantity, float price, float open, float close) {

        price1.setText(Float.toString(price));
        quantity1.setText(Integer.toString(quantity));
        open1.setText(Float.toString(open));
        close1.setText(Float.toString(close));
    }

    public void setCompany2(int quantity, float price, float open, float close) {

        price2.setText(Float.toString(price));
        quantity2.setText(Integer.toString(quantity));
        open2.setText(Float.toString(open));
        close2.setText(Float.toString(close));
    }

    public void setCompany3(int quantity, float price, float open, float close) {

        price3.setText(Float.toString(price));
        quantity3.setText(Integer.toString(quantity));
        open3.setText(Float.toString(open));
        close3.setText(Float.toString(close));
    }

    public void com_Initialize() {

        for (i = 1; i <= 3; i++) {

            price = (float) (minP + Math.random() * (maxP - minP));
            open = price;
            quantityInit = (int) (minQ + Math.random() * (maxQ - minQ));
            company = new Company(price, quantityInit, open, close);
            companyList.add(company);
            stock = new sellStocks(0, 0);
            stockList.add(stock);

        }
        companies();
        System.out.println(companyList.get(0).getQuantity() + "  " + companyList.get(2).getQuantity());
    }

    public void companies() {
        setCompany1(companyList.get(0).getQuantity(), companyList.get(0).getPrice(), companyList.get(0).getOpen(), companyList.get(0).getClose());
        setCompany2(companyList.get(1).getQuantity(), companyList.get(1).getPrice(), companyList.get(1).getOpen(), companyList.get(1).getClose());
        setCompany3(companyList.get(2).getQuantity(), companyList.get(2).getPrice(), companyList.get(2).getOpen(), companyList.get(2).getClose());
    }

    public void calc_Change() {
        if (New) {
            for (int i = 0; i < companyList.size(); i++) {
                Company company = companyList.get(i);
                price = company.getPrice();
                company.setClose(price);
//                close1.setText(Float.toString(companyList.get(0).getClose()));
//                close2.setText(Float.toString((companyList.get(1).getClose())));
//                close3.setText(Float.toString((companyList.get(2).getClose())));
                System.out.println("Chhh" + company.getClose());
            }
            companies();


            changeinit1 = (companyList.get(0).getClose() - companyList.get(0).getOpen()) / companyList.get(0).getOpen();
            changeinit2 = (companyList.get(1).getClose() - companyList.get(1).getOpen()) / companyList.get(1).getOpen();
            changeinit3 = (companyList.get(2).getClose() - companyList.get(2).getOpen()) / companyList.get(2).getOpen();
            String[] headers = {"Open price","closed price", "#Stocks", "profits/loss" ," Time"};
            String fileName = "output22.csv";
            try (FileWriter writer = new FileWriter(fileName)) {
                // Write headers
                for (String header : headers) {
                    writer.append(header).append(",");
                }
                writer.append("\n");

                // Write data
                for (int i = 0; i < companyList.size(); i++) {
                    company = companyList.get(i);
                    writer.append(String.valueOf(company.getOpen())).append(",").append(String.valueOf(company.getClose())).append(",").append(String.valueOf(company.getQuantity())).append(",")
                            .append(String.valueOf((companyList.get(i).getClose() - companyList.get(i).getOpen()) / companyList.get(i).getOpen()))
                            .append(",").append(String.valueOf(currentTime)).append("\n");
                }
                System.out.println("CSV file created: " + fileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        change1.setText(Float.toString((changeinit1)));
        change2.setText(Float.toString((changeinit2)));
        change3.setText(Float.toString((changeinit3)));

    }

    public void setStock1(int quantity, float price) {

        priceSell1.setText(Float.toString(price));
        quantitySell1.setText(Integer.toString(quantity));
    }

    public void setStock2(int quantity, float price) {

        priceSell2.setText(Float.toString(price));
        quantitySell2.setText(Integer.toString(quantity));
    }

    public void setStock3(int quantity, float price) {

        priceSell3.setText(Float.toString(price));
        quantitySell3.setText(Integer.toString(quantity));
    }

    public void stocks() {
        setStock1(stockList.get(0).getQuantity(), stockList.get(0).getPrice());
        setStock2(stockList.get(1).getQuantity(), stockList.get(1).getPrice());
        setStock3(stockList.get(2).getQuantity(), stockList.get(2).getPrice());
    }

    public void calcChangeSell() {
        changeSell1.setText(Float.toString((changeinit1)));
        changeSell2.setText(Float.toString((changeinit2)));
        changeSell3.setText(Float.toString((changeinit3)));
    }

    public void setComValue(int index) {

        quantity = companyList.get(index).getQuantity();
        price = companyList.get(index).getPrice();
        hello.get();
        if (quantity >= 0 && !New && balance > (price * quantityChoice)) {
            quantity = quantity - quantityChoice;
            companyList.get(index).setQuantity(quantity);
            balance = balance - price * quantityChoice;
            hello.set();
            price = price*(quantityChoice+1);
            companyList.get(index).setPrice(price);
            stockList.get(index).setPrice(price);
            quantitysell = stockList.get(index).getQuantity();
            quantitysell = quantitysell + quantityChoice;
            stockList.get(index).setQuantity(quantitysell);
            if (companyChoice.equals("AAPL")) {
                price_arr.add(price);
                System.out.println("hhhhh");
            }
            if (companyChoice.equals("AMZN")) {
                price_arr2.add(price);
            }
            if (companyChoice.equals("NVDIA")) {
                price_arr3.add(price);
            }
        }

    }

    public void setStockValue(int index) {
        price = companyList.get(index).getPrice();
        quantitysell = stockList.get(index).getQuantity();
        quantity = companyList.get(index).getQuantity();
        hello.get();
        if ((quantitysell - quantityChoice) >= 0 && !New) {
            quantitysell = quantitysell - quantityChoice;
            stockList.get(index).setQuantity(quantitysell);
            balance = balance + price * quantityChoice;
            hello.set();
            price = price - (price / 5);
            stockList.get(index).setPrice(price);
            companyList.get(index).setPrice(price);
            quantity = quantity + quantityChoice;
            companyList.get(index).setQuantity(quantity);

            if (companyChoice.equals("AAPL")) {
                price_arr.add(price);
                System.out.println("hhhhh");
            }
            if (companyChoice.equals("AMZN")) {
                price_arr2.add(price);
            }
            if (companyChoice.equals("NVDIA")) {
                price_arr3.add(price);
            }
        }
    }
}