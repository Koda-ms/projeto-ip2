package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.Alimento;
import br.ufrpe.habitact.negocio.beans.PlanoAlimentar;
import br.ufrpe.habitact.negocio.beans.enums.Refeicao;
import br.ufrpe.habitact.sessao.Sessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class TelaCadastrarAlimentosController {

    @FXML private TextField textCalorias;
    @FXML private TextField textNome;
    @FXML private TextField textQuantidade;
    @FXML private ComboBox<Refeicao> selectRefeicao;
    @FXML private Button btnCancelarSalvarPressed;

    public void initialize(){
        selectRefeicao.getItems().addAll(Refeicao.values());
    }

    @FXML
    void btnSalvarPressed(ActionEvent event) throws ObjetoDuplicadoException {
        if (verificarCamposVazios()) {
            GerenciadorTelas.getInstance().alertaCamposVazios();
        } else{
            Alimento alimento = new Alimento(selectRefeicao.getValue(), textNome.getText(),
                    Double.parseDouble(textQuantidade.getText()), Double.parseDouble(textCalorias.getText()));

            Fachada.getInstance().adicionarAlimento(alimento);
            try {
                Fachada.getInstance().inserirAlimentoNoPlano(Sessao.getInstance().getPlanoAlimentar(), alimento);
            } catch (ObjetoNaoExisteException e) {
               this.alertaErroCadastro(e.getMessage());
            }

            this.limparCamposDeDados();
            ((Stage)this.btnCancelarSalvarPressed.getScene().getWindow()).close();
            GerenciadorTelas.getInstance().updateTabelaAlimentos();
        }
    }

    private void alertaErroCadastro(String motivo){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Erro de cadastro");
        alerta.setHeaderText("Há um possível erro com seu cadastro");
        alerta.setContentText(motivo);
        alerta.showAndWait();
    }

    private void limparCamposDeDados() {
        this.textNome.setText("");
        this.textCalorias.setText("");
        this.textQuantidade.setText("");
        this.selectRefeicao.getSelectionModel().clearSelection();
    }

    private boolean verificarCamposVazios() {
        return textNome.getText().isBlank() || textQuantidade.getText().isBlank() &&
                textCalorias.getText().isBlank();
    }
}

