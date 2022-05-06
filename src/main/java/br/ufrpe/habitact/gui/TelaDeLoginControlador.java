package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.dados.IRepositorio;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
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
import java.util.List;

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


    @FXML
    public void btnLogar(ActionEvent event) throws ObjetoNaoExisteException{
        boolean achou = false;
        List<Usuario> usuarios = repositorioUsuarios.listar();
        for(Usuario usuario : usuarios){
            if(usuario.getEmail().equals(email.getText()) && usuario.getSenha().equals(senha.getText())){
                achou = true;
            }
        }
    }

    private void gerarAlertaDeUsuario(String justificativa){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Úsuario não cadastrado");
        alerta.setHeaderText("Aparentemente o úsuario não existe");
        alerta.setContentText(justificativa);
        alerta.showAndWait();
    }

    @FXML
    public void btnCriarConta(ActionEvent event){

    }
}
