package br.ufrpe.habitact.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class PopupCadastroPlanosController {

    @FXML private ComboBox<String> combo;
    @FXML private Button btnCancelarOkPressed;

    @FXML
    private void initialize(){
        ObservableList<String> listaEscolha =
                FXCollections.observableArrayList("Plano Alimentar", "Plano de Treino");
        combo.setItems(listaEscolha);
    }

    @FXML
    void btnOKPressed(ActionEvent event) {
        if(combo.getValue().equalsIgnoreCase("Plano Alimentar")){
            GerenciadorTelas.getInstance().trocarTela("planoAlimentar");
        } else{
            GerenciadorTelas.getInstance().trocarTela("planoTreino");
        }
        this.limparCamposDeDados();
        ((Stage)this.btnCancelarOkPressed.getScene().getWindow()).close();
    }

    private void limparCamposDeDados() {
        this.combo.getSelectionModel().clearSelection();
    }
}
