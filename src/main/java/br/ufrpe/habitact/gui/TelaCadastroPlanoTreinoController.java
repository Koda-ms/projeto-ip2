package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.negocio.ControladorExercicio;
import br.ufrpe.habitact.negocio.beans.Exercicio;
import br.ufrpe.habitact.negocio.beans.enums.ObjetivoTreino;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TelaCadastroPlanoTreinoController {

    @FXML private DatePicker dtFim;
    @FXML private DatePicker dtInicio;
    @FXML private TableColumn<?, ?> nomeTreino;
    @FXML private TableColumn<?, ?> detalheExercicio;
    @FXML private ComboBox<ObjetivoTreino> objetivo;
    @FXML private TextField textOutro;

    public void initialize() {
        //Adiciona os valores dos enuns ObjetivoAlimentar e Refeicao em cada ComboBox
        this.objetivo.getItems().addAll(ObjetivoTreino.values());
        //Adicionando alimentos para visualização na TableView do Catálogo
        ListView<Exercicio> listaExercicio = new ListView<>();
        ObservableList<Exercicio> exercicio = FXCollections.observableArrayList(ControladorExercicio.getInstance().listarExercicios());
        listaExercicio.setItems(exercicio);
    }

    @FXML
    void optOutrosSelecionado(ActionEvent event) {

        //TODO Habilita o campo Outro para digitação. Configuração abaixo não está funcionando para essa tela
        if(objetivo.getValue().getObjetivo().equalsIgnoreCase("")){
            this.textOutro.setDisable(false); //TODO Como seria pra armazenar esse valor em Objetivo?

        }
    }

    @FXML
    void btnAddTreino(ActionEvent event) {
        Stage dialog = new Stage();
        dialog.setScene(GerenciadorTelas.getInstance().getAddTreino());
        dialog.setResizable(false);
        dialog.setTitle("Cadastrar Treino");
        dialog.initOwner(((Node) event.getSource()).getScene().getWindow());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();
    }

    @FXML
    void btnCadastrarPressed(ActionEvent event) {
        if (verificarCamposVazios()) {
            GerenciadorTelas.getInstance().alertaCamposVazios();
        } else {
            //TODO colocação do USUARIO no Construtor abaixo. Verificar se correta
            //PlanoAlimentar cadastrarPlano = new PlanoAlimentar(usuario, dtInicio.getValue(), dtFim.getValue(),
            //      objetivo.getValue());

            //TODO redirecionar a tela para a anterior: Tela Listar Dados do Sistema
            //GerenciadorTelas.getInstance().trocarTela("listarDadosSistema");
        }
    }

    @FXML
    void btnVoltarPressed(ActionEvent event) {
        //TODO Configurar parte para armazenar o planoTreino cadastrado pelo usuário

        //TODO Direcionar tela para a Tela Listar Dados do Sistema
        //GerenciadorTelas.getInstance().trocarTela("listarDadosSistema");
    }
    private boolean verificarCamposVazios() {
        return dtInicio.getValue() == null || dtFim.getValue() == null ||
                objetivo.getValue() == null || textOutro.getText().isBlank();
    }
}

