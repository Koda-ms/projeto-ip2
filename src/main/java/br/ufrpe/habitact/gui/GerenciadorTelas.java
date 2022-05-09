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
    private Scene principalAdmScene;
    private TelaAdmController admController;
    private Scene meusDadosScene;
    private TelaInformacaoPessoalClienteController informacaoPessoalClienteController;
    private Scene informacoesPessoaisScene;
    private TelaDeInformacoesPessoaisAdmController informacoesPessoaisController;

    private Scene listaDeClientesScene;
    private TelaDeListarClientesController listarClientesController;

    private Scene listarDadosScene;
    private TelaDeListarDadosController listarDadosController;
    private Scene cadastroScene;
    private Scene principalScene;
    private Scene loginScene;
    private TelaDeCadastroControlador cadastro;
    private TelaDeLoginControlador login;
    private TelaPrincipalDoClienteControlador principal;
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
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TelaDeInformacoesPessoais.fxml"));
            this.informacoesPessoaisScene = new Scene(fxmlLoader.load());
            this.informacoesPessoaisController = (TelaDeInformacoesPessoaisAdmController) fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            fxmlLoader = new FXMLLoader(HelloApplication.class.
                    getResource("TelaDeListarClientes.fxml"));
            this.listaDeClientesScene = new Scene(fxmlLoader.load());
            this.listarClientesController = (TelaDeListarClientesController) fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            fxmlLoader = new FXMLLoader(HelloApplication.class.
                    getResource("TelaAdm.fxml"));
            this.principalAdmScene = new Scene(fxmlLoader.load());
            this.admController = (TelaAdmController) fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            fxmlLoader = new FXMLLoader(HelloApplication.class.
                    getResource("TelaInformacaoPessoal.fxml"));
            this.meusDadosScene = new Scene(fxmlLoader.load());
            this.informacaoPessoalClienteController = (TelaInformacaoPessoalClienteController) fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            fxmlLoader = new FXMLLoader(HelloApplication.class.
                    getResource("TelaDeListarDados.fxml"));
            this.listarDadosScene = new Scene(fxmlLoader.load());
            this.listarDadosController = (TelaDeListarDadosController) fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            fxmlLoader = new FXMLLoader(HelloApplication.class.
                    getResource("TelaDeLogin.fxml"));
            this.loginScene = new Scene(fxmlLoader.load());
            this.login = (TelaDeLoginControlador) fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            fxmlLoader = new FXMLLoader(HelloApplication.class.
                    getResource("TelaDeCadastro.fxml"));
            this.cadastroScene = new Scene(fxmlLoader.load());
            this.cadastro = (TelaDeCadastroControlador) fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            fxmlLoader = new FXMLLoader(HelloApplication.class.
                   getResource("TelaPrincipalDoCliente.fxml"));
            this.principalScene = new Scene(fxmlLoader.load());
            this.principal = (TelaPrincipalDoClienteControlador) fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
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
   /*public void trocarTela(String tela){
        FXMLLoader fxmlLoader = new FXMLLoader();

        switch (tela){

            case "telaCadastrarPlano": primaryStage.setScene(planoTreinoScene); break;
        }
    }*/


    public Scene getCadastroScene() {
        return cadastroScene;
    }

    public Scene getLoginScene() {
        return loginScene;
    }

    public Scene getPrincipalScene() {
        return principalScene;
    }


    public void alertaCamposVazios(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro no Cadastro");
        alert.setHeaderText("Campo vazio");
        alert.setContentText("Verifique o(s) campo(s) vazio(s) do seu cadastro");
        alert.showAndWait();
    }

    public Scene getInformacoesPessoaisScene() {
        return informacoesPessoaisScene;
    }

    public TelaDeInformacoesPessoaisAdmController getInformacoesPessoaisController() {
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

    public TelaPrincipalDoClienteControlador getTelaDoCliente() {
        return principal;
    }

    public TelaDeCadastroControlador getCadastro() {
        return cadastro;
    }

    public TelaDeLoginControlador getLogin() {
        return login;
    }

    public void trocarTela(String tela){
        switch(tela){
            case "TelaDeInformacoesPessoais": primaryStage.setScene(informacoesPessoaisScene); break;
            case "TelaDeListarClientes": primaryStage.setScene(listaDeClientesScene); break;
            case "TelaDeListarDados": primaryStage.setScene(listarDadosScene); break;
            case "telaPrincipalAdm": primaryStage.setScene(principalAdmScene);
            case "TelaDeLogin": primaryStage.setScene(loginScene); break;
            case "TelaDeCadastro": primaryStage.setScene(cadastroScene); break;
            case "TelaPrincipalDoCliente": primaryStage.setScene(principalScene); break;
            case "popupPlanos": primaryStage.setScene(popupScene); break;
            case "planoAlimentar": primaryStage.setScene(planoAlimentarScene);break;
            case "planoTreino": primaryStage.setScene(planoTreinoScene); break;
            case "MeusDadosTela": primaryStage.setScene(meusDadosScene); break;
        }
    }

    public Scene getPrincipalAdmScene() {
        return principalAdmScene;
    }

    public TelaAdmController getAdmController() {
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

    public TelaPrincipalDoClienteControlador getPrincipal() {
        return principal;
    }

    public Scene getMeusDadosScene() {
        return meusDadosScene;
    }

    public TelaInformacaoPessoalClienteController getInformacaoPessoalClienteController() {
        return informacaoPessoalClienteController;
    }
}

