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
        if (verificarCamposVazios()) {
            GerenciadorTelas.getInstance().alertaCamposVazios();
        } else{
            //TODO Configurar parte para armazenar os alimentos cadastrados pelo usuário
            ((Stage)this.btnCancelarSalvarPressed.getScene().getWindow()).close();
        }
    }

    private boolean verificarCamposVazios() {
        return textNome.getText().isBlank() || textQuantidade.getText().isBlank() &&
                textCalorias.getText().isBlank();
    }

}

