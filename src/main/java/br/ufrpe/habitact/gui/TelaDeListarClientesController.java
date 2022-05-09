package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.gui.modelos.ModeloListaCliente;
import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.Cliente;
import br.ufrpe.habitact.negocio.beans.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class TelaDeListarClientesController{
    @FXML
    private Button buttonVoltar;
    @FXML
    private Label labelDataNascimento;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelID;
    @FXML
    private Label labelNome;
    @FXML
    private TableColumn<ModeloListaCliente, String> colunaEmail;
    @FXML
    private TableColumn<ModeloListaCliente, String> colunaNome;
    @FXML
    private TableColumn<ModeloListaCliente, Boolean> colunaCheck;
    @FXML
    private TableView<ModeloListaCliente> tblClientes;


    public void initialize(){
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colunaCheck.setCellValueFactory(new PropertyValueFactory<>("check"));

        this.updateListaClientes();

        this.colunaCheck.setCellFactory(CheckBoxTableCell.forTableColumn(colunaCheck));
    }

    public void updateListaClientes() {
       Usuario c1 = new Cliente();
       c1.setNome("joao");
       c1.setEmail("joao@gmail.com");

       Usuario c2 = new Cliente();
       c2.setNome("july");
       c2.setEmail("july@gmail.com");

        Usuario c3 = new Cliente();
        c3.setNome("matheus");
        c3.setEmail("matheus@gmail.com");

        try {
            Fachada.getInstance().cadastrarUsuario(c1);
            Fachada.getInstance().cadastrarUsuario(c2);
            Fachada.getInstance().cadastrarUsuario(c3);
        } catch (ObjetoDuplicadoException e) {
            e.printStackTrace();
        }

        ObservableList<ModeloListaCliente> result = FXCollections.observableArrayList();
        List<Usuario> listaUsuarios = Fachada.getInstance().listarUsuarios();
        for(Usuario u: listaUsuarios){
            if (u instanceof Cliente){
                result.add(new ModeloListaCliente((Cliente) u));
            }
        }
        tblClientes.setItems(result);
    }

    @FXML
    void btnVoltarPressed(ActionEvent event) {
        //GerenciadorTelas.getInstance().trocarTela("telaPrincipalAdm");
    }


}
