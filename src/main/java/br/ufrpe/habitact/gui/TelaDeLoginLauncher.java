package br.ufrpe.habitact.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class TelaDeLoginLauncher extends Application {
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = FXMLLoader.load(getClass().getResource("TelaDeLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
        stage.setTitle("Tela de login");
        stage.setScene(scene);
        stage.show();
    }
}
