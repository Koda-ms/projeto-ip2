package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.Cliente;
import br.ufrpe.habitact.negocio.beans.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class TelaDeLoginControlador{
    @FXML TextField emailTxtField;
    @FXML PasswordField senhaField;
    @FXML Button logarButton;
    @FXML Button cadastrarButton;
    private static Usuario usuario;

    @FXML
    public void btnLogar(ActionEvent event) {
        Usuario u = Fachada.getInstance().autenticarUsuario(emailTxtField.getText(), senhaField.getText());
        if (u == null){
            this.gerarAlertaDeUsuario();
        } else {
            if(u instanceof Cliente){
                GerenciadorTelas.getInstance().trocarTela("TelaPrincipalDoCliente");
            } else{
                GerenciadorTelas.getInstance().trocarTela("telaPrincipalAdm");
            }
            usuario = u;
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

    public static Usuario getUsuario() {
        return usuario;
    }
}
