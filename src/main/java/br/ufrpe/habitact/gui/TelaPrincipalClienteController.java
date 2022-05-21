package br.ufrpe.habitact.gui;


import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.gui.GerenciadorTelas;
import br.ufrpe.habitact.gui.modelos.ModeloPlanoTreinoCliente;
import br.ufrpe.habitact.gui.modelos.ModeloRefeicao;
import br.ufrpe.habitact.gui.modelos.ModeloTreinoGui;
import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.*;
import br.ufrpe.habitact.negocio.beans.enums.Refeicao;
import br.ufrpe.habitact.sessao.Sessao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TelaPrincipalClienteController {
    @FXML private TableColumn<ModeloRefeicao, String> colAlmoco;;
    @FXML private TableColumn<ModeloRefeicao, String> colCafeDaManha;
    @FXML private Label diaDaSemanaLabel;
    @FXML private TableColumn<ModeloRefeicao, String> exercicios;
    @FXML private Label imcEAguaLabel;
    @FXML private TableColumn<ModeloRefeicao, String> colJantar;
    @FXML private TableColumn<ModeloRefeicao, String> colLanche;
    @FXML private Button meusDadosBtn;
    @FXML private Label nomeLabel;
    @FXML private AnchorPane root;
    //@FXML private TableView<ModeloTreinoGui> tblExercicios;
    @FXML private TableView<ModeloRefeicao> tblRefeicoes;
    @FXML private Button voltarBtn;
    @FXML private TableColumn<ModeloTreinoGui, Boolean> colCheck;
    @FXML private TableColumn<ModeloTreinoGui, String> colModalidade;
    @FXML private TitledPane titledAerobico;
    @FXML private TitledPane titledAnaerobico;
    @FXML private Label aaa;
    @FXML private Label bbb;
    @FXML private Label lblAerobico;
    @FXML private Label lblAnaerobico;



    @FXML
    public void initialize(){
        Cliente c1 = Sessao.getInstance().getCliente();

        String ExercicioAerobico = new String();
        String ExercicioAnaerobico = new String();
        List<Exercicio> listExercicio = Fachada.getInstance().listarExercicios();

        for(Exercicio e : listExercicio){
            if(e.toString().equals("Musculação")){
                ExercicioAnaerobico = ExercicioAerobico + e.toString() + "\n";
            }else{
                ExercicioAerobico = ExercicioAnaerobico + e.toString() + "\n";
            }
        }
        this.lblAerobico.setText(ExercicioAerobico);
        this.lblAnaerobico.setText(ExercicioAnaerobico);
        //this.colCheck.setCellValueFactory(new PropertyValueFactory<>("Check"));
        //this.colModalidade.setCellValueFactory(new PropertyValueFactory<>("Modalidade"));

        //this.colCheck.setCellFactory(CheckBoxTableCell.forTableColumn(colCheck));
        //this.updateTabelaTreino();
        this.diaDaSemanaLabel.setText(String.valueOf(LocalDate.now().getDayOfWeek()));
        //this.nomeLabel.setText("Ola, " + c1.getNome());
        //this.imcEAguaLabel.setText("Seu imc é: " + Sessao.getInstance().getUsuario());

        this.colCafeDaManha.setCellValueFactory(new PropertyValueFactory<>("Café"));
        this.colAlmoco.setCellValueFactory(new PropertyValueFactory<>("almoço"));
        this.colLanche.setCellValueFactory(new PropertyValueFactory<>("Lanhce"));
        this.colJantar.setCellValueFactory(new PropertyValueFactory<>("Jantar"));
        this.updateTabelaRefeicao();

    }


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

    //    public void updateTabelaTreino() {
//        ObservableList<ModeloTreinoGui> result = FXCollections.observableArrayList();
//        List<Treino> listTreino = Fachada.getInstance().listarTreino();
//        for (Treino a : listTreino) {
//            result.add(new ModeloTreinoGui(a));
//        }
//        tblExercicios.setItems(result);
//    }

    public void updateTabelaRefeicao() {
        ObservableList<ModeloRefeicao> resultado = FXCollections.observableArrayList();

        List<Alimento> listaDeRef = Fachada.getInstance().listarAlimento();
        for(Alimento a : listaDeRef){
            resultado.add(new ModeloRefeicao(a));
        }

        tblRefeicoes.setItems(resultado);
    }

    @FXML
    public void updateRefeicao(){
        Alimento a1 = new Alimento();
        a1.setNome("");
    }

    @FXML 
    void MeusDados(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("TelaDadosCliente");
    }

    @FXML
    void VoltarBtn(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("TelaLogin");
    }

}
