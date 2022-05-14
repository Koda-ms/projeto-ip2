package br.ufrpe.habitact.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class TelaPrincipalClienteController {

    @FXML private Circle segundaCircle;
    @FXML private Circle tercaCircle;
    @FXML private Circle quartaCircle;
    @FXML private Circle quintaCircle;
    @FXML private Circle sextaCircle;
    @FXML private Circle SabadoCircle;
    @FXML private Circle domingoCircle;
    @FXML private Label segundaLabel;
    @FXML private Label tercaLabel;
    @FXML private Label quartaLabel;
    @FXML private Label quintaLabel;
    @FXML private Label sextaLabel;
    @FXML private Label sabadoLabel;
    @FXML private Label domingoLabel;
    @FXML private Label objetivosDaSemanaLabel;

    @FXML private void btnSair(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("TelaLogin");
    }

    @FXML private void detalhesObjetivos(MouseEvent event) {
        //TODO exibir os objetivos na tela
    }

    @FXML private void btnMeusDados(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("TelaDadosCliente");
    }

    @FXML
    void btnListarPLanosPressed(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("TelaListarPlanos");
    }
}
