package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class GerenciadorTelas {
    private static GerenciadorTelas instance;
    private Stage primaryStage;

    private Scene principalAdmScene;
    private TelaPrincipalAdmController admController;

    private Scene dadosClienteScene;
    private TelaInfoPessoalClienteController infoPessoalClienteController;

    private Scene infoPessoalAdmScene;
    private TelaInfoPessoalAdmController infoPessoalAdmController;

    private Scene listarPlanosScene;
    private TelaListarPlanosController listarPlanosController;

    private Scene cadastroScene;
    private TelaCadastroUsuarioController cadastro;

    private Scene principalClienteScene;
    private TelaPrincipalClienteController principalCliente;

    private Scene loginScene;
    private TelaLoginController login;

    private Scene popupScene;
    private PopupCadastroPlanosController cadastroPlanosController;

    private Scene planoAlimentarScene;
    private TelaCadastroPlanoAlimentarController cadastroPlanoAlimentarController;

    private Scene addAlimentoScene;
    private TelaCadastrarAlimentosController cadastrarAlimentosController;

    private Scene planoTreinoScene;
    private TelaCadastroPlanoTreinoController cadastroPlanoTreinoController;

    private Scene addTreinoScene;
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
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader = new FXMLLoader(Main.class.getResource("TelaInfoPessoalAdm.fxml"));
            this.infoPessoalAdmScene = new Scene(fxmlLoader.load());
            this.infoPessoalAdmController = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(Main.class.
                    getResource("TelaPrincipalAdm.fxml"));
            this.principalAdmScene = new Scene(fxmlLoader.load());
            this.admController = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(Main.class.
                    getResource("TelaInfoPessoalCliente.fxml"));
            this.dadosClienteScene = new Scene(fxmlLoader.load());
            this.infoPessoalClienteController = fxmlLoader.getController();

//            fxmlLoader = new FXMLLoader(Main.class.
//                    getResource("TelaListarPlanos.fxml"));
//            this.listarPlanosScene = new Scene(fxmlLoader.load());
//            this.listarPlanosController = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(Main.class.
                    getResource("TelaLogin.fxml"));
            this.loginScene = new Scene(fxmlLoader.load());
            this.login = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(Main.class.
                    getResource("TelaCadastroUsuario.fxml"));
            this.cadastroScene = new Scene(fxmlLoader.load());
            this.cadastro = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(Main.class.
                   getResource("TelaPrincipalCliente.fxml"));
            this.principalClienteScene = new Scene(fxmlLoader.load());
            this.principalCliente = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(Main.class.
                    getResource("PopupCadastroPlanos.fxml"));
            this.popupScene = new Scene(fxmlLoader.load());
            this.cadastroPlanosController = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(Main.class.
                    getResource("TelaCadastroPlanoAlimentar.fxml"));
            this.planoAlimentarScene = new Scene(fxmlLoader.load());
            this.cadastroPlanoAlimentarController = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(Main.class.
                    getResource("TelaCadastrarAlimentos.fxml"));
            this.addAlimentoScene = new Scene(fxmlLoader.load());
            this.cadastrarAlimentosController = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(Main.class.
                    getResource("TelaCadastroPlanoTreino.fxml"));
            this.planoTreinoScene = new Scene(fxmlLoader.load());
            this.cadastroPlanoTreinoController = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(Main.class.
                    getResource("TelaCadastrarTreino.fxml"));
            this.addTreinoScene = new Scene(fxmlLoader.load());
            this.cadastrarTreinoController = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(Main.class.
                    getResource("TelaCadastrarExercicio.fxml"));
            this.addExercicioScene = new Scene(fxmlLoader.load());
            this.cadastrarExercicioController = fxmlLoader.getController();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void trocarTela(String tela){
        switch(tela){
            case "TelaLogin": primaryStage.setScene(loginScene); break;
            case "TelaCadastro": primaryStage.setScene(cadastroScene); break;
            case "TelaInfoPessoalAdm": setInfoPessoalAdmScene(); break;
            case "TelaDadosCliente": setInfoPessoalClienteScene(); break;
            case "TelaListarPlanos": primaryStage.setScene(listarPlanosScene); break;
            case "telaPrincipalAdm": setAdmScene(); break;
            case "TelaPrincipalCliente": primaryStage.setScene(principalClienteScene); break;
            case "planoAlimentar": primaryStage.setScene(planoAlimentarScene);break;
            case "planoTreino": primaryStage.setScene(planoTreinoScene); break;
            case "TelaCadastroTreino": primaryStage.setScene(addTreinoScene); break;
        }
    }

    public void alertaCamposVazios(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro no Cadastro");
        alert.setHeaderText("Campo vazio");
        alert.setContentText("Verifique o(s) campo(s) vazio(s)");
        alert.showAndWait();
    }

    public void setAdmScene(){
        admController.updateListaClientes();
        admController.updateListaPlanoAlimentar();
        admController.updateListaPlanoTreino();
        primaryStage.setScene(principalAdmScene);
    }

    public void setInfoPessoalAdmScene(){
        infoPessoalAdmController.setInformacoes();
        primaryStage.setScene(infoPessoalAdmScene);
    }

    public void setInfoPessoalClienteScene(){
        infoPessoalClienteController.setInformacoes();
        primaryStage.setScene(dadosClienteScene);
    }

    public Scene getCadastroScene() {
        return cadastroScene;
    }

    public Scene getLoginScene() {
        return loginScene;
    }

    public Scene getPrincipalClienteScene() {
        return principalClienteScene;
    }

    public Scene getInfoPessoalAdmScene() {
        return infoPessoalAdmScene;
    }

    public TelaInfoPessoalAdmController getInfoPessoalAdmController() {
        return infoPessoalAdmController;
    }

    public Scene getListarPlanosScene() {
        return listarPlanosScene;
    }

    public TelaListarPlanosController getListarPlanosController() {
        return listarPlanosController;
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

    public Scene getAddTreinoScene() {
        return addTreinoScene;
    }

    public Scene getAddExercicioScene() { return addExercicioScene; }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public TelaPrincipalClienteController getTelaDoCliente() {
        return principalCliente;
    }

    public TelaCadastroUsuarioController getCadastro() {
        return cadastro;
    }

    public TelaLoginController getLogin() {
        return login;
    }

    public Scene getPrincipalAdmScene() {
        return principalAdmScene;
    }

    public TelaPrincipalAdmController getAdmController() {
        return admController;
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

    public TelaPrincipalClienteController getPrincipalCliente() {
        return principalCliente;
    }

    public Scene getDadosClienteScene() {
        return dadosClienteScene;
    }

    public TelaInfoPessoalClienteController getInfoPessoalClienteController() {
        return infoPessoalClienteController;
    }
}

