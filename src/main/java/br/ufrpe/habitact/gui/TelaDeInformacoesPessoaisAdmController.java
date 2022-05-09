package br.ufrpe.habitact.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TelaDeInformacoesPessoaisAdmController {
   //atributos
    @FXML
    private TextField txtDataNascimento;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtNome;

    //métodos



    @FXML
    void btnEditarSenhaPressed(ActionEvent event) {

    }

    @FXML
    void btnSalvarPressed(ActionEvent event) {

    }

    @FXML
    void btnSalvarSenhaPressed(ActionEvent event) {

    }

    @FXML
    void btnVoltarPressed(ActionEvent event) {
      //GerenciadorTelas.getInstance().trocarTela("telaPrincipalAdm");
    }

}
