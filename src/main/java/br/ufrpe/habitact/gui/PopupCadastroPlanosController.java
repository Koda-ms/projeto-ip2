package br.ufrpe.habitact.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class PopupCadastroPlanosController {

    @FXML
    private ComboBox<String> combo;

    @FXML
    private void initialize(){
        ObservableList<String> listaEscolha =
                FXCollections.observableArrayList("Plano Alimentar", "Plano de Treino");
        combo.setItems(listaEscolha);
    }

    @FXML
    void btnOkPressed(ActionEvent event) {
        //TODO direcionar o botão para a próxima tela escolhida pelo usuário: Plano Alimentar ou Plano de Treino
        if(combo.getValue().equalsIgnoreCase("Plano Alimentar")){
            GerenciadorTelas.getInstance().getCadastroPlanoAlimentarController().initialize();
        }
    }
}
