package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.excecoes.MaisDeUmPlanoNoMesmoPeriodoException;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.gui.modelos.ModeloCatalogoAlimentar;
import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.Alimento;
import br.ufrpe.habitact.negocio.beans.Cliente;
import br.ufrpe.habitact.negocio.beans.PlanoAlimentar;
import br.ufrpe.habitact.negocio.beans.enums.ObjetivoAlimentar;
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

public class TelaCadastroPlanoAlimentarController {

    @FXML private DatePicker dtFim;
    @FXML private DatePicker dtInicio;
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
        //Adiciona os valores do enum ObjetivoAlimentar na ComboBox
        this.objetivo.getItems().addAll(ObjetivoAlimentar.values());

        //Setando as colunas da TableView
        this.colunaCheck.setCellValueFactory(new PropertyValueFactory<>("check"));
        this.colunaCheck.setCellFactory(CheckBoxTableCell.forTableColumn(colunaCheck));
        this.colNomeAlimento.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.colRefeicao.setCellValueFactory(new PropertyValueFactory<>("refeicao"));
        this.colQtdAlimento.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        this.colCaloriasAlimento.setCellValueFactory(new PropertyValueFactory<>("calorias"));
    }

    public void addClientesComboBoxPAlimentar() {
        ObservableList<String> observableClientes = FXCollections.observableArrayList();
        List<Cliente> listClientes = new ArrayList<>(Fachada.getInstance().listarClientes());

        for(Cliente c : listClientes){
            observableClientes.add(c.getNome());
        }
        this.cliente.setItems(observableClientes);
    }

    @FXML
    void radAddClicked(MouseEvent event) {

        List<Cliente> listClientes = new ArrayList<>(Fachada.getInstance().listarClientes());
        PlanoAlimentar planoA = null;
        for(Cliente c : listClientes) {
            if (this.cliente.getValue().equals(c.getNome())) {
                planoA = new PlanoAlimentar(c, dtInicio.getValue(), dtFim.getValue(), objetivo.getValue());
            }
        }

        Sessao.getInstance().setPlanoAlimentar(planoA);
        try {
            Fachada.getInstance().cadastrarPlanoAlimentar(planoA);

            this.tblAlimentos.setDisable(false);
            this.btnNovoAlimento.setDisable(false);

        } catch (ObjetoDuplicadoException | MaisDeUmPlanoNoMesmoPeriodoException e) {
            this.alertaErroCadastro(e.getMessage());
            this.radAddCatalogo.setSelected(false);

            // Try/catch responsável por buscar o Plano A cadastrado com período igual a de um Plano anterior
            // e, então, atualizá-lo com o novo Plano A de período diferente
            try {
                List<PlanoAlimentar> planoProcurado;
                for(Cliente c : listClientes) {
                    if (this.cliente.getValue().equals(c.getNome())) {
                        planoProcurado = Fachada.getInstance().buscarPlanoAlimentar(c);
                        Fachada.getInstance().alterarPlanoAlimentar(planoProcurado.get(0), planoA);
                    }
                }
            } catch (ObjetoNaoExisteException exc) {
                this.alertaErroCadastro(exc.getMessage());
            }
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
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cadastro de PLano");
            alert.setHeaderText(null);
            alert.setContentText("Seu plano foi cadastrado com sucesso!");
            alert.showAndWait();

            this.limparCamposDeDados();
            GerenciadorTelas.getInstance().trocarTela("telaPrincipalAdm");
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

    private void alertaErroCadastro(String motivo){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Erro de cadastro");
        alerta.setHeaderText("Há um possível erro com seu cadastro");
        alerta.setContentText(motivo);
        alerta.showAndWait();
    }

    private void limparCamposDeDados() {
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
                objetivo.getValue() == null;
    }
}
