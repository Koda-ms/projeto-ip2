package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.excecoes.MaisDeUmTreinoNoMesmoDiaException;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.gui.modelos.ModeloTreino;
import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.Exercicio;
import br.ufrpe.habitact.negocio.beans.Treino;
import br.ufrpe.habitact.negocio.beans.enums.CategoriaTreino;
import br.ufrpe.habitact.negocio.beans.enums.RitmoDoExercicio;
import br.ufrpe.habitact.negocio.beans.enums.TipoExercicio;
import br.ufrpe.habitact.sessao.Sessao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TelaCadastrarTreinoController {
    @FXML private DatePicker dtTreino;
    @FXML private Button btnNovoExercicio;
    @FXML private RadioButton radAddExercicio;
    @FXML private Button btnCancelarSalvarPressed;
    @FXML private ComboBox<CategoriaTreino> optCategoria;
    @FXML private TableView<ModeloTreino> tblExercicio;
    @FXML private TableColumn<ModeloTreino, Boolean> colunaCheck;
    @FXML private TableColumn<ModeloTreino, String> colunaNomeExercicio;
    @FXML private TableColumn<ModeloTreino, String> colunaRitmo;

    public void initialize(){
        //Add valores ao ComboBox
        this.optCategoria.getItems().addAll(CategoriaTreino.values());
        //Setando as colunas da TableView
        this.colunaCheck.setCellValueFactory(new PropertyValueFactory<>("check"));
        this.colunaCheck.setCellFactory(CheckBoxTableCell.forTableColumn(colunaCheck));
        this.colunaNomeExercicio.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.colunaRitmo.setCellValueFactory(new PropertyValueFactory<>("ritmo"));
        this.updateCatalogoExercicios();
    }

    @FXML
    void optRadioClicked(MouseEvent event) {
        Treino t = new Treino(Fachada.getInstance().listarExercicios(), optCategoria.getValue(), dtTreino.getValue());
        Sessao.getInstance().setTreino(t);

        try {
            Fachada.getInstance().inserirTreino(t);
            Fachada.getInstance().inserirTreinoNoPlano(Sessao.getInstance().getPlanoTreino(), t);
        } catch (ObjetoDuplicadoException | MaisDeUmTreinoNoMesmoDiaException | ObjetoNaoExisteException e) {
            e.getMessage();
        }
        this.tblExercicio.setDisable(false);
        this.btnNovoExercicio.setDisable(false);
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
            this.limparCamposDeDados();
            GerenciadorTelas.getInstance().updateTabelaTreinos();
            GerenciadorTelas.getInstance().trocarTela("planoTreino");
        }
    }

    //Lista os exercícios adicionados na tabela Catálogo de Exercícios
    public void updateCatalogoExercicios(){

        ObservableList<ModeloTreino> result = FXCollections.observableArrayList();
        List<Exercicio> listaExerc = Fachada.getInstance().listarExercicios();
        for (Exercicio ex : listaExerc){
            result.add(new ModeloTreino(ex));
        }
        tblExercicio.setItems(result);
    }

    @FXML
    void btnVoltarPressed(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("planoTreino");
    }

    private void limparCamposDeDados() {
        this.dtTreino.setValue(null);
        this.tblExercicio.getItems().clear();
        this.radAddExercicio.setSelected(false);
        this.optCategoria.getSelectionModel().clearSelection();
        this.tblExercicio.getSelectionModel().clearSelection();
    }

    private boolean verificarCamposVazios() {
        return optCategoria.getValue() == null;
    }

}

