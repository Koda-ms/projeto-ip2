package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.Main;
import br.ufrpe.habitact.gui.modelos.ModeloExercicioCliente;
import br.ufrpe.habitact.negocio.beans.Exercicio;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
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
            case "telaPrincipalAdm": setPrincipalAdmScene(); break;
            case "TelaPrincipalCliente": setPrincipalClienteScene(); break;
            case "planoAlimentar": setPlanoAlimentarScene(); break;
            case "planoTreino": setPlanoTreinoScene(); break;
            case "TelaCadastroTreino": setAddTreinoScene(); break;
        }
    }

    public void setInfoPessoalAdmScene(){
        infoPessoalAdmController.setInformacoes();
        primaryStage.setScene(infoPessoalAdmScene);
    }

    public void setInfoPessoalClienteScene(){
        infoPessoalClienteController.setInformacoes();
        primaryStage.setScene(dadosClienteScene);
    }

    public void updateTabelaAlimentos(){
        cadastroPlanoAlimentarController.updateCatalogoAlimentos();
    }
    public void updateTabelaExercicios(){cadastrarTreinoController.updateCatalogoExercicios();}
    public void updateTabelaTreinos(){cadastroPlanoTreinoController.updateCatalogoTreino();}
    public void updateComboBoxClientes(){
        cadastroPlanoTreinoController.addClientesComboBoxPTreino();
        cadastroPlanoAlimentarController.addClientesComboBoxPAlimentar();
    }
    public void updateTabelaRefeicao(){
        principalCliente.updateTabelaRefeicao();
    }

    public void alertaCamposVazios(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro no Cadastro");
        alert.setHeaderText("Campo vazio");
        alert.setContentText("Verifique o(s) campo(s) vazio(s) do seu cadastro");
        alert.showAndWait();
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

    public void setPrincipalClienteScene() {
        principalCliente.updateTabelaRefeicao();
        principalCliente.updateTabelaExercicioAnaerobico();
        principalCliente.updateTabelaExercicioAerobico();
        principalCliente.setInformacoes();
        primaryStage.setScene(principalClienteScene);
    }

    public Scene getInfoPessoalAdmScene() {
        return infoPessoalAdmScene;
    }

    public TelaInfoPessoalAdmController getInfoPessoalAdmController() {
        return infoPessoalAdmController;
    }

    public Scene getPopupScene() {
        return popupScene;
    }

    public Scene getPlanoAlimentarScene() {
        return planoAlimentarScene;
    }

    public void setPlanoAlimentarScene() {
        cadastroPlanoAlimentarController.addClientesComboBoxPAlimentar();
        cadastroPlanoAlimentarController.updateCatalogoAlimentos();
        cadastroPlanoAlimentarController.events();
        primaryStage.setScene(planoAlimentarScene);
    }

    public Scene getAddAlimentoScene() { return addAlimentoScene; }

    public Scene getPlanoTreinoScene() {
        return planoTreinoScene;
    }

    public void setPlanoTreinoScene() {
        cadastroPlanoTreinoController.addClientesComboBoxPTreino();
        cadastroPlanoTreinoController.updateCatalogoTreino();
        primaryStage.setScene(planoTreinoScene);
    }

    public Scene getAddTreinoScene() {
        return addTreinoScene;
    }

    public void setAddTreinoScene() {
        cadastrarTreinoController.updateCatalogoExercicios();
        primaryStage.setScene(addTreinoScene);
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

    public void setPrincipalAdmScene(){
        admController.updateListaClientes();
        admController.updateListaPlanoAlimentar();
        admController.updateListaPlanoTreino();
        primaryStage.setScene(principalAdmScene);
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

