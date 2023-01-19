package com.example.temperaturecalculatorapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;


public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("hello-view.fxml"));

        VBox rootNode = fxmlLoader.load();
        MenuBar menuBar = createMenu();

        rootNode.getChildren().add(0,menuBar);
        Scene scene = new Scene(rootNode, 320, 240);
        stage.setTitle("Temperature Converter Tool");
        stage.setScene(scene);
        stage.show();
    }
    private MenuBar createMenu(){
        // File Menu
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");

        newMenuItem.setOnAction(actionEvent -> System.out.println("New MenuItem Clicked"));

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

        MenuItem quitMenuItem = new MenuItem("Quit");

        quitMenuItem.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });
        fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);


        // Help Menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");

        aboutApp.setOnAction(actionEvent -> aboutApp());
        helpMenu.getItems().addAll(aboutApp);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);
        return menuBar;

    }

    private void aboutApp() {
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My First Desktop App");
        alertDialog.setHeaderText("Learning JavaFx");
        alertDialog.setContentText("I am Just beginner but soon  will be pro");
        ButtonType yesBtn = new ButtonType("yes");
        ButtonType noBtn= new ButtonType("No");
        alertDialog.getButtonTypes().setAll(yesBtn, noBtn);
        Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

        if(clickedBtn.isPresent() && clickedBtn.get() == yesBtn){
            System.out.println("Yes Button Clicked");
        }
        else
        {
            System.out.println("No Button Clicked");
        }

    }
    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        super.stop();
    }


}