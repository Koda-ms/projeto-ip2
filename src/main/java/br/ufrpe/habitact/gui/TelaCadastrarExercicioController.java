package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.negocio.beans.enums.RitmoDoExercicio;
import br.ufrpe.habitact.negocio.beans.enums.TipoExercicio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaCadastrarExercicioController {

    @FXML private Button btnCancelarSalvarPressed;
    @FXML private ComboBox<TipoExercicio> selectExercicio;
    @FXML private ComboBox<RitmoDoExercicio> selectRitmo;
    @FXML private TextField textOutro;
    @FXML private TextField textHora;
    @FXML private TextField textMinutos;

    public void initialize(){
        this.selectExercicio.getItems().addAll(TipoExercicio.values());
        this.selectRitmo.getItems().addAll(RitmoDoExercicio.values());

    }

    @FXML
    void optOutrosSelecionado(ActionEvent event) {
        if (selectExercicio.getValue().getNome().equalsIgnoreCase("")){
            this.textOutro.setDisable(false);
        }
    }

    @FXML void btnSalvarPressed(ActionEvent event) {
        if (verificarCamposVazios()) {
            GerenciadorTelas.getInstance().alertaCamposVazios();
        } else{
            //TODO Configurar parte para armazenar os exercícios cadastrados pelo usuário
            ((Stage)this.btnCancelarSalvarPressed.getScene().getWindow()).close();
        }
    }

    private boolean verificarCamposVazios() {
        return selectExercicio.getValue() == null || selectRitmo.getValue() == null ||
                textOutro.getText().isBlank() || textHora.getText().isBlank() &&
                textMinutos.getText().isBlank();
    }

}

