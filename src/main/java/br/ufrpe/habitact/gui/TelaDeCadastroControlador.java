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

public class TelaDeCadastroControlador {
    @FXML private TextField altura;
    @FXML private Button btnCadastrarUsuario;
    @FXML private PasswordField confirmacaoDeSenha;
    @FXML private PasswordField confirmacaoDeSenhaAdministrador;
    @FXML private DatePicker dataNascimentoAdministrador;
    @FXML private DatePicker dataNascimentoUsuario;
    @FXML private TextField email;
    @FXML private TextField emailAdministrador;
    @FXML private TextField genero;
    @FXML private TextField nomeAdministrador;
    @FXML private TextField nomeUsuario;
    @FXML private TextField peso;
    @FXML private TabPane root;
    @FXML private PasswordField senha;
    @FXML private PasswordField senhaAdministrador;
    @FXML private AnchorPane tabAdministrador;
    @FXML private AnchorPane tabUsuario;
    @FXML private Button cadastrarAdministrador;
    @FXML private Button btnVoltar;
    private static String Id = "0";


    @FXML
    private void CadastrarUsuarioBtn(ActionEvent e){
        if(verificarCamposVaziosUsuario()){
            GerenciadorTelas.getInstance().alertaCamposVazios();
        }
        else{
            try{
                Fachada.getInstance().cadastrarUsuario(new Cliente(nomeUsuario.getText(), email.getText(), senha.getText(), dataNascimentoUsuario.getValue(), genero.getText(), Double.parseDouble(peso.getText()), Double.parseDouble(altura.getText()), false));
                gerarAlertaDeCadastro();
                for (Usuario u : Fachada.getInstance().listarUsuarios()){
                    System.out.println(u.getNome());
                }
            } catch (ObjetoDuplicadoException exception) {
                exception.printStackTrace();
            }
        }
    }

    @FXML
    private void CadastrarAdministradorBtn(ActionEvent e){
        if(verificarCamposVaziosAdministrador()){
            GerenciadorTelas.getInstance().alertaCamposVazios();
        }
        else{
            try {
                Fachada.getInstance().cadastrarUsuario(new Administrador(nomeAdministrador.getText(), emailAdministrador.getText(), senhaAdministrador.getText(), dataNascimentoAdministrador.getValue(), Id));
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
        }
    }

    private boolean verificarCamposVaziosUsuario() {
        return genero.getText().isBlank() || nomeUsuario.getText().isBlank() ||
           dataNascimentoUsuario.getValue() == null || peso.getText().isBlank() || altura.getText().isBlank() ||
                email.getText().isBlank() || senha.getText().isBlank() || confirmacaoDeSenha.getText().isBlank();
    }

    private boolean verificarCamposVaziosAdministrador() {
        return nomeAdministrador.getText().isBlank() || emailAdministrador.getText().isBlank() ||
                senhaAdministrador.getText().isBlank() || confirmacaoDeSenhaAdministrador.getText().isBlank() || dataNascimentoAdministrador.getValue() == null;
    }

    @FXML
    void voltarBtn(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("TelaDeLogin");
    }

    private void gerarAlertaDeCadastro(){
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Usuário cadastrado");
        alerta.setHeaderText("O usuário foi cadastrado");
        alerta.showAndWait();
    }
}
