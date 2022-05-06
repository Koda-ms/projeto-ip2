package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GerenciadorTelas {

    private static GerenciadorTelas instance;
    private Stage primaryStage;
    private Scene planoAlimentarScene;
    private TelaCadastroPlanoAlimentarController cadastroPlanoAlimentarController;
    private Scene popupScene;
    private PopupCadastroPlanosController cadastroPlanosController;
    private Scene addAlimentoScene;
    private TelaCadastrarAlimentosController cadastrarAlimentosController;
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
                    getResource("PopupCadastroPlanos.fxml"));
            this.popupScene = new Scene(fxmlLoader.load());
            this.cadastroPlanosController = (PopupCadastroPlanosController) fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            fxmlLoader = new FXMLLoader(HelloApplication.class.
                    getResource("TelaCadastroPlanoAlimentar.fxml"));
            this.planoAlimentarScene = new Scene(fxmlLoader.load());
            this.cadastroPlanoAlimentarController = (TelaCadastroPlanoAlimentarController) fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            fxmlLoader = new FXMLLoader(HelloApplication.class.
                    getResource("TelaCadastrarAlimentos.fxml"));
            this.addAlimentoScene = new Scene(fxmlLoader.load());
            this.cadastrarAlimentosController = (TelaCadastrarAlimentosController) fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void trocarTela(String tela){
        FXMLLoader fxmlLoader = new FXMLLoader();
        if (tela.equalsIgnoreCase("planoAlimentar")){
            primaryStage.setScene(planoAlimentarScene);
        }
    }

    public Scene getAddAlimentoScene() { return addAlimentoScene; }

    public Scene getPlanoAlimentarScene() {
        return planoAlimentarScene;
    }

    public Scene getPopupScene() {
        return popupScene;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public TelaCadastroPlanoAlimentarController getCadastroPlanoAlimentarController() {
        return cadastroPlanoAlimentarController;
    }

    public PopupCadastroPlanosController getCadastroPlanosController() {
        return cadastroPlanosController;
    }

    public TelaCadastrarAlimentosController getCadastrarAlimentosController() {
        return cadastrarAlimentosController;
    }
}
