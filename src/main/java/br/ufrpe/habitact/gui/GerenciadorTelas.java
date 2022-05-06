package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GerenciadorTelas {

    private static GerenciadorTelas instance;
    private Stage primaryStage;
    private Scene cadastroScene;
    private Scene principalScene;
    private Scene loginScene;
    private TelaDeCadastroControlador cadastro;
    private TelaDeLoginControlador login;
    private TelaPrincipalDoClienteControlador principal;

    private GerenciadorTelas(){
        this.initialize();
    }

    public static GerenciadorTelas getInstance() {
        if (instance == null) {
            instance = new GerenciadorTelas();
        }
        return instance;
    }

    private void initialize() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        //Parent mainPane = null;
        try {
            fxmlLoader = new FXMLLoader(HelloApplication.class.
                    getResource("TelaDeLogin.fxml"));
            this.loginScene = new Scene(fxmlLoader.load());
            this.login = (TelaDeLoginControlador) fxmlLoader.getController();

            //fxmlLoader = new FXMLLoader();
            //fxmlLoader = new FXMLLoader(HelloApplication.class.
            //        getResource("TelaDeCadastro.fxml"));
            //this.cadastroScene = new Scene(fxmlLoader.load());
            //this.cadastro = (TelaDeCadastroControlador) fxmlLoader.getController();

            //fxmlLoader = new FXMLLoader();
            //fxmlLoader = new FXMLLoader(HelloApplication.class.
            //       getResource("TelaPrincipalDoCliente.fxml"));
            //this.principalScene = new Scene(fxmlLoader.load());
            //this.principal = (TelaPrincipalDoClienteControlador) fxmlLoader.getController();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Scene getCadastroScene() {
        return cadastroScene;
    }

    public Scene getLoginScene() {
        return loginScene;
    }

    public Scene getPrincipalScene() {
        return principalScene;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public TelaPrincipalDoClienteControlador getTelaDoCliente() {
        return principal;
    }

    public TelaDeCadastroControlador getCadastro() {
        return cadastro;
    }

    public TelaDeLoginControlador getLogin() {
        return login;
    }
}
