package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.excecoes.EmailDuplicadoException;
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
        else if (!senhaCliente.getText().equals(confirmacaoSenhaCliente.getText())){
            gerarAlertaSenhas();
        }
        else{
            try{
                Fachada.getInstance().cadastrarUsuario(new Cliente(nomeCliente.getText(), emailCliente.getText(),
                        senhaCliente.getText(), dataNascimentoCliente.getValue(), genero.getText(),
                        Double.parseDouble(peso.getText()), Double.parseDouble(altura.getText())));
                gerarAlertaDeCadastro();
                this.limparCamposDeDados();
            } catch (ObjetoDuplicadoException | EmailDuplicadoException exception) {
                gerarAlertaDuplicado(exception.getMessage());
            } catch (Exception exception){
                gerarAlertaPesoAltura();
            }
            GerenciadorTelas.getInstance().updateComboBoxClientes();
        }
    }

    @FXML
    private void CadastrarAdministradorBtn(ActionEvent e){
        if(verificarCamposVaziosAdministrador()){
            GerenciadorTelas.getInstance().alertaCamposVazios();
        }
        else if (!senhaAdministrador.getText().equals(confirmacaoDeSenhaAdministrador.getText())){
            gerarAlertaSenhas();
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
                this.limparCamposDeDados();
            } catch (ObjetoDuplicadoException | EmailDuplicadoException exception) {
                gerarAlertaDuplicado(exception.getMessage());
            }
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
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Usu??rio cadastrado");
        alerta.setHeaderText("O usu??rio foi cadastrado");
        alerta.showAndWait();
    }

    private void gerarAlertaDuplicado(String header){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Dados Duplicados");
        alerta.setHeaderText(header);
        alerta.showAndWait();
    }

    private void gerarAlertaSenhas(){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Senhas n??o correspondem");
        alerta.setHeaderText("Senha e Confirma????o de senha n??o s??o iguais");
        alerta.showAndWait();
    }

    private void gerarAlertaPesoAltura(){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Peso e/ou Altura");
        alerta.setHeaderText("O peso e/ou altura est??o em formato incorreto");
        alerta.setContentText("O formato padr??o ?? \"x.xx...\" ou apenas \"x\", sendo x um n??mero inteiro." +
                "\n\nExemplos: 1.79 / 115 / 98.25");
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
