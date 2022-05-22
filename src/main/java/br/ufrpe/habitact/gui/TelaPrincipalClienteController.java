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
    @FXML private TableColumn<ModeloRefeicao, String> colJantar;
    @FXML private TableColumn<ModeloRefeicao, String> colLanche;
    @FXML private Label diaDaSemanaLabel;
    @FXML private Label txtImcAgua;
    @FXML private Button meusDadosBtn;
    @FXML private Label txtUsuario;
    @FXML private AnchorPane root;
    //@FXML private TableView<ModeloTreinoGui> tblExercicios;
    @FXML private TableView<ModeloRefeicao> tblRefeicoes;
    @FXML private Button voltarBtn;
    @FXML private TableColumn<ModeloTreinoGui, Boolean> colCheck;
    @FXML private TableColumn<ModeloTreinoGui, String> colModalidade;
    @FXML private TitledPane titledAerobico;
    @FXML private TitledPane titledAnaerobico;
    @FXML private Label lblAerobico;
    @FXML private Label lblAnaerobico;




    @FXML
    public void initialize(){
        //this.colCheck.setCellValueFactory(new PropertyValueFactory<>("Check"));
        //this.colModalidade.setCellValueFactory(new PropertyValueFactory<>("Modalidade"));

        //this.colCheck.setCellFactory(CheckBoxTableCell.forTableColumn(colCheck));
        //this.updateTabelaTreino();
        this.diaDaSemanaLabel.setText(String.valueOf(LocalDate.now().getDayOfWeek()));
        //this.nomeLabel.setText("Ola, " + c1.getNome());
        //this.imcEAguaLabel.setText("Seu imc é: " + Sessao.getInstance().getUsuario());

        this.colCafeDaManha.setCellValueFactory(new PropertyValueFactory<>("cafe"));
        this.colAlmoco.setCellValueFactory(new PropertyValueFactory<>("almoco"));
        this.colLanche.setCellValueFactory(new PropertyValueFactory<>("lanche"));
        this.colJantar.setCellValueFactory(new PropertyValueFactory<>("jantar"));
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
    void MeusDados(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("TelaDadosCliente");
    }

    @FXML
    void VoltarBtn(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("TelaLogin");
    }


    public void setInformacoes(){
        Cliente cliente = (Cliente) Sessao.getInstance().getUsuario();
        txtUsuario.setText("Ola, " + cliente.getNome());
        txtImcAgua.setText("Seu imc é: " + cliente.getImc() + " Você deve consumir " + cliente.quantidadeDeAguaParaBeber(cliente.getPeso()) + " Litros de água hoje");
    }

    public void setTreinos(){
        Cliente cliente = (Cliente) Sessao.getInstance().getUsuario();
        String ExercicioAerobico = new String();
        String ExercicioAnaerobico = new String();
        List<Exercicio> listExercicio = Fachada.getInstance().listarExercicios();

        for(Exercicio e : listExercicio){
            if(e.getNome().equals("Musculação")){
                ExercicioAnaerobico = ExercicioAerobico + e.getNome() + "\n";
            }else{
                ExercicioAerobico = ExercicioAnaerobico + e.getNome() + "\n";
            }
        }
        titledAerobico.setContent(new Label(ExercicioAerobico));
        titledAnaerobico.setContent(new Label(ExercicioAnaerobico));
    }
}
