package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.negocio.beans.enums.CategoriaTreino;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TelaCadastrarTreinoController {

    @FXML private Button btnCancelarSalvarPressed;
    @FXML private TableColumn<?, ?> nomeExercicio;
    @FXML private TableColumn<?, ?> ritmo;
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
            ((Stage)this.btnCancelarSalvarPressed.getScene().getWindow()).close();
        }

    }

    private boolean verificarCamposVazios() {
        return optCategoria.getValue() == null;
    }

}

