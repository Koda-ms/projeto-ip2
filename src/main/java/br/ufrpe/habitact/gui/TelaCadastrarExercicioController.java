package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.Exercicio;
import br.ufrpe.habitact.negocio.beans.enums.RitmoDoExercicio;
import br.ufrpe.habitact.negocio.beans.enums.TipoExercicio;
import br.ufrpe.habitact.sessao.Sessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TelaCadastrarExercicioController {

    @FXML private TextField textRepeticao;
    @FXML private TextField textSerie;
    @FXML private TextField textMinutos;
    @FXML private Button btnCancelarSalvarPressed;
    @FXML private ComboBox<TipoExercicio> selectExercicio;
    @FXML private ComboBox<RitmoDoExercicio> selectRitmo;

    public void initialize(){
        this.selectExercicio.getItems().addAll(TipoExercicio.values());
        this.selectRitmo.getItems().addAll(RitmoDoExercicio.values());
    }

    @FXML void btnSalvarPressed(ActionEvent event) {

        if (verificarCamposVazios()) {
            GerenciadorTelas.getInstance().alertaCamposVazios();
        } else{
            Exercicio ex = new Exercicio(selectExercicio.getValue(), selectRitmo.getValue(), Integer.parseInt(textMinutos.getText()),
                    Integer.parseInt(textRepeticao.getText()),Integer.parseInt(textSerie.getText()));
            Sessao.getInstance().setExercicio(ex);

            try {
                Fachada.getInstance().inserirExercicios(ex);
                Fachada.getInstance().inserirExercicioNoTreino(Sessao.getInstance().getTreino(), ex);
            } catch (ObjetoDuplicadoException | ObjetoNaoExisteException e) {
                e.getMessage();
            }

            this.limparCamposDeDados();
            ((Stage)this.btnCancelarSalvarPressed.getScene().getWindow()).close();
            GerenciadorTelas.getInstance().updateTabelaExercicios();
        }
    }

    private void limparCamposDeDados() {
        this.textMinutos.setText("");
        this.textRepeticao.setText("");
        this.textSerie.setText("");
        this.selectExercicio.getSelectionModel().clearSelection();
        this.selectRitmo.getSelectionModel().clearSelection();
    }

    private boolean verificarCamposVazios() {
        return selectExercicio.getValue() == null || selectRitmo.getValue() == null ||
                textMinutos.getText().isBlank();
    }
}

