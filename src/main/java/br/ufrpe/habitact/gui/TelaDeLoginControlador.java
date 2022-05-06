package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.dados.IRepositorio;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.negocio.Fachada;
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
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javafx.application.Application.launch;


public class TelaDeLoginControlador{
    @FXML TextField emailTxtField;
    @FXML PasswordField senhaField;
    @FXML Button logarButton;
    @FXML Button cadastrarButton;

    @FXML
    public void btnLogar(ActionEvent event) {
        Usuario u = Fachada.getInstance().autenticarUsuario(emailTxtField.getText(), senhaField.getText());
        if (u == null){
            this.gerarAlertaDeUsuario();
        } else {
            GerenciadorTelas.getInstance().getPrimaryStage().setScene(GerenciadorTelas.getInstance().getPrincipalScene());
        }
    }

    private void gerarAlertaDeUsuario(){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Usuário não cadastrado");
        alerta.setHeaderText("Aparentemente o usuário não existe");
        alerta.showAndWait();
    }

    @FXML
    public void btnCriarConta(ActionEvent event){

    }
}
