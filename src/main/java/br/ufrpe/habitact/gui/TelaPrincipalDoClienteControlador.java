package br.ufrpe.habitact.gui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TelaPrincipalDoClienteControlador extends Application {
    @FXML AnchorPane root;
    @FXML HBox botoes;
    @FXML TabPane objetivosEAlimentacao;
    @FXML Tab objetivos;
    @FXML Tab alimentacao;
    @FXML AnchorPane containerDiasObjetivos;
    @FXML Tab segundaObjetivos;
    @FXML Tab tercaObjetivos;
    @FXML Tab quartaObjetivos;
    @FXML Tab quintaObjetivos;
    @FXML Tab sextaObjetivos;
    @FXML Tab sabadoObjetivos;
    @FXML Tab domingoObjetivos;
    @FXML AnchorPane containerDiasAlimentacao;
    @FXML Tab segundaAlimentacao;
    @FXML Tab tercaAlimentacao;
    @FXML Tab quartaAlimentacao;
    @FXML Tab quintaAlimentacao;
    @FXML Tab sextaAlimentacao;
    @FXML Tab sabadoAlimentacao;
    @FXML Tab domingoAlimentacao;
    @FXML Button sairBtn;
    @FXML Button objetivosBtn;
    @FXML Button cadastrarPlanoBtn;
    @FXML Button informacoesUsuarioBtn;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }
}
