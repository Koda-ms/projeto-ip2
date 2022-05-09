package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class GerenciadorTelas {
    private static GerenciadorTelas instance;
    private Stage primaryStage;
    private Scene informacoesPessoaisScene;
    private TelaDeInformacoesPessoaisController informacoesPessoaisController;

    private Scene listaDeClientesScene;
    private TelaDeListarClientesController listarClientesController;

    private Scene listarDadosScene;
    private TelaDeListarDadosController listarDadosController;

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
        try {
            fxmlLoader = new FXMLLoader(HelloApplication.class.
                    getResource("TelaDeInformacoesPessoais.fxml"));
            this.informacoesPessoaisScene = new Scene(fxmlLoader.load());
            this.informacoesPessoaisController = (TelaDeInformacoesPessoaisController) fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            fxmlLoader = new FXMLLoader(HelloApplication.class.
                    getResource("TelaDeListarClientes.fxml"));
            this.listaDeClientesScene = new Scene(fxmlLoader.load());
            this.listarClientesController = (TelaDeListarClientesController) fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            fxmlLoader = new FXMLLoader(HelloApplication.class.
                    getResource("TelaDeListarDados.fxml"));
            this.listarDadosScene = new Scene(fxmlLoader.load());
            this.listarDadosController = (TelaDeListarDadosController) fxmlLoader.getController();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //TODO Completar método com todas as telas
   /*public void trocarTela(String tela){
        FXMLLoader fxmlLoader = new FXMLLoader();

        switch (tela){

            case "telaCadastrarPlano": primaryStage.setScene(planoTreinoScene); break;
        }
    }*/

    public void alertaCamposVazios(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro no Cadastro");
        alert.setHeaderText("Campo vazio");
        alert.setContentText("Verifique o(s) campo(s) vazio(s) do seu cadastro");
        alert.showAndWait();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Scene getInformacoesPessoaisScene() {
        return informacoesPessoaisScene;
    }

    public TelaDeInformacoesPessoaisController getInformacoesPessoaisController() {
        return informacoesPessoaisController;
    }

    public Scene getListaDeClientesScene() {
        return listaDeClientesScene;
    }

    public TelaDeListarClientesController getListarClientesController() {
        return listarClientesController;
    }

    public Scene getListarDadosScene() {
        return listarDadosScene;
    }

    public TelaDeListarDadosController getListarDadosController() {
        return listarDadosController;
    }

    public void trocarTela(String tela){
        FXMLLoader fxmlLoader = new FXMLLoader();

        switch (tela){
            case "TelaDeInformacoesPessoais": primaryStage.setScene(informacoesPessoaisScene); break;
            case "TelaDeListarClientes": primaryStage.setScene(listaDeClientesScene); break;
            case "TelaDeListarDados": primaryStage.setScene(listarDadosScene); break;
            //case "telaPrincipalAdm": primaryStage.setScene(principalAdmScene);
        }
    }
}
