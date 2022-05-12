package br.ufrpe.habitact;

import br.ufrpe.habitact.gui.GerenciadorTelas;
import javafx.application.Application;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage){
        primaryStage.setScene(GerenciadorTelas.getInstance().getLoginScene());
        primaryStage.setTitle("Projeto HabitAct");
        primaryStage.setWidth(640);
        primaryStage.setHeight(610);
        GerenciadorTelas.getInstance().setPrimaryStage(primaryStage);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}