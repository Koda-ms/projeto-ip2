package br.ufrpe.habitact.gui;


import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.gui.modelos.ModeloRefeicao;
import br.ufrpe.habitact.gui.modelos.ModeloExercicioCliente;
import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.*;
import br.ufrpe.habitact.sessao.Sessao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

public class TelaPrincipalClienteController {
    @FXML private TableView<ModeloRefeicao> tblRefeicoes;
    @FXML private TableColumn<ModeloRefeicao, String> colAlmoco;;
    @FXML private TableColumn<ModeloRefeicao, String> colCafeDaManha;
    @FXML private TableColumn<ModeloRefeicao, String> colJantar;
    @FXML private TableColumn<ModeloRefeicao, String> colLanche;

    @FXML private Label txtUsuario;
    @FXML private Label txtImcAgua;
    @FXML private Label diaDaSemanaLabel;

    @FXML private TitledPane tblAnaerobico;
    @FXML private TitledPane tblAerobico;
    @FXML private TableView<ModeloExercicioCliente> tblExerciciosAnaerobico;
    @FXML private TableView<ModeloExercicioCliente> tblExerciciosAerobico;
    @FXML private TableColumn<ModeloExercicioCliente, String> colRitmo;
    @FXML private TableColumn<ModeloExercicioCliente, Double> colDuracao;
    @FXML private TableColumn<ModeloExercicioCliente, String> colExercicio;



    @FXML
    public void initialize(){
        this.diaDaSemanaLabel.setText(String.valueOf(LocalDate.now().getDayOfWeek()));
        //this.nomeLabel.setText("Ola, " + c1.getNome());
        //this.imcEAguaLabel.setText("Seu imc é: " + Sessao.getInstance().getUsuario());

        //Tabela Exercícios
        this.colDuracao.setCellValueFactory(new PropertyValueFactory<>("duracao"));
        this.colExercicio.setCellValueFactory(new PropertyValueFactory<>("exercicio"));
        this.colRitmo.setCellValueFactory(new PropertyValueFactory<>("ritmo"));
        this.updateTabelaExercicioAerobico();
        this.updateTabelaExercicioAnaerobico();

        //Tabela Refeições
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

    public void updateTabelaRefeicao() {
        ObservableList<ModeloRefeicao> resultado = FXCollections.observableArrayList();

        List<Alimento> listaDeRef = Fachada.getInstance().listarAlimento();
        for(Alimento a : listaDeRef){
            resultado.add(new ModeloRefeicao(a));
        }

        tblRefeicoes.setItems(resultado);
    }


    @FXML void tblAnaerobicoClicked(MouseEvent event) {
        this.updateTabelaExercicioAnaerobico();
        this.tblAnaerobico = new TitledPane();
        this.tblAnaerobico.setContent(tblExerciciosAnaerobico);
    }

    @FXML void tblAerobicoClicked(MouseEvent event) {
        this.updateTabelaExercicioAerobico();
        this.tblAerobico = new TitledPane();
        tblAerobico.setContent(tblExerciciosAerobico);
    }

    public void updateTabelaExercicioAerobico() {
        ObservableList<ModeloExercicioCliente> resultado = FXCollections.observableArrayList();
        Cliente c = (Cliente) Sessao.getInstance().getUsuario();

        try {
           List<PlanoTreino> listPTreino =  Fachada.getInstance().buscarPlanoTreino(c);

           for(PlanoTreino pT : listPTreino){
               for (Treino t : pT.getTreinos()){
                   for(Exercicio ex : t.getExercicios()){
                       System.out.println("\n***");
                       if(t.getModalidade().getCategoria().equalsIgnoreCase("Aeróbico")){
                           System.out.println("\n**********\n");
                           resultado.add(new ModeloExercicioCliente(ex));
                       }
                   }
               }
           }
            tblExerciciosAerobico.setItems(resultado);
        } catch (ObjetoNaoExisteException e) {
            throw new RuntimeException(e);
        }

//        List<Exercicio> listExercicio = Fachada.getInstance().listarExercicios();
//        for(Exercicio ex : listExercicio){
//
//
//        }


    }

    public void updateTabelaExercicioAnaerobico() {
        ObservableList<ModeloExercicioCliente> resultado = FXCollections.observableArrayList();
        Cliente c = (Cliente) Sessao.getInstance().getUsuario();

        try {
            List<PlanoTreino> listPTreino =  Fachada.getInstance().buscarPlanoTreino(c);

            for(PlanoTreino pT : listPTreino){
                for (Treino t : pT.getTreinos()){
                    for(Exercicio ex : t.getExercicios()){
                        System.out.println("\n..\n");
                        if(t.getModalidade().getCategoria().equalsIgnoreCase("Anaeróbico")){
                            System.out.println("\n.......\n");
                            resultado.add(new ModeloExercicioCliente(ex));
                        }
                    }
                }
            }
            tblExerciciosAnaerobico.setItems(resultado);
        } catch (ObjetoNaoExisteException e) {
            throw new RuntimeException(e);
        }
    }

    public void setInformacoes(){
        Cliente cliente = (Cliente) Sessao.getInstance().getUsuario();
        DecimalFormat formato = new DecimalFormat("#.##");
        this.txtUsuario.setText("Olá, " + cliente.getNome());
        this.txtImcAgua.setText("Seu IMC é: " + Double.valueOf(formato.format(cliente.getImc())) + " \nVocê deve consumir " +
                cliente.quantidadeDeAguaParaBeber(cliente.getPeso()) + " litros de água diariamente");
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
