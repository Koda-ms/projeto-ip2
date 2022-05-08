package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.gui.modelos.ModeloTreino;
import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.Exercicio;
import br.ufrpe.habitact.negocio.beans.Treino;
import br.ufrpe.habitact.negocio.beans.enums.CategoriaTreino;
import br.ufrpe.habitact.negocio.beans.enums.RitmoDoExercicio;
import br.ufrpe.habitact.negocio.beans.enums.TipoExercicio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TelaCadastrarTreinoController {

    @FXML private Button btnCancelarSalvarPressed;
    @FXML private ComboBox<CategoriaTreino> optCategoria;

    @FXML private TableView<ModeloTreino> tblExercicio;
    @FXML private TableColumn<ModeloTreino, Boolean> colunaCheck;
    @FXML private TableColumn<ModeloTreino, String> colunaNomeExercicio;
    @FXML private TableColumn<ModeloTreino, String> colunaRitmo;
    @FXML private TableColumn<ModeloTreino, Double> colunaCalorias; //Atributo que aparecerá na TableView da tela CadastrarPlanoTreio

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
            Treino t = new Treino((ArrayList<Exercicio>) Fachada.getInstance().listarExercicios(), optCategoria.getValue());

            try {
                Fachada.getInstance().inserirTreino(t);
            } catch (ObjetoDuplicadoException e) {
                e.getMessage();
            }
            this.limparCamposDeDados();
            ((Stage)this.btnCancelarSalvarPressed.getScene().getWindow()).close();
        }

    }

    private void updateCatalogoExercicios(){
        //Instancia exercícios para o Controlador de Exercício
        ArrayList<Exercicio> listaExercicios = new ArrayList<>();
        Exercicio ex1 = new Exercicio(TipoExercicio.CAMINHADA, RitmoDoExercicio.BAIXO, 10, 3, 2);
        Exercicio ex2 = new Exercicio(TipoExercicio.CORRIDA, RitmoDoExercicio.MEDIO, 60, 1, 1);
        Exercicio ex3 = new Exercicio(TipoExercicio.JIU_JITSU, RitmoDoExercicio.ALTO, 15, 2, 3);
        //Add o exercícios ao ControladorExercicio
        try {
            Fachada.getInstance().inserirExercicios(ex1);
            Fachada.getInstance().inserirExercicios(ex2);
            Fachada.getInstance().inserirExercicios(ex3);
        } catch (ObjetoDuplicadoException e) {
            e.printStackTrace();
        }
        //Lista os exercícios adicionados na tabela Catálogo de Exercícios
        ObservableList<ModeloTreino> result = FXCollections.observableArrayList();
        List<Exercicio> listaExerc = Fachada.getInstance().listarExercicios();
        for (Exercicio ex : listaExerc){
            result.add(new ModeloTreino(ex));
        }
        tblExercicio.setItems(result);
    }

    private void limparCamposDeDados() {
        this.optCategoria.getSelectionModel().clearSelection();
        this.tblExercicio.getSelectionModel().clearSelection();
    }

    private boolean verificarCamposVazios() {
        return optCategoria.getValue() == null;
    }

}

