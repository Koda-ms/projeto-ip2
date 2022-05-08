package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.Exercicio;
import br.ufrpe.habitact.negocio.beans.Treino;
import br.ufrpe.habitact.negocio.beans.enums.CategoriaTreino;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TelaCadastrarTreinoController {

    @FXML private Button btnCancelarSalvarPressed;
    @FXML private TableView<Exercicio> tblExercicio;
    @FXML private TableColumn<?, ?> nomeExercicio;
    @FXML private TableColumn<?, ?> ritmo;
    @FXML private TableColumn<?, ?> calQueimadas;
    @FXML private TextField textDuracao;
    @FXML private ComboBox<CategoriaTreino> optCategoria;

    public void initialize(){
        optCategoria.getItems().addAll(CategoriaTreino.values());
    }

    @FXML
    void btnAddExercicioPressed(ActionEvent event) {
        Stage dialog = new Stage();
        dialog.setScene(GerenciadorTelas.getInstance().getAddExercicioScene());
        dialog.setResizable(false);
        dialog.setTitle("Cadastrar Exercício");
        dialog.initOwner(((Node) event.getSource()).getScene().getWindow());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();
    }

    @FXML
    void btnSalvarPressed(ActionEvent event) {
        if (verificarCamposVazios()) {
            GerenciadorTelas.getInstance().alertaCamposVazios();
        } else{
            //TODO Configurar parte para armazenar os treinos cadastrados pelo usuário
            Treino t = new Treino((ArrayList<Exercicio>) tblExercicio.getItems(), optCategoria.getValue());

            try {
                Fachada.getInstance().inserirTreino(t);
                //Fachada.getInstance().inserirTreinoNoPlano();
            } catch (ObjetoDuplicadoException e) {
                throw new RuntimeException(e);
            }
            this.limparCamposDeDados();
            ((Stage)this.btnCancelarSalvarPressed.getScene().getWindow()).close();
        }

    }

    private void limparCamposDeDados() {
        this.textDuracao.setText("");
        this.optCategoria.getSelectionModel().clearSelection();
        this.tblExercicio.getSelectionModel().clearSelection();
    }

    private boolean verificarCamposVazios() {
        return optCategoria.getValue() == null;
    }

}

