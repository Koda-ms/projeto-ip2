package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.negocio.beans.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
            GerenciadorTelas.getInstance().trocarTela("TelaPrincipalDoCliente");
        }
    }

    private void gerarAlertaDeUsuario(){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Usuário não cadastrado");
        alerta.setHeaderText("Aparentemente o usuário não existe");
        alerta.showAndWait();
    }

    @FXML
    public void btnCadastro(ActionEvent event){
        GerenciadorTelas.getInstance().trocarTela("TelaDeCadastro");
    }
}
