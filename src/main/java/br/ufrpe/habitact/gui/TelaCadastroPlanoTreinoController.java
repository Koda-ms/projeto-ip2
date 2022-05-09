package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.gui.modelos.ModeloPlanoTreinoCliente;
import br.ufrpe.habitact.negocio.beans.Treino;
import br.ufrpe.habitact.negocio.beans.enums.CategoriaTreino;
import br.ufrpe.habitact.negocio.beans.enums.ObjetivoTreino;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TelaCadastroPlanoTreinoController {

    @FXML private DatePicker dtFim;
    @FXML private DatePicker dtInicio;
    @FXML private TextField textOutro;
    @FXML private Button btnCancelarCadastrarPressed;
    @FXML private ComboBox<ObjetivoTreino> objetivoTreino;

    @FXML private TableView<ModeloPlanoTreinoCliente> tblTreino;
    @FXML private TableColumn<ModeloPlanoTreinoCliente, Boolean> colunaCheck;
    @FXML private TableColumn<ModeloPlanoTreinoCliente, Double> colunaCalorias;
    @FXML private TableColumn<ModeloPlanoTreinoCliente, Double> colunaDuracao;
    @FXML private TableColumn<ModeloPlanoTreinoCliente, String> coluanDiaTreino;
    @FXML private TableColumn<ModeloPlanoTreinoCliente, String> colunaCategoriaTreino;

    public void initialize() {
        //Adiciona os valores do enum ObjetivoTreino no ComboBox
        this.objetivoTreino.getItems().addAll(ObjetivoTreino.values());
        //Setando as colunas da TableView
        this.colunaCheck.setCellValueFactory(new PropertyValueFactory<>("check"));
        this.colunaCheck.setCellFactory(CheckBoxTableCell.forTableColumn(colunaCheck));
        this.coluanDiaTreino.setCellValueFactory(new PropertyValueFactory<>("data"));
        this.colunaDuracao.setCellValueFactory(new PropertyValueFactory<>("duracao"));
        this.colunaCalorias.setCellValueFactory(new PropertyValueFactory<>("calorias"));
        this.colunaCategoriaTreino.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        this.updateCatalogoTreino();
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

    private void updateCatalogoTreino() {
        //Instancia treinos para o Controlador de Treinos
        ArrayList<Treino> listaTreinos = new ArrayList<>();
        //TODO não conseguindo setar um ArrayList<Exercicio> manualmente
        Treino t1 = new Treino();
        t1.setDiaFeito(LocalDate.of(2022, 5, 1));
        t1.setModalidade(CategoriaTreino.ANAEROBICO);
        t1.setQueimaCaloricaTotal(80);
        t1.setDuracao(30);
        Treino t2 = new Treino();
        t2.setDiaFeito(LocalDate.of(2022, 5, 7));
        t2.setModalidade(CategoriaTreino.AEROBICO);
        t2.setQueimaCaloricaTotal(170);
        t2.setDuracao(25);
        Treino t3 = new Treino();
        t3.setDiaFeito(LocalDate.of(2022, 4, 20));
        t3.setModalidade(CategoriaTreino.AEROBICO);
        t3.setQueimaCaloricaTotal(200);
        t3.setDuracao(50);

        try {
            Fachada.getInstance().inserirTreino(t1);
            Fachada.getInstance().inserirTreino(t2);
            Fachada.getInstance().inserirTreino(t3);
        } catch (ObjetoDuplicadoException e) {
           e.printStackTrace();
        }
        /*Treino t1 = new Treino((ArrayList<Exercicio>) Fachada.getInstance().listarExercicios(),
                    CategoriaTreino.AEROBICO);*/

        ObservableList<ModeloPlanoTreinoCliente> result = FXCollections.observableArrayList();
        List<Treino> listaDeTreinos = Fachada.getInstance().listarTreino();
        for (Treino t : listaDeTreinos){
            result.add(new ModeloPlanoTreinoCliente(t));
        }
        tblTreino.setItems(result);
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

