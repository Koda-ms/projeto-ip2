package br.ufrpe.habitact.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaDeLoginControlador extends Application {
    private TabPane principal;
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Login");

        initMainStage();
    }

    private void initMainStage() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TelaDeLoginControlador.class.getResource("gui/TelaDeLogin.fxml"));
            this.principal = (TabPane) loader.load();

            Scene cena = new Scene(this.principal);
            this.primaryStage.setScene(cena);
            this.primaryStage.show();
        }catch (IOException ioe){
            throw new IOException("IOException");
        }

    }
}
