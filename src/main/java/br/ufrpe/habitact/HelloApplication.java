package br.ufrpe.habitact;

import br.ufrpe.habitact.gui.GerenciadorTelas;
import javafx.application.Application;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage){
        primaryStage.setScene(GerenciadorTelas.getInstance().getPopupScene()); //Esse 'get' deve ser referente à 1ª tela da aplicação,
        primaryStage.setTitle("Projeto HabitAct");                             //ou seja, a de Login

        primaryStage.setWidth(640);
        primaryStage.setHeight(600);

        GerenciadorTelas.getInstance().setPrimaryStage(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}