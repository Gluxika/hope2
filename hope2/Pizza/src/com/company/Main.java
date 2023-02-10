package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label alapTesztaSzoveg = new Label("Milyen tészta alapot szeretne felhasználni a pizzához?");
        ToggleGroup tesztaCsoport = new ToggleGroup();

        RadioButton rb1 = new RadioButton("vékony tészta");
        rb1.setToggleGroup(tesztaCsoport);
        rb1.setSelected(true);

        RadioButton rb2 = new RadioButton("normál tészta");
        rb2.setToggleGroup(tesztaCsoport);
        rb2.setSelected(true);

        RadioButton rb3 = new RadioButton("vastag tészta");
        rb3.setToggleGroup(tesztaCsoport);

        CheckBox glutenMentesE = new CheckBox("Gluténmentes legyen a pizza?");
        CheckBox laktozMentesE = new CheckBox("Laktózmentes legyen a pizza?");

        Label extraFeltetSzoveg = new Label("Milyen extra feltétet kér a pizzára?");
        ChoiceBox<String> extraFeltetek = new ChoiceBox<>();
        extraFeltetek.getItems().addAll("semmi", "olívabogyó", "szardella", "articsóka");
        extraFeltetek.setValue(extraFeltetek.getItems().get(0));

        Label megjegyzesekSzoveg = new Label("Ide írhatja megjegyzéseit a rendeléshez:");
        TextField megjegyzesek = new TextField();

        megjegyzesek.setPrefWidth(250);
        megjegyzesek.setPrefHeight(200);

        Button rendelesGomb = new Button("Rendelés elküldése");

//        PasswordField pwf = new PasswordField();
/*
        Region region = new Region();
        region.setPrefWidth(200);
        region.setPrefHeight(100);
        region.setMinHeight(100);
*/
        GridPane gp = new GridPane();
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setAlignment(Pos.CENTER);
        gp.setPadding(new Insets(20, 20, 20, 20));

        GridPane.setConstraints(alapTesztaSzoveg, 0, 0);
        GridPane.setConstraints(rb1, 0, 1);
        GridPane.setConstraints(rb2, 0, 2);
        GridPane.setConstraints(rb3, 0, 3);
        GridPane.setConstraints(glutenMentesE, 2, 1);
        GridPane.setConstraints(laktozMentesE, 2, 2);
        GridPane.setConstraints(extraFeltetSzoveg, 2, 4);
        GridPane.setConstraints(extraFeltetek, 2, 5);

//        GridPane.setConstraints(region, 2, 6);

        GridPane.setConstraints(megjegyzesekSzoveg, 1, 7);
        GridPane.setConstraints(megjegyzesek, 2, 7);
        GridPane.setConstraints(rendelesGomb, 1, 8);
//        GridPane.setConstraints(pwf, 1, 8);

        gp.getChildren().addAll(alapTesztaSzoveg, rb1, rb2, rb3, glutenMentesE, laktozMentesE,
                extraFeltetSzoveg, extraFeltetek,
                megjegyzesekSzoveg, megjegyzesek, rendelesGomb/*, pwf*/ /*, region*/);

        Scene sc = new Scene(gp);

        rendelesGomb.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER) {
                System.out.println("Enter lenyomva!");
            }
        });

        rendelesGomb.setOnAction(e -> {
            String rendelesSzoveg = "";
            rendelesSzoveg += "A tészta fajtája: ";
            rendelesSzoveg += ((RadioButton) tesztaCsoport.getSelectedToggle()).getText()
                    + System.lineSeparator();
            rendelesSzoveg += "gluténmentes? ";
            if(glutenMentesE.isSelected()) {
                rendelesSzoveg += "igen";
            } else {
                rendelesSzoveg += "nem";
            }
            rendelesSzoveg += System.lineSeparator();

            rendelesSzoveg += "laktózmentes? ";
            if(laktozMentesE.isSelected()) {
                rendelesSzoveg += "igen";
            } else {
                rendelesSzoveg += "nem";
            }
            rendelesSzoveg += System.lineSeparator();

            rendelesSzoveg += System.lineSeparator();

            rendelesSzoveg += "Milyen extra feltétet rendeltünk? ";
            rendelesSzoveg += extraFeltetek.getValue() + System.lineSeparator();

            rendelesSzoveg += "A következők voltak a megjegyzései: " + System.lineSeparator();
            rendelesSzoveg += megjegyzesek.getText();

            Label teljesRendeles = new Label(rendelesSzoveg);
            Button vissza = new Button("Vissza");
            Button mehet = new Button("mehet");

            vissza.setOnAction(e2 -> {
                primaryStage.setScene(sc);
            });


            HBox gombokRendezese = new HBox();
            gombokRendezese.setSpacing(100);
            gombokRendezese.setPadding(new Insets(10, 10, 10, 10));
            gombokRendezese.getChildren().addAll(vissza, mehet);

            VBox ablakRendezese = new VBox();
            ablakRendezese.setSpacing(100);
            ablakRendezese.setPadding(new Insets(20, 20, 20, 20));
            ablakRendezese.getChildren().addAll(teljesRendeles, gombokRendezese);

            Scene veglegesitesJelenet = new Scene(ablakRendezese);
            primaryStage.setScene(veglegesitesJelenet);
        });



        primaryStage.setTitle("Pizzarendelő Program");
        primaryStage.setScene(sc);
        primaryStage.show();
    }
}
