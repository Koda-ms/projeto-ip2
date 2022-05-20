package br.ufrpe.habitact.gui;


import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.gui.GerenciadorTelas;
import br.ufrpe.habitact.gui.modelos.ModeloPlanoTreinoCliente;
import br.ufrpe.habitact.gui.modelos.ModeloRefeicao;
import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.Alimento;
import br.ufrpe.habitact.negocio.beans.Cliente;
import br.ufrpe.habitact.negocio.beans.PlanoAlimentar;
import br.ufrpe.habitact.negocio.beans.PlanoTreino;
import br.ufrpe.habitact.negocio.beans.enums.Refeicao;
import br.ufrpe.habitact.sessao.Sessao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

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
    @FXML private TableView<ModeloPlanoTreinoCliente> tblExercicios;
    @FXML private TableView<ModeloRefeicao> tblRefeicoes;
    @FXML private Button voltarBtn;

    public void initialize(){
        this.diaDaSemanaLabel.setText(String.valueOf(LocalDate.now().getDayOfWeek()));
        this.nomeLabel.setText("Ola, " + Sessao.getInstance().getUsuario().getNome());

        this.colCafeDaManha.setCellValueFactory(new PropertyValueFactory<>("Café"));
        this.colAlmoco.setCellValueFactory(new PropertyValueFactory<>("almoço"));
        this.colLanche.setCellValueFactory(new PropertyValueFactory<>("Lanhce"));
        this.colJantar.setCellValueFactory(new PropertyValueFactory<>("Jantar"));
        this.updateTabelaRefeicao();
    }

    private void updateTabelaRefeicao() {
        ObservableList<ModeloRefeicao> resultado = FXCollections.observableArrayList();

        List<Alimento> listaDeRef = Fachada.getInstance().listarAlimento();
        for(Alimento a : listaDeRef){
            resultado.add(new ModeloRefeicao(a));
        }

        tblRefeicoes.setItems(resultado);
    }

    @FXML
    private void updateRefeicao(){
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
