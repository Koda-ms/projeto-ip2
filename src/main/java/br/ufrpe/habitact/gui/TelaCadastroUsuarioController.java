package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.Administrador;
import br.ufrpe.habitact.negocio.beans.Cliente;
import br.ufrpe.habitact.negocio.beans.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class TelaCadastroUsuarioController {

    @FXML private TextField peso;
    @FXML private TextField altura;
    @FXML private TextField genero;
    @FXML private TextField emailCliente;
    @FXML private TextField emailAdministrador;
    @FXML private TextField nomeAdministrador;
    @FXML private TextField nomeCliente;
    @FXML private PasswordField senhaCliente;
    @FXML private PasswordField senhaAdministrador;
    @FXML private PasswordField confirmacaoSenhaCliente;
    @FXML private PasswordField confirmacaoDeSenhaAdministrador;
    @FXML private DatePicker dataNascimentoCliente;
    @FXML private DatePicker dataNascimentoAdministrador;
    @FXML private AnchorPane tabAdministrador;
    @FXML private AnchorPane tabUsuario;
    private static String Id = "1";


    @FXML
    private void CadastrarUsuarioBtn(ActionEvent e){
        if(verificarCamposVaziosUsuario()){
            GerenciadorTelas.getInstance().alertaCamposVazios();
        }
        else{
            try{
                Fachada.getInstance().cadastrarUsuario(new Cliente(nomeCliente.getText(), emailCliente.getText(),
                        senhaCliente.getText(), dataNascimentoCliente.getValue(), genero.getText(),
                        Double.parseDouble(peso.getText()), Double.parseDouble(altura.getText())));
                gerarAlertaDeCadastro();
                //TODO remover depois
                for (Usuario u : Fachada.getInstance().listarUsuarios()){
                    System.out.println(u.getNome());
                }
            } catch (ObjetoDuplicadoException exception) {
                exception.printStackTrace();
            } catch (EmailDuplicadoException ex) {
                ex.printStackTrace();
            }
            this.limparCamposDeDados();
            GerenciadorTelas.getInstance().updateComboBoxClientes();
        }
    }

    @FXML
    private void CadastrarAdministradorBtn(ActionEvent e){
        if(verificarCamposVaziosAdministrador()){
            GerenciadorTelas.getInstance().alertaCamposVazios();
        }
        else{
            try {
                Fachada.getInstance().cadastrarUsuario(new Administrador(nomeAdministrador.getText(),
                        emailAdministrador.getText(), senhaAdministrador.getText(),
                        dataNascimentoAdministrador.getValue(), Id));
                int idSaver = Integer.parseInt(Id);
                idSaver++;
                Id = Integer.toString(idSaver);
                gerarAlertaDeCadastro();
                for (Usuario u : Fachada.getInstance().listarUsuarios()){
                    System.out.println(u.getNome());
            }
            } catch (ObjetoDuplicadoException exception) {
                exception.printStackTrace();
            }
            this.limparCamposDeDados();
        }
    }

    @FXML
    void btnVoltarCliente(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("TelaLogin");
    }

    @FXML
    void btnVoltarAdm(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("TelaLogin");
    }

    private void gerarAlertaDeCadastro(){
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Usuário cadastrado");
        alerta.setHeaderText("O usuário foi cadastrado");
        alerta.showAndWait();
    }

    private void limparCamposDeDados() {
        this.genero.setText("");
        this.emailCliente.setText("");
        this.emailAdministrador.setText("");
        this.senhaCliente.setText("");
        this.senhaAdministrador.setText("");
        this.confirmacaoSenhaCliente.setText("");
        this.confirmacaoDeSenhaAdministrador.setText("");
        this.nomeCliente.setText("");
        this.nomeAdministrador.setText("");
        this.altura.setText("");
        this.peso.setText("");
        this.dataNascimentoCliente.setValue(null);
        this.dataNascimentoAdministrador.setValue(null);
    }

    private boolean verificarCamposVaziosUsuario() {
        return genero.getText().isBlank() || nomeCliente.getText().isBlank() ||
                dataNascimentoCliente.getValue() == null || peso.getText().isBlank() || altura.getText().isBlank() ||
                emailCliente.getText().isBlank() || senhaCliente.getText().isBlank() || confirmacaoSenhaCliente.getText().isBlank();
    }

    private boolean verificarCamposVaziosAdministrador() {
        return nomeAdministrador.getText().isBlank() || emailAdministrador.getText().isBlank() ||
                senhaAdministrador.getText().isBlank() || confirmacaoDeSenhaAdministrador.getText().isBlank() || dataNascimentoAdministrador.getValue() == null;
    }
}
