package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.negocio.beans.Exercicio;
import br.ufrpe.habitact.negocio.beans.Treino;
import br.ufrpe.habitact.negocio.beans.enums.ObjetivoTreino;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TelaCadastroPlanoTreinoController {

    @FXML private Button btnCancelarCadastrarPressed;
    @FXML private DatePicker dtFim;
    @FXML private DatePicker dtInicio;
    @FXML private TableView<Treino> tblTreino;
    @FXML private TableColumn<Treino, String> nomeTreino;
    @FXML private TableColumn<Exercicio, String> detalheExercicio; //Apenas o nome do exercício será mostrado
    @FXML private ComboBox<ObjetivoTreino> objetivoTreino;
    @FXML private TextField textOutro;

    public void initialize() {
        //Adiciona os valores do enum ObjetivoTreino no ComboBox
        this.objetivoTreino.getItems().addAll(ObjetivoTreino.values());
    }

    @FXML
    void optOutrosSelecionada(ActionEvent event) {

        //TODO Habilita o campo Outro para digitação. Configuração abaixo não está funcionando para essa tela
        if(objetivoTreino.getValue().getObjetivo().equalsIgnoreCase("")){
            this.textOutro.setDisable(false); //TODO Como seria pra armazenar esse valor em Objetivo?
        }
    }

    //Direcionar para uma tela de diálogo que aparecerá sobre a tela atual
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
            /*PlanoTreino p = new PlanoTreino(usuario, dtInicio.getValue(), dtFim.getValue(),
                  objetivoTreino.getValue());

            try {
                Fachada.getInstance().cadastrarPlanoTreino(p);
            }catch (MaisDeUmPlanoNoMesmoPeriodoException | ObjetoDuplicadoException e) {
                e.getMessage();
            }*/

            this.limparCamposDeDados();
            ((Stage)this.btnCancelarCadastrarPressed.getScene().getWindow()).close();
        }
    }

    @FXML
    void btnVoltarPressed(ActionEvent event) {
        //GerenciadorTelas.getInstance().trocarTela("listarDadosSistema");
    }

    private void limparCamposDeDados() {
        this.textOutro.setText("");
        this.dtInicio.setValue(null);
        this.dtFim.setValue(null);
        this.objetivoTreino.getSelectionModel().clearSelection();
        this.tblTreino.getSelectionModel().clearSelection();
    }

    private boolean verificarCamposVazios() {
        return dtInicio.getValue() == null || dtFim.getValue() == null ||
                objetivoTreino.getValue() == null && textOutro.getText().isBlank();
    }
}

