package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.negocio.ControladorAlimento;
import br.ufrpe.habitact.negocio.beans.Alimento;
import br.ufrpe.habitact.negocio.beans.enums.ObjetivoAlimentar;
import br.ufrpe.habitact.negocio.beans.enums.Refeicao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TelaCadastroPlanoAlimentarController {
    //private Usuario usuario;
    @FXML private DatePicker dtFim;
    @FXML private DatePicker dtInicio;
    @FXML private ComboBox<ObjetivoAlimentar> objetivo;
    @FXML private TableColumn<?, ?> qtdAlimento;
    @FXML private TableColumn<?, ?> caloriasAlimento;
    @FXML private TableColumn<?, ?> nomeAlimento;
    @FXML private ComboBox<Refeicao> refeicao;
    @FXML private TextField textOutro;

    public void initialize() {
        //Adiciona os valores dos enuns ObjetivoAlimentar e Refeicao em cada ComboBox
        this.objetivo.getItems().addAll(ObjetivoAlimentar.values());
        this.refeicao.getItems().addAll(Refeicao.values());
        //Adicionando alimentos para visualização na TableView do Catálogo
        ListView<Alimento> listaAlimentos = new ListView<>();
        ObservableList<Alimento> alimentos = FXCollections.observableArrayList(ControladorAlimento.getInstance().listarAlimento());
        listaAlimentos.setItems(alimentos);

        if (listaAlimentos == null) {
            System.out.println("Você não possui alimentos cadastrados");
        }
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no Cadastro");
            alert.setHeaderText("Campo vazio");
            alert.setContentText("Verifique o(s) campo(s) vazio(s) do seu cadastro");
            alert.showAndWait();
        } else {


            //TODO colocação do USUARIO no Construtor abaixo. Verificar se correta
            //PlanoAlimentar cadastrarPlano = new PlanoAlimentar(usuario, dtInicio.getValue(), dtFim.getValue(),
            //      objetivo.getValue());

            //TODO redirecionar a tela para a anterior: Tela Listar Dados do Sistema
            //GerenciadorTelas.getInstance().getTelaListarDadosSistemaController().initialize();
        }
    }

    @FXML
    void btnVoltarTela(ActionEvent event) {
        //TODO direcionar para a tela anterior: Tela de Listar Dados do Sistema
    }

    private boolean verificarCamposVazios() {
        return dtInicio.getValue().isEqual(null) || dtFim.getValue().isEqual(null)
                || objetivo.getValue().equals(null) || textOutro.getText().isBlank()
                || refeicao.getValue().equals(null);
    }
}
