package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.excecoes.SenhaIncorretaException;
import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.Administrador;
import br.ufrpe.habitact.negocio.beans.Cliente;
import br.ufrpe.habitact.negocio.beans.Usuario;
import br.ufrpe.habitact.sessao.Sessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class TelaInfoPessoalClienteController {
    @FXML private DatePicker dtPickerNascimento;
    @FXML private PasswordField passNovaSenha;
    @FXML private PasswordField passSenhaAtual;
    @FXML private TextField txtAltura;
    @FXML private TextField txtEmail;
    @FXML private TextField txtGenero;
    @FXML private TextField txtNome;
    @FXML private TextField txtPeso;

    public void setInformacoes(){
        Cliente cliente = (Cliente) Sessao.getInstance().getUsuario();
        txtNome.setText(cliente.getNome());
        txtAltura.setText(Double.toString(cliente.getAltura()));
        txtPeso.setText(Double.toString(cliente.getPeso()));
        txtGenero.setText(cliente.getGenero());
        txtEmail.setText(cliente.getEmail());
        dtPickerNascimento.setValue(cliente.getDtNascimento());
    }

    @FXML
    void btnSalvarPressed(ActionEvent event) {
        if (verificarCamposVazios()){
            GerenciadorTelas.getInstance().alertaCamposVazios();
        } else {
            try {
                Usuario u = new Cliente(txtNome.getText(), txtEmail.getText(),
                        Sessao.getInstance().getUsuario().getSenha(), dtPickerNascimento.getValue(), txtGenero.getText(),
                        Double.parseDouble(txtPeso.getText()), Double.parseDouble(txtAltura.getText()));
                Fachada.getInstance().alterarDados(Sessao.getInstance().getUsuario(), u);
                Sessao.getInstance().setUsuario(u);
                gerarAlertaDados();
            } catch (ObjetoNaoExisteException e) {
                gerarAlertaNenhum();
            } catch (Exception e){
                gerarAlertaPesoAltura();
            }
        }
    }

    @FXML
    void btnSalvarSenhaPressed(ActionEvent event) {
        if (verificarCamposSenhaVazios()){
            GerenciadorTelas.getInstance().alertaCamposVazios();
        } else {
            try{
                Fachada.getInstance().alterarSenha(Sessao.getInstance().getUsuario(), passSenhaAtual.getText(),
                        passNovaSenha.getText() );
                limparCampos();
                gerarAlertaDados();
            } catch (SenhaIncorretaException e) {
                gerarAlertaSenha();
                limparCampos();
            }
        }
    }

    @FXML
    void btnVoltarPressed(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("TelaPrincipalCliente");
    }

    private void gerarAlertaNenhum(){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Nenhum dado foi modificado");
        alerta.setHeaderText("Nenhum dado foi modificado");
        alerta.showAndWait();
    }

    private void gerarAlertaPesoAltura(){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Peso e/ou Altura");
        alerta.setHeaderText("O peso e/ou altura estão em formato incorreto");
        alerta.setContentText("O formato padrão é \"x.xx...\" ou apenas \"x\", sendo x um número inteiro." +
                "\n\nExemplos: 1.79 / 115 / 98.25");
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

    private void limparCampos(){
        passSenhaAtual.setText("");
        passNovaSenha.setText("");
    }

    private boolean verificarCamposSenhaVazios() {
        return passSenhaAtual.getText().equals("") && passNovaSenha.getText().equals("");
    }

    private boolean verificarCamposVazios(){
        return txtNome.getText().equals("") && txtEmail.getText().equals("") && txtGenero.getText().equals("")
                && txtPeso.getText().equals("") && txtAltura.getText().equals("");
    }

}