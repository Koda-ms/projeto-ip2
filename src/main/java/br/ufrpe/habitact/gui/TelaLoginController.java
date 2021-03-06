package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.Administrador;
import br.ufrpe.habitact.negocio.beans.Cliente;
import br.ufrpe.habitact.negocio.beans.Usuario;
import br.ufrpe.habitact.sessao.Sessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class TelaLoginController {
    @FXML TextField emailTxtField;
    @FXML PasswordField senhaField;

    @FXML
    public void btnLogar(ActionEvent event) {
        Usuario u = Fachada.getInstance().autenticarUsuario(emailTxtField.getText(), senhaField.getText());
        if (u == null){
            this.gerarAlertaDeUsuario();
        } else {
            if(u instanceof Cliente){
                Sessao.getInstance().setUsuario(u);
                GerenciadorTelas.getInstance().trocarTela("TelaPrincipalCliente");
            }
            else if(u instanceof Administrador){
                Sessao.getInstance().setUsuario(u);
                GerenciadorTelas.getInstance().trocarTela("telaPrincipalAdm");
            }
        }
        this.limparCamposDeDados();
    }

    private void gerarAlertaDeUsuario(){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Dados Incorretos");
        alerta.setHeaderText("E-mail e/ou senha incorretos");
        alerta.showAndWait();
    }

    @FXML
    public void btnCadastro(ActionEvent event){
        GerenciadorTelas.getInstance().trocarTela("TelaCadastro");
    }

    private void limparCamposDeDados() {
        this.emailTxtField.setText("");
        this.senhaField.setText("");
    }
}