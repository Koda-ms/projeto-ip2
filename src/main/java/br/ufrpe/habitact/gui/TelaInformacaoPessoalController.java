package br.ufrpe.habitact.gui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import javafx.stage.Stage;

public class TelaInformacaoPessoalController {
    @FXML TextField nome;
    @FXML TextField email;
    @FXML PasswordField senha;
    @FXML DatePicker nascimento;
    @FXML PasswordField btnActualPassword;
    @FXML PasswordField newPassword;
    @FXML Button editar;
    @FXML Button salvarDados;
    @FXML Button voltar;
    @FXML Button salvarSenha;

    private void initialize() {
        Usuario user /* pegar instância de usuario logada no momento */;

        nome.setText(user.getNome());
        email.setText(user.getEmail());
        nascimento.getEditor().setText(user.getDtNascimento());
    }

    @FXML
    public void btnEditarDadosPressed() {
        this.ativarEdicaoDados(true);
    }

    @FXML
    public void btnSalvarDadosPressed() throws ObjetoNaoExisteException{
            Usuario user =  /*pegar instância de usuario logada no momento*/;
            user.setNome(nome.getText());
            user.setEmail(email.getText());
            user.setDtNascimento(nascimento.getText());
            if(!user){
                throw new ObjetoNaoExisteException("Não foi possivel alterar os dados do usuario");
            }
            else {
                this.ativarEdicaoDados(false);
                this.senha.setText("");
            }
    }

    @FXML
    public void btnSalvarSenhaPressed() {
        if (senha.getText().equals(newPassword.getText())) {
            Usuario user = /*pegar instância de usuario logada no momento*/;
            this.newPassword.setText("");
        } else {
            this.gerarAlertaErroAutenticacao("As senhas não batem!");
        }
        this.btnActualPassword.setText("");
    }

    @FXML
    public void btnVoltarTelaPressed() {
       /*Ação para alteração de tela, para tela anterior*/
    }

    private void ativarEdicaoDados(boolean edicao) {
        nome.setEditable(edicao);
        nome.setDisable(!edicao);
        senha.setEditable(edicao);
        senha.setDisable(!edicao);
        email.setEditable(edicao);
        email.setDisable(!edicao);
        nascimento.setEditable(edicao);
        nascimento.setDisable(!edicao);
    }

    private void gerarAlertaErroAutenticacao(String justificativa) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Erro de Autenticação");
        alerta.setHeaderText("Parece que tivemos um erro com sua tentativa de alteração de dados");
        alerta.setContentText(justificativa);
        alerta.showAndWait();
    }

}
