package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.gui.modelos.ModeloCliente;
import br.ufrpe.habitact.gui.modelos.ModeloPlanoAlimentar;
import br.ufrpe.habitact.gui.modelos.ModeloPlanoTreino;
import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.Cliente;
import br.ufrpe.habitact.negocio.beans.PlanoAlimentar;
import br.ufrpe.habitact.negocio.beans.PlanoTreino;
import br.ufrpe.habitact.negocio.beans.Usuario;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class TelaAdmController {

    @FXML private Button bottonCadastrarPlanos;
    @FXML private Button bottonGerarRelatórios;
    @FXML private Button bottonSair;

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
        colunaClientePlanoAlimentar.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colunaDtInicioPlanoAlimentar.setCellValueFactory(new PropertyValueFactory<>("dtInicio"));
        colunaDtFimPlanoAlimentar.setCellValueFactory(new PropertyValueFactory<>("dtFim"));
        this.updateListaPlanoAlimentar();

        colunaClientePlanoTreino.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colunaDtInicioPlanoTreino.setCellValueFactory(new PropertyValueFactory<>("dtInicio"));
        colunaDtFimPlanoTreino.setCellValueFactory(new PropertyValueFactory<>("dtFim"));
        this.updateListaPlanoTreino();

        colunaGeneroClientes.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colunaIdadeClientes.setCellValueFactory(new PropertyValueFactory<>("idade"));
        colunaNomeClientes.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.updateListaClientes();
    }

    public void updateListaClientes() {
        ObservableList<ModeloCliente> result = FXCollections.observableArrayList();
        List<Usuario> listaUsuarios = Fachada.getInstance().listarUsuarios();
        for(Usuario u: listaUsuarios){
            if (u instanceof Cliente){
                result.add(new ModeloCliente((Cliente) u));
            }
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
}
