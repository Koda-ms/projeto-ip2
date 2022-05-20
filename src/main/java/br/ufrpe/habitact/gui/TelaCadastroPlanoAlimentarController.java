package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.excecoes.MaisDeUmPlanoNoMesmoPeriodoException;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.gui.modelos.ModeloPlanoAlimentarCliente;
import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.Alimento;
import br.ufrpe.habitact.negocio.beans.Cliente;
import br.ufrpe.habitact.negocio.beans.PlanoAlimentar;
import br.ufrpe.habitact.negocio.beans.enums.ObjetivoAlimentar;
import br.ufrpe.habitact.negocio.beans.enums.Refeicao;
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
import java.util.stream.Collectors;

public class TelaCadastroPlanoAlimentarController {

    @FXML private DatePicker dtFim;
    @FXML private DatePicker dtInicio;
    @FXML private TextField textOutro;
    @FXML private ComboBox<Refeicao> refeicao;
    @FXML private ComboBox<ObjetivoAlimentar> objetivo;
    @FXML private TableView<ModeloPlanoAlimentarCliente> tblAlimentos;
    @FXML private TableColumn<ModeloPlanoAlimentarCliente, Boolean> colunaCheck;
    @FXML private TableColumn<ModeloPlanoAlimentarCliente, Double> colQtdAlimento;
    @FXML private TableColumn<ModeloPlanoAlimentarCliente, Double> colCaloriasAlimento;
    @FXML private TableColumn<ModeloPlanoAlimentarCliente, String> colNomeAlimento;

    public void initialize() {
        //Adiciona os valores dos enuns ObjetivoAlimentar e Refeicao em cada ComboBox
        this.objetivo.getItems().addAll(ObjetivoAlimentar.values());
        this.refeicao.getItems().addAll(Refeicao.values());

        //Setando as colunas da TableView
        this.colunaCheck.setCellValueFactory(new PropertyValueFactory<>("check"));
        this.colunaCheck.setCellFactory(CheckBoxTableCell.forTableColumn(colunaCheck));
        this.colNomeAlimento.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.colQtdAlimento.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        this.colCaloriasAlimento.setCellValueFactory(new PropertyValueFactory<>("calorias"));
        this.updateCatalogoAlimentos();

    }

    //Habilita o campo "Outro" para digitação
    @FXML
    void optOutrosSelecionado(ActionEvent event) {
        if(objetivo.getValue().getObjetivo().equalsIgnoreCase("Outro")){
            this.textOutro.setDisable(false);
        }
    }

    @FXML
    void optRefeicaoSelecionada(ActionEvent event) {
        Alimento a = new Alimento();
        a.getRefeicao().getRefeicao();
        if(refeicao.getValue().getRefeicao().equalsIgnoreCase("Almoço")){
            /*this.tblAlimentos.getItems().stream().filter(comida -> comida.equals(a.getRefeicao()
                    .equalsIgnoreCase("Almoço")));*/
        }
    }

    //Direcionar para uma tela de diálogo que aparecerá sobre a tela atual
    @FXML
    void btnAddAlimento(ActionEvent event) {
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
            PlanoAlimentar p = new PlanoAlimentar((Cliente) Sessao.getInstance().getUsuario(), dtInicio.getValue(),
                    dtFim.getValue(), objetivo.getValue());

            try {
                Fachada.getInstance().cadastrarPlanoAlimentar(p);
            } catch (ObjetoDuplicadoException | MaisDeUmPlanoNoMesmoPeriodoException e) {
                e.getMessage();
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cadastro de PLano");
            alert.setHeaderText(null);
            alert.setContentText("Seu plano foi cadastrado com sucesso!");
            alert.showAndWait();

            this.limparCamposDeDados();
        }
    }

    @FXML
    void btnVoltarTela(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("telaPrincipalAdm");
    }

    private void updateCatalogoAlimentos() {
        Alimento a1 = new Alimento(Refeicao.CAFÉ_DA_MANHÃ, "Pão Integral", 25, 137);
        Alimento a2 = new Alimento(Refeicao.ALMOÇO, "Feijão", 100, 79);
        Alimento a3 = new Alimento(Refeicao.ALMOÇO, "Arroz", 100, 129);
        Alimento a4 = new Alimento(Refeicao.LANCHE, "Sorvete", 60, 95);
        Alimento a5 = new Alimento(Refeicao.JANTAR, "Ovo", 30, 74);

        try {
            Fachada.getInstance().adicionarAlimento(a1);
            Fachada.getInstance().adicionarAlimento(a2);
            Fachada.getInstance().adicionarAlimento(a3);
            Fachada.getInstance().adicionarAlimento(a4);
            Fachada.getInstance().adicionarAlimento(a5);
        } catch (ObjetoDuplicadoException e) {
            e.printStackTrace();
        }

        ObservableList<ModeloPlanoAlimentarCliente> result = FXCollections.observableArrayList();
        List<Alimento> listaDeAlimentos = Fachada.getInstance().listarAlimento();
        for (Alimento a : listaDeAlimentos) {
            result.add(new ModeloPlanoAlimentarCliente(a));
        }
        tblAlimentos.setItems(result);
    }

    private void limparCamposDeDados() {
        this.textOutro.setText("");
        this.dtInicio.setValue(null);
        this.dtFim.setValue(null);
        this.refeicao.getSelectionModel().clearSelection();
        this.objetivo.getSelectionModel().clearSelection();
        this.tblAlimentos.getSelectionModel().clearSelection();
    }

    private boolean verificarCamposVazios() {
        return dtInicio.getValue() == null || dtFim.getValue() == null ||
                refeicao.getValue() == null || objetivo.getValue() == null &&
                textOutro.getText().isBlank();
    }
}
