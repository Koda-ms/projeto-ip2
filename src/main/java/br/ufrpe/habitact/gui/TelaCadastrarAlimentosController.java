package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.Alimento;
import br.ufrpe.habitact.negocio.beans.enums.Refeicao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
            //TODO Configurar parte para armazenar os alimentos cadastrados pelo usuário
            Alimento alimento = new Alimento(selectRefeicao.getValue(), textNome.getText(),
                    Double.parseDouble(textQuantidade.getText()), Double.parseDouble(textCalorias.getText()));
            Fachada.getInstance().adicionarAlimento(alimento);
            //this.planoAlimentarController.updateCatalogoAlimentos(Fachada.getInstance().listarAlimento()); //O atributo retorna null
            this.limparCamposDeDados();
            ((Stage)this.btnCancelarSalvarPressed.getScene().getWindow()).close();
        }
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

