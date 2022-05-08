package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.Alimento;
import br.ufrpe.habitact.negocio.beans.enums.ObjetivoAlimentar;
import br.ufrpe.habitact.negocio.beans.enums.Refeicao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TelaCadastroPlanoAlimentarController {

    @FXML private Button btnCancelarCadastrarPressed;
    @FXML private DatePicker dtFim;
    @FXML private DatePicker dtInicio;
    @FXML private ComboBox<ObjetivoAlimentar> objetivo;
    @FXML private ComboBox<Refeicao> refeicao;
    private ObservableList<Alimento> alimentoObservableList;
    @FXML private TableView<Alimento> tblAlimentos;
    @FXML private TableColumn<Alimento, Integer> colQtdAlimento;
    @FXML private TableColumn<Alimento, Double> colCaloriasAlimento;
    @FXML private TableColumn<Alimento, String> colNomeAlimento;
    @FXML private TextField textOutro;

    public void initialize() {
        //Adiciona os valores dos enuns ObjetivoAlimentar e Refeicao em cada ComboBox
        this.objetivo.getItems().addAll(ObjetivoAlimentar.values());
        this.refeicao.getItems().addAll(Refeicao.values());

        //TODO inicializar a tableView
        this.initializeTableViews();
        this.carregarTableViewAlimentos(Fachada.getInstance().listarAlimento().stream()
                .filter(alimento -> alimento.getRefeicao().equals(refeicao.getValue())).collect(Collectors.toList()));
    }

    //Habilita o campo Outro para digitação
    @FXML
    void optOutrosSelecionado(ActionEvent event) {
        if(objetivo.getValue().getObjetivo().equalsIgnoreCase("")){
            this.textOutro.setDisable(false);
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

            //TODO Criar atributo static para usuário ser cadastrado junto. Mas, precisa saber em qual tela...
            /*PlanoAlimentar p = new PlanoAlimentar(usuario, dtInicio.getValue(), dtFim.getValue(),
                  objetivo.getValue());

            try {
                Fachada.getInstance().cadastrarPlanoAlimentar(p);
            } catch (ObjetoDuplicadoException | MaisDeUmPlanoNoMesmoPeriodoException e) {
                e.getMessage();
            }*/

            this.limparCamposDeDados();
            ((Stage)this.btnCancelarCadastrarPressed.getScene().getWindow()).close();
        }
    }

    @FXML
    void btnVoltarTela(ActionEvent event) {
        //GerenciadorTelas.getInstance().trocarTela("listarDadosSistema");
    }

    public void initializeTableViews(){
        colNomeAlimento.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colQtdAlimento.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colCaloriasAlimento.setCellValueFactory(new PropertyValueFactory<>("calorias"));
    }

    protected void carregarTableViewAlimentos(List<Alimento> alimentosList) {

        tblAlimentos.getItems().clear();
        List<Alimento> a = new ArrayList<>();

        for (Alimento alimentos : alimentosList) { //TODO alimentosList tem tamanho zero, logo o for não é executado. Verificar por quê.
            Alimento alimento = new Alimento(alimentos.getNome(), alimentos.getQtdGrama(), alimentos.getCalorias(),
                    alimentos.getRefeicao(), alimentos.getDiaDoAlimento());
            a.add(alimento);
            alimentoObservableList = FXCollections.observableList(a);
            tblAlimentos.setItems(alimentoObservableList);
        }
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
