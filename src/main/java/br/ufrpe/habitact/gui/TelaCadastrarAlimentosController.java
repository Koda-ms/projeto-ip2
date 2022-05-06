package br.ufrpe.habitact.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaCadastrarAlimentosController {

    @FXML private TextField textCalorias;
    @FXML private TextField textNome;
    @FXML private TextField textQuantidade;
    @FXML private Button btnCancelarSalvarPressed;

    @FXML
    void btnSalvarPressed(ActionEvent event) {
        ((Stage)this.btnCancelarSalvarPressed.getScene().getWindow()).close();
    }

}

