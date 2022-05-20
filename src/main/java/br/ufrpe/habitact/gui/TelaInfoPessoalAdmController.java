package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.excecoes.SenhaIncorretaException;
import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.Administrador;
import br.ufrpe.habitact.negocio.beans.Usuario;
import br.ufrpe.habitact.sessao.Sessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class TelaInfoPessoalAdmController {

    @FXML
    private DatePicker dtPickerNascimento;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtNome;

    @FXML
    private PasswordField passNovaSenha;

    @FXML
    private PasswordField passSenhaAtual;

    public void setInformacoes(){
        Administrador adm = (Administrador) Sessao.getInstance().getUsuario();
        txtNome.setText(adm.getNome());
        txtID.setText(adm.getiD());
        txtEmail.setText(adm.getEmail());
        dtPickerNascimento.setValue(adm.getDtNascimento());
    }

    @FXML
    void btnSalvarPressed(ActionEvent event) {
        Usuario u = new Administrador(txtNome.getText(), txtEmail.getText(),
                Sessao.getInstance().getUsuario().getSenha(), dtPickerNascimento.getValue(), txtID.getText());
        try {
            Fachada.getInstance().alterarDados(Sessao.getInstance().getUsuario(), u);
            Sessao.getInstance().setUsuario(u);
            gerarAlertaDados();
        } catch (ObjetoNaoExisteException e){
            gerarAlertaNenhum();
        }
    }

    private void gerarAlertaNenhum(){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Nenhum dado foi modificado");
        alerta.setHeaderText("Nenhum dado foi modificado");
        alerta.showAndWait();
    }

    private void gerarAlertaDados(){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Dados Modificados");
        alerta.setHeaderText("Dados modificados com sucesso!");
        alerta.showAndWait();
    }

    private void gerarAlertaSenha(){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Senha Incorreta");
        alerta.setHeaderText("Senha Atual Incorreta");
        alerta.showAndWait();
    }

    @FXML
    void btnSalvarSenhaPressed(ActionEvent event) {
        if (verificarCamposVazios()){
            GerenciadorTelas.getInstance().alertaCamposVazios();
        } else {
            try{
                Fachada.getInstance().alterarSenha(Sessao.getInstance().getUsuario(), passSenhaAtual.getText(),
                        passNovaSenha.getText() );
                limparCampos();
                gerarAlertaDados();
            } catch (SenhaIncorretaException e) {
                gerarAlertaSenha();
            }
        }
    }

    private void limparCampos(){
        passSenhaAtual.setText("");
        passNovaSenha.setText("");
    }

    @FXML
    void btnVoltarPressed(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("telaPrincipalAdm");
    }

    private boolean verificarCamposVazios() {
        return passSenhaAtual == null && passNovaSenha == null;
    }

}
