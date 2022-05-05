package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.dados.IRepositorio;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.negocio.beans.Administrador;
import br.ufrpe.habitact.negocio.beans.Usuario;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TelaDeCadastroControlador extends Application {
    @FXML private TitledPane root;
    @FXML private AnchorPane subRoot;
    @FXML private TabPane telaDeCadastro;
    @FXML private Tab telaAdiministrador;
    @FXML private Tab telaUsuario;
    @FXML private AnchorPane usuario;
    @FXML private AnchorPane adiministrador;
    @FXML private PasswordField nome;
    @FXML private ChoiceBox genero;
    @FXML private PasswordField peso;
    @FXML private PasswordField altura;
    @FXML private DatePicker dataDeNascimento;
    @FXML private PasswordField emailUsuario;
    @FXML private PasswordField senhaUsuario;
    @FXML private PasswordField confirmacaoDeSenhaU;
    @FXML private PasswordField emailAdiministrador;
    @FXML private PasswordField senhaAdiministrador;
    @FXML private PasswordField confirmacaoDeSenhaAdm;
    @FXML private Button cadastrarUsuario;
    @FXML private Button cadastrarAdministrador;
    private IRepositorio<Usuario> repositorioUsuarios;
    private IRepositorio<Administrador> repositorioAdministradores;

    @FXML
    private void btnCadastrarUsuario(Event e) throws ObjetoDuplicadoException {
        try{
        }
        catch(ObjetoDuplicadoException exception){
            throw new ObjetoDuplicadoException("Usuário já cadastrado");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }
}
