package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.dados.IRepositorio;
import br.ufrpe.habitact.negocio.beans.Usuario;
import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static javafx.application.Application.launch;

public class TelaDeLoginControlador{
    @FXML private TitledPane principal;
    @FXML private AnchorPane telaDeCadastro;
    @FXML private AnchorPane subTelaDeCadastro;
    @FXML private PasswordField email;
    @FXML private PasswordField senha;
    @FXML private Text txtEmail;
    @FXML private Text txtSenha;
    @FXML private Button criarConta;
    @FXML private Button logar;
    private ArrayList<Usuario> listaUsuarios;
    private IRepositorio<Usuario> repositorioUsuarios;


    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().class.getResource("TelaDeLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
