package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.gui.modelos.ModeloCliente;
import br.ufrpe.habitact.gui.modelos.ModeloPlanoAlimentar;
import br.ufrpe.habitact.gui.modelos.ModeloPlanoTreino;
import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.Cliente;
import br.ufrpe.habitact.negocio.beans.PlanoAlimentar;
import br.ufrpe.habitact.negocio.beans.PlanoTreino;
import br.ufrpe.habitact.negocio.beans.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;

public class TelaPrincipalAdmController {

    @FXML private TableColumn<ModeloPlanoAlimentar, String> colunaClientePlanoAlimentar;
    @FXML private TableColumn<ModeloPlanoAlimentar, String> colunaDtInicioPlanoAlimentar;
    @FXML private TableColumn<ModeloPlanoAlimentar, String> colunaDtFimPlanoAlimentar;
    @FXML private TableView<ModeloPlanoAlimentar> tablePlanosAlimentares;

    @FXML private TableColumn<ModeloPlanoTreino, String> colunaClientePlanoTreino;
    @FXML private TableColumn<ModeloPlanoTreino, String> colunaDtInicioPlanoTreino;
    @FXML private TableColumn<ModeloPlanoTreino, String> colunaDtFimPlanoTreino;
    @FXML private TableView<ModeloPlanoTreino> tablePlanosTreinos;

    @FXML private TableColumn<ModeloCliente, String> colunaGeneroClientes;
    @FXML private TableColumn<ModeloCliente, Long> colunaIdadeClientes;
    @FXML private TableColumn<ModeloCliente, String> colunaNomeClientes;
    @FXML private TableView<ModeloCliente> tableClientes;

    @FXML
    public void initialize(){
        colunaGeneroClientes.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colunaIdadeClientes.setCellValueFactory(new PropertyValueFactory<>("idade"));
        colunaNomeClientes.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.updateListaClientes();

        colunaClientePlanoAlimentar.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colunaDtInicioPlanoAlimentar.setCellValueFactory(new PropertyValueFactory<>("dtInicio"));
        colunaDtFimPlanoAlimentar.setCellValueFactory(new PropertyValueFactory<>("dtFim"));
        this.updateListaPlanoAlimentar();

        colunaClientePlanoTreino.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colunaDtInicioPlanoTreino.setCellValueFactory(new PropertyValueFactory<>("dtInicio"));
        colunaDtFimPlanoTreino.setCellValueFactory(new PropertyValueFactory<>("dtFim"));
        this.updateListaPlanoTreino();
    }

    public void updateListaClientes() {
        ObservableList<ModeloCliente> result = FXCollections.observableArrayList();
        List<Cliente> clientes = Fachada.getInstance().listarClientes();
        for(Cliente c: clientes){
            result.add(new ModeloCliente(c));
        }
        tableClientes.setItems(result);
    }

    public void updateListaPlanoAlimentar() {
        ObservableList<ModeloPlanoAlimentar> result = FXCollections.observableArrayList();
        List<PlanoAlimentar> listaPlanos = Fachada.getInstance().listarPlanoAlimentar();
        for (PlanoAlimentar p: listaPlanos){
            result.add(new ModeloPlanoAlimentar(p));
        }
        tablePlanosAlimentares.setItems(result);
    }

    public void updateListaPlanoTreino() {
        ObservableList<ModeloPlanoTreino> result = FXCollections.observableArrayList();
        List<PlanoTreino> listaPlanos = Fachada.getInstance().listarPlanoTreino();
        for (PlanoTreino p: listaPlanos){
            result.add(new ModeloPlanoTreino(p));
        }
        tablePlanosTreinos.setItems(result);
    }
    @FXML
    void btnCadastrarPressed(ActionEvent event) {
        Stage dialog = new Stage();
        dialog.setScene(GerenciadorTelas.getInstance().getPopupScene());
        dialog.setResizable(false);
        dialog.setTitle("Cadastrar Plano");
        dialog.initOwner(((Node) event.getSource()).getScene().getWindow());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();
    }

    @FXML
    void btnRelatorioPressed(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("popupGraficos");
    }

    @FXML
    void btnSairPressed(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("TelaLogin");
    }

    @FXML
    void btnMeusDadosPressed(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("TelaInfoPessoalAdm");
    }
}
