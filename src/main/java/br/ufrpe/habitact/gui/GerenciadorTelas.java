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
    private Scene popupScene;
    private PopupCadastroPlanosController cadastroPlanosController;
    private Scene planoAlimentarScene;
    private TelaCadastroPlanoAlimentarController cadastroPlanoAlimentarController;
    private Scene addAlimentoScene;
    private TelaCadastrarAlimentosController cadastrarAlimentosController;
    private Scene planoTreinoScene;
    private TelaCadastroPlanoTreinoController cadastroPlanoTreinoController;
    private Scene addTreino;
    private TelaCadastrarTreinoController cadastrarTreinoController;
    private Scene addExercicioScene;
    private TelaCadastrarExercicioController cadastrarExercicioController;
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

            fxmlLoader = new FXMLLoader();
            fxmlLoader = new FXMLLoader(HelloApplication.class.
                    getResource("TelaCadastroPlanoTreino.fxml"));
            this.planoTreinoScene = new Scene(fxmlLoader.load());
            this.cadastroPlanoTreinoController = (TelaCadastroPlanoTreinoController) fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            fxmlLoader = new FXMLLoader(HelloApplication.class.
                    getResource("TelaCadastrarTreino.fxml"));
            this.addTreino = new Scene(fxmlLoader.load());
            this.cadastrarTreinoController = (TelaCadastrarTreinoController) fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            fxmlLoader = new FXMLLoader(HelloApplication.class.
                    getResource("TelaCadastrarExercicio.fxml"));
            this.addExercicioScene = new Scene(fxmlLoader.load());
            this.cadastrarExercicioController = (TelaCadastrarExercicioController) fxmlLoader.getController();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //TODO Completar método com todas as telas
    public void trocarTela(String tela){
        FXMLLoader fxmlLoader = new FXMLLoader();

        switch (tela){
            case "popupPlanos": primaryStage.setScene(popupScene); break;
            case "planoAlimentar": primaryStage.setScene(planoAlimentarScene);break;
            case "planoTreino": primaryStage.setScene(planoTreinoScene); break;
        }
    }

    public void alertaCamposVazios(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro no Cadastro");
        alert.setHeaderText("Campo vazio");
        alert.setContentText("Verifique o(s) campo(s) vazio(s) do seu cadastro");
        alert.showAndWait();
    }

    public Scene getPopupScene() {
        return popupScene;
    }

    public Scene getPlanoAlimentarScene() {
        return planoAlimentarScene;
    }

    public Scene getAddAlimentoScene() { return addAlimentoScene; }

    public Scene getPlanoTreinoScene() {
        return planoTreinoScene;
    }

    public Scene getAddTreino() {
        return addTreino;
    }

    public Scene getAddExercicioScene() {
        return addExercicioScene;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public PopupCadastroPlanosController getCadastroPlanosController() {
        return cadastroPlanosController;
    }

    public TelaCadastroPlanoAlimentarController getCadastroPlanoAlimentarController() {
        return cadastroPlanoAlimentarController;
    }

    public TelaCadastrarAlimentosController getCadastrarAlimentosController() {
        return cadastrarAlimentosController;
    }

    public TelaCadastroPlanoTreinoController getCadastroPlanoTreinoController() {
        return cadastroPlanoTreinoController;
    }

    public TelaCadastrarTreinoController getCadastrarTreinoController() {
        return cadastrarTreinoController;
    }

    public TelaCadastrarExercicioController getCadastrarExercicioController() {
        return cadastrarExercicioController;
    }
}
