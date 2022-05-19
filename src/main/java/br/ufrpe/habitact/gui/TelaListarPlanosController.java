package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.excecoes.MaisDeUmPlanoNoMesmoPeriodoException;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.gui.modelos.ModeloListarPlanoAlimentar;
import br.ufrpe.habitact.gui.modelos.ModeloListarPlanoTreino;
import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.Cliente;
import br.ufrpe.habitact.negocio.beans.PlanoAlimentar;
import br.ufrpe.habitact.negocio.beans.PlanoTreino;
import br.ufrpe.habitact.negocio.beans.Usuario;
import br.ufrpe.habitact.negocio.beans.enums.ObjetivoAlimentar;
import br.ufrpe.habitact.negocio.beans.enums.ObjetivoTreino;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.List;

public class TelaListarPlanosController {
    @FXML private TableView<ModeloListarPlanoAlimentar> tblPlanoAlimentar;

    @FXML private TableView<ModeloListarPlanoTreino> tblPlanoTreino;
//    @FXML private TableColumn<ModeloListarPlanoAlimentar, String> clientesColuna;
//    @FXML private TableColumn<ModeloListarPlanoAlimentar, String> dtFimColuna;
//    @FXML private TableColumn<ModeloListarPlanoAlimentar, String> dtInicioColuna;
//    @FXML private TableColumn<ModeloListarPlanoAlimentar, String> objetivoColuna;
//
//    @FXML private TableColumn<ModeloListarPlanoTreino, String> dtFimColunaTreino;
//    @FXML private TableColumn<ModeloListarPlanoTreino, String> dtInicioColunaTreino;
//    @FXML private TableColumn<ModeloListarPlanoTreino, String> objetivoTreinoColuna;

//    @FXML
//    private void initialize(){
//        updateListaPlanoAlimentar();
//        try {
//            updateListaPlanoTreino();
//        } catch (ObjetoDuplicadoException e) {
//            e.printStackTrace();
//        }
//    }

    public void updateListaPlanoAlimentar(){
        Usuario c1 = new Cliente("Apolo","apolo.com","apolo", LocalDate.of(2000,06,03),
                "Masculine",114.00,1.79, true);
        PlanoAlimentar p1 = new PlanoAlimentar();
        p1.setCliente((Cliente) c1);
        p1.setDataInicio(LocalDate.of(2002, 02, 3));
        p1.setDataFim(LocalDate.of(2003, 02, 3));
        p1.setObjetivoAlimentar(ObjetivoAlimentar.SUPLEMENTACAO_ALIMENTAR);

        PlanoAlimentar p2 = new PlanoAlimentar();
        p2.setCliente((Cliente) c1);
        p2.setDataInicio(LocalDate.of(2004, 07, 22));
        p2.setDataFim(LocalDate.of(2005, 07, 22));
        p2.setObjetivoAlimentar(ObjetivoAlimentar.SUPLEMENTACAO_ALIMENTAR);

        PlanoAlimentar p3 = new PlanoAlimentar();
        p3.setCliente((Cliente) c1);
        p3.setDataInicio(LocalDate.of(2010, 05, 13));
        p3.setDataFim(LocalDate.of(2011, 05, 13));
        p3.setObjetivoAlimentar(ObjetivoAlimentar.SUPLEMENTACAO_ALIMENTAR);


        try {
            Fachada.getInstance().cadastrarPlanoAlimentar(p1);
            Fachada.getInstance().cadastrarPlanoAlimentar(p2);
            Fachada.getInstance().cadastrarPlanoAlimentar(p3);
        } catch (ObjetoDuplicadoException | MaisDeUmPlanoNoMesmoPeriodoException e) {
            e.printStackTrace();
        }

        ObservableList<ModeloListarPlanoAlimentar> result = FXCollections.observableArrayList();
        List<PlanoAlimentar> listaPlanos = Fachada.getInstance().listarPlanoAlimentar();
        for (PlanoAlimentar p: listaPlanos){
            result.add(new ModeloListarPlanoAlimentar(p));
        }
        tblPlanoAlimentar.setItems(result);

    }

    public void updateListaPlanoTreino() throws ObjetoDuplicadoException {
        Usuario c1 = new Cliente("Apolo","apolo.com","apolo",
                LocalDate.of(2000,06,03), "Masculine",114.00,
                1.79, true);
        Fachada.getInstance().cadastrarUsuario(c1);
        PlanoTreino pt1;
        {
            try {
                pt1 = new PlanoTreino((Cliente) Fachada.getInstance().buscarUsuario("Apolo").get(0),
                        LocalDate.of(2022,3,4),
                        LocalDate.of(2022,3,9), ObjetivoTreino.GANHAR_MASSA);
            } catch (ObjetoNaoExisteException e) {
                throw new RuntimeException(e);
            }
        }

        /*
         PlanoAlimentar p2 = new PlanoAlimentar();
        p1.setDataInicio(LocalDate.of(2004, 07, 22));
        p1.setDataFim(LocalDate.of(2005, 07, 22));
        p1.setObjetivoAlimentar(ObjetivoAlimentar.SUPLEMENTACAO_ALIMENTAR);

        PlanoAlimentar p3 = new PlanoAlimentar();
        p1.setDataInicio(LocalDate.of(2010, 05, 13));
        p1.setDataFim(LocalDate.of(2011, 05, 13));
        p1.setObjetivoAlimentar(ObjetivoAlimentar.SUPLEMENTACAO_ALIMENTAR);
        */


        try {
            Fachada.getInstance().cadastrarPlanoTreino(pt1);
           // Fachada.getInstance().cadastrarPlanoAlimentar(p2);
            //Fachada.getInstance().cadastrarPlanoAlimentar(p3);
        } catch (ObjetoDuplicadoException | MaisDeUmPlanoNoMesmoPeriodoException e) {
            e.printStackTrace();
        }

        ObservableList<ModeloListarPlanoTreino> result = FXCollections.observableArrayList();
        List<PlanoTreino> listaPlanos = Fachada.getInstance().listarPlanoTreino();
        for (PlanoTreino p: listaPlanos){
            result.add(new ModeloListarPlanoTreino(p));
        }
        tblPlanoTreino.setItems(result);
    }

    @FXML
    int totalDePlanos(ActionEvent event) {
        int pA = Fachada.getInstance().listarPlanoAlimentar().size();
        int pT = Fachada.getInstance().listarPlanoTreino().size();
        return pA + pT;
    }

    @FXML
    void btnVoltarPressed(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("TelaPrincipalCliente");
    }
}
