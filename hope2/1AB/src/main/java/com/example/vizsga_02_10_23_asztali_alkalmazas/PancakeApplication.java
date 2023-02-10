package com.example.vizsga_02_10_23_asztali_alkalmazas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PancakeApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        GridPane gpPancakeOrder = new GridPane();

        Scene scene = new Scene(gpPancakeOrder, 800, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}