package br.ufrpe.habitact.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class TelaPrincipalDoClienteControlador {

    @FXML
    private Circle SabadoCircle;

    @FXML
    private Circle domingoCircle;

    @FXML
    private Label domingoLabel;

    @FXML
    private Button meusDadosBtn;

    @FXML
    private Label objetivosDaSemanaLabel;

    @FXML
    private Circle quartaCircle;

    @FXML
    private Label quartaLabel;

    @FXML
    private Circle quintaCircle;

    @FXML
    private Label quintaLabel;

    @FXML
    private Pane root;

    @FXML
    private Label sabadoLabel;

    @FXML
    private Button sairBtn;

    @FXML
    private Circle segundaCircle;

    @FXML
    private Label segundaLabel;

    @FXML
    private Circle sextaCircle;

    @FXML
    private Label sextaLabel;

    @FXML
    private Circle tercaCircle;

    @FXML
    private Label tercaLabel;

    @FXML private void btnSair(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("TelaDeLogin");
    }

    @FXML private void detalhesObjetivos(MouseEvent event) {
        
    }

    @FXML private void MeusDadosBtn(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("MeusDadosTela");
    }
}
