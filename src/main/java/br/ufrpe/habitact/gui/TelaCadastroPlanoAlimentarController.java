package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.dados.IRepositorio;
import br.ufrpe.habitact.excecoes.MaisDeUmPlanoNoMesmoPeriodoException;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.gui.modelos.ModeloCatalogoAlimentar;
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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TelaCadastroPlanoAlimentarController {

    @FXML private DatePicker dtFim;
    @FXML private DatePicker dtInicio;
    @FXML private TextField textOutro;
    @FXML private Button btnNovoAlimento;
    @FXML private ComboBox<String> cliente;
    @FXML private RadioButton radAddCatalogo;
    @FXML private ComboBox<ObjetivoAlimentar> objetivo;
    @FXML private TableView<ModeloCatalogoAlimentar> tblAlimentos;
    @FXML private TableColumn<ModeloCatalogoAlimentar, String> colRefeicao;
    @FXML private TableColumn<ModeloCatalogoAlimentar, Boolean> colunaCheck;
    @FXML private TableColumn<ModeloCatalogoAlimentar, Double> colQtdAlimento;
    @FXML private TableColumn<ModeloCatalogoAlimentar, Double> colCaloriasAlimento;
    @FXML private TableColumn<ModeloCatalogoAlimentar, String> colNomeAlimento;

    @FXML
    public void initialize() {
        //Adiciona os valores dos enuns ObjetivoAlimentar e Refeicao em cada ComboBox
        this.objetivo.getItems().addAll(ObjetivoAlimentar.values());
        this.addClientesComboBox();

        //Setando as colunas da TableView
        this.colunaCheck.setCellValueFactory(new PropertyValueFactory<>("check"));
        this.colunaCheck.setCellFactory(CheckBoxTableCell.forTableColumn(colunaCheck));
        this.colNomeAlimento.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.colRefeicao.setCellValueFactory(new PropertyValueFactory<>("refeicao"));
        this.colQtdAlimento.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        this.colCaloriasAlimento.setCellValueFactory(new PropertyValueFactory<>("calorias"));
        this.updateCatalogoAlimentos();

    }

    private void addClientesComboBox() {
        List<Cliente> listClientes = new ArrayList<>(Fachada.getInstance().listarClientes());
        List<Cliente> clientes = listClientes.stream().filter(cliente -> cliente.getNome()
                .equals(cliente.getNome())).toList();
        for(Cliente c : clientes){
            this.cliente.getItems().addAll(c.getNome());
        }
    }

    //Habilita o campo "Outro" para digitação
    @FXML
    void optOutrosSelecionado(ActionEvent event) {
        if(objetivo.getValue().getObjetivo().equalsIgnoreCase("Outro")){
            this.textOutro.setDisable(false);
        }
    }

    @FXML
    void optAdicionarClicked(MouseEvent event) {

        //TODO pegar o Cliente selecionado no ComboBox
        PlanoAlimentar p = new PlanoAlimentar(new Cliente(), dtInicio.getValue(),
                dtFim.getValue(), objetivo.getValue());
        Sessao.getInstance().setPlanoAlimentar(p);

        try {
            Fachada.getInstance().cadastrarPlanoAlimentar(p);
        } catch (ObjetoDuplicadoException | MaisDeUmPlanoNoMesmoPeriodoException e) {
            e.getMessage();
        }

        System.out.println(p);
        this.tblAlimentos.setDisable(false);
        this.btnNovoAlimento.setDisable(false);
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

    public void updateCatalogoAlimentos() {

        ObservableList<ModeloCatalogoAlimentar> result = FXCollections.observableArrayList();
        List<Alimento> listAlimentos = Fachada.getInstance().listarAlimento();
        for (Alimento a : listAlimentos) {
            result.add(new ModeloCatalogoAlimentar(a));
        }
        tblAlimentos.setItems(result);
    }

    private void limparCamposDeDados() {
        this.textOutro.setText("");
        this.dtInicio.setValue(null);
        this.dtFim.setValue(null);
        this.tblAlimentos.getItems().clear();
        this.radAddCatalogo.setSelected(false);
        this.cliente.getSelectionModel().clearSelection();
        this.objetivo.getSelectionModel().clearSelection();
        this.tblAlimentos.getSelectionModel().clearSelection();
    }

    private boolean verificarCamposVazios() {
        return dtInicio.getValue() == null || dtFim.getValue() == null ||
                objetivo.getValue() == null && textOutro.getText().isBlank();
    }
}
