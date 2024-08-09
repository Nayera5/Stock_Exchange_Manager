package com.example.oooh;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Stock Exchange");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();


    }


    public class TimeTracker {

        public static LocalDateTime getCurrentTime() {
            return LocalDateTime.now();
        }
    }
}