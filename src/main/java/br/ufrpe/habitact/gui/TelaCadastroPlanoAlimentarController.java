package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.negocio.beans.Alimento;
import br.ufrpe.habitact.negocio.beans.enums.ObjetivoAlimentar;
import br.ufrpe.habitact.negocio.beans.enums.Refeicao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TelaCadastroPlanoAlimentarController {

    @FXML private DatePicker dtFim;
    @FXML private DatePicker dtInicio;
    @FXML private ComboBox<ObjetivoAlimentar> objetivo;
    @FXML private ComboBox<Refeicao> refeicao;
    @FXML private TableView<Alimento> tblAlimentos;
    @FXML private TableColumn<Alimento, Integer> qtdAlimento;
    @FXML private TableColumn<Alimento, Double> caloriasAlimento;
    @FXML private TableColumn<Alimento, String> nomeAlimento;
    @FXML private TextField textOutro;

    public void initialize() {
        //Adiciona os valores dos enuns ObjetivoAlimentar e Refeicao em cada ComboBox
        this.objetivo.getItems().addAll(ObjetivoAlimentar.values());
        this.refeicao.getItems().addAll(Refeicao.values());
    }

    @FXML
    void optOutrosSelecionado(ActionEvent event) {
        //Habilita o campo Outro para digitação
        if(objetivo.getValue().getObjetivo().equalsIgnoreCase("")){
            this.textOutro.setDisable(false);
        }
    }

    @FXML
    void btnAddAlimento(ActionEvent event) {
        //TODO direcionar tela atual para Tela de Cadastrar Alimento
        Stage dialog = new Stage();
        dialog.setScene(GerenciadorTelas.getInstance().getAddAlimentoScene());
        dialog.setResizable(false);
        dialog.setTitle("Cadastrar Alimentos");
        dialog.initOwner(((Node) event.getSource()).getScene().getWindow());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();
    }

    @FXML
    void btnCadastrarPressed(ActionEvent event) {
        if (verificarCamposVazios()) {
            GerenciadorTelas.getInstance().alertaCamposVazios();
        } else {
            //TODO Configurar parte para armazenar o planoAlimentar cadastrado pelo usuário
            
            //TODO colocação do USUARIO no Construtor abaixo. Verificar se correta
            //PlanoAlimentar cadastrarPlano = new PlanoAlimentar(usuario, dtInicio.getValue(), dtFim.getValue(),
            //      objetivo.getValue());

            //TODO redirecionar a tela para a anterior: Tela Listar Dados do Sistema
            //GerenciadorTelas.getInstance().trocarTela("listarDadosSistema");
        }
    }

    @FXML
    void btnVoltarTela(ActionEvent event) {
        //TODO direcionar para a tela anterior: Tela de Listar Dados do Sistema
        //GerenciadorTelas.getInstance().trocarTela("listarDadosSistema");
    }

    public String formatarData(LocalDate data){
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatador);
    }

    private boolean verificarCamposVazios() {
        return dtInicio.getValue() == null || dtFim.getValue() == null ||
                objetivo.getValue() == null || refeicao.getValue() == null ||
                textOutro.getText().isBlank();
    }
}
