package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.negocio.beans.Exercicio;
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
    @FXML private TextField textRepeticao;
    @FXML private TextField textSerie;
    @FXML private TextField textOutro;
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

            Exercicio ex = new Exercicio(selectExercicio.getValue(), selectRitmo.getValue(), Integer.parseInt(textMinutos.getText()),
                    Integer.parseInt(textRepeticao.getText()),Integer.parseInt(textSerie.getText()));

            //TODO Add a Fachada para inserir o Exercicio e o try/catch
            this.limparCamposDeDados();
            //Para fechar a tela
            ((Stage)this.btnCancelarSalvarPressed.getScene().getWindow()).close();
        }
    }

    private void limparCamposDeDados() {
        this.textOutro.setText("");
        this.textMinutos.setText("");
        this.textRepeticao.setText("");
        this.textSerie.setText("");
        this.selectExercicio.getSelectionModel().clearSelection();
        this.selectRitmo.getSelectionModel().clearSelection();
    }

    private boolean verificarCamposVazios() {
        return selectExercicio.getValue() == null || selectRitmo.getValue() == null ||
                textOutro.getText().isBlank() || textMinutos.getText().isBlank();
    }
}

