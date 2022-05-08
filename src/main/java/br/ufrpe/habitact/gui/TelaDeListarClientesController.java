package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.negocio.beans.Administrador;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TelaDeListarClientesController implements Initializable {
    @FXML
    private Label labelDataNascimento;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelID;
    @FXML
    private Label labelNome;


    @FXML
    private TableColumn<Administrador, String> colunaEmail;
    @FXML
    private TableColumn<Administrador, String> colunaNome;
    @FXML
    private TableView<Administrador> myTableView;


    @FXML
    void btnVoltarPressed(ActionEvent event) {

    }

   /* ObservableList<Administrador> listaClientes = FXCollections.observableArrayList(
            new Administrador("João", "joao@gmail.com"),
            new Administrador("Alice", "alice@gmail.com")
    );*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colunaNome.setCellValueFactory(new PropertyValueFactory<Administrador, String>("nome"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<Administrador, String>("email"));
    }
}
