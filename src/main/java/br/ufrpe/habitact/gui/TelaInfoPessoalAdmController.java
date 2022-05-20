package br.ufrpe.habitact.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TelaInfoPessoalAdmController {

 @FXML
 private TextField txtDataNascimento;

 @FXML
 private TextField txtEmail;

 @FXML
 private TextField txtID;

 @FXML
 private TextField txtNome;

 @FXML
 private TextField txtNovaSenha;

 @FXML
 private TextField txtSenhaAtual;

 @FXML
 public void initialize(){

 }

 @FXML
 void btnSalvarPressed(ActionEvent event) {

 }

 @FXML
 void btnSalvarSenhaPressed(ActionEvent event) {

 }

 @FXML
 void btnAlterarSenhaPressed(ActionEvent event){

 }

 @FXML
 void btnEditarDadosPressed(ActionEvent event){

 }

 @FXML
 void btnVoltarPressed(ActionEvent event) {
  GerenciadorTelas.getInstance().trocarTela("telaPrincipalAdm");
 }

}