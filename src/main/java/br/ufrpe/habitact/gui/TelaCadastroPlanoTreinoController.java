package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.excecoes.MaisDeUmPlanoNoMesmoPeriodoException;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.gui.modelos.ModeloPlanoTreinoCliente;
import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.Cliente;
import br.ufrpe.habitact.negocio.beans.PlanoTreino;
import br.ufrpe.habitact.negocio.beans.Treino;
import br.ufrpe.habitact.negocio.beans.enums.CategoriaTreino;
import br.ufrpe.habitact.negocio.beans.enums.ObjetivoTreino;
import br.ufrpe.habitact.sessao.Sessao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TelaCadastroPlanoTreinoController {

    @FXML private DatePicker dtFim;
    @FXML private DatePicker dtInicio;
    @FXML private TextField textOutro;
    @FXML private Button btnNovoTreino;
    @FXML private RadioButton radAddTreino;
    @FXML private ComboBox<String> cliente;
    @FXML private ComboBox<ObjetivoTreino> objetivoTreino;
    @FXML private TableView<ModeloPlanoTreinoCliente> tblTreino;
    @FXML private TableColumn<ModeloPlanoTreinoCliente, Boolean> colunaCheck;
    @FXML private TableColumn<ModeloPlanoTreinoCliente, Double> colunaCalorias;
    @FXML private TableColumn<ModeloPlanoTreinoCliente, Double> colunaDuracao;
    @FXML private TableColumn<ModeloPlanoTreinoCliente, String> coluanDiaTreino;
    @FXML private TableColumn<ModeloPlanoTreinoCliente, String> colunaCategoriaTreino;

    @FXML
    public void initialize() {
        //Adiciona os valores do enum ObjetivoTreino no ComboBox
        this.objetivoTreino.getItems().addAll(ObjetivoTreino.values());
        this.addClientesComboBox();
        //Setando as colunas da TableView
        this.colunaCheck.setCellValueFactory(new PropertyValueFactory<>("check"));
        this.colunaCheck.setCellFactory(CheckBoxTableCell.forTableColumn(colunaCheck));
        this.coluanDiaTreino.setCellValueFactory(new PropertyValueFactory<>("data"));
        this.colunaDuracao.setCellValueFactory(new PropertyValueFactory<>("duracao"));
        this.colunaCalorias.setCellValueFactory(new PropertyValueFactory<>("calorias"));
        this.colunaCategoriaTreino.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        this.updateCatalogoTreino();
    }

    private void addClientesComboBox() {
        List<Cliente> listClientes = new ArrayList<>(Fachada.getInstance().listarClientes());
        List<Cliente> clientes = listClientes.stream().filter(cliente -> cliente.getNome()
                .equals(cliente.getNome())).toList();
        for(Cliente c : clientes){
            this.cliente.getItems().addAll(c.getNome());
        }
    }

    @FXML
    void optOutrosSelecionada(ActionEvent event) {
        if(this.objetivoTreino.getValue().getObjetivo().equalsIgnoreCase("Outro")){
            this.textOutro.setDisable(false); //TODO Como seria pra armazenar esse valor em Objetivo?
        }
    }

    @FXML
    void optRadioClicked(MouseEvent event) {

        //TODO pegar o Cliente selecionado no ComboBox
        PlanoTreino p = new PlanoTreino(new Cliente(), dtInicio.getValue(), dtFim.getValue(), objetivoTreino.getValue());
        Sessao.getInstance().setPlanoTreino(p);

        try {
            Fachada.getInstance().cadastrarPlanoTreino(p);
        }catch (MaisDeUmPlanoNoMesmoPeriodoException | ObjetoDuplicadoException e) {
            e.getMessage();
        }

        this.btnNovoTreino.setDisable(false);
        this.tblTreino.setDisable(false);
        this.radAddTreino.setDisable(false);
    }

    //Direcionar para uma tela de diálogo que aparecerá sobre a tela atual
    @FXML
    void btnAddTreino(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("TelaCadastroTreino");
    }

    @FXML
    void btnCadastrarPressed(ActionEvent event) {
        if (verificarCamposVazios()) {
            GerenciadorTelas.getInstance().alertaCamposVazios();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cadastro de PLano");
            alert.setHeaderText(null);
            alert.setContentText("Seu plano foi cadastrado com sucesso!");
            alert.showAndWait();

            this.limparCamposDeDados();
        }
    }

    @FXML
    void btnVoltarPressed(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("telaPrincipalAdm");
    }

    public void updateCatalogoTreino() {

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
        this.tblTreino.getItems().clear();
        this.radAddTreino.setSelected(false);
        this.cliente.getSelectionModel().clearSelection();
        this.objetivoTreino.getSelectionModel().clearSelection();
        this.tblTreino.getSelectionModel().clearSelection();
    }

    private boolean verificarCamposVazios() {
        return dtInicio.getValue() == null || dtFim.getValue() == null ||
                objetivoTreino.getValue() == null && textOutro.getText().isBlank();
    }
}

