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
import br.ufrpe.habitact.negocio.beans.enums.ObjetivoAlimentar;
import br.ufrpe.habitact.negocio.beans.enums.ObjetivoTreino;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.List;

public class TelaDeListarDadosController {
    @FXML
    private TableView<ModeloListarPlanoAlimentar> tblPlanos;
    @FXML
    private TableColumn<ModeloListarPlanoAlimentar, String> clientesColuna;

    @FXML
    private TableColumn<ModeloListarPlanoAlimentar, String> dtFimColuna;

    @FXML
    private TableColumn<ModeloListarPlanoAlimentar, String> dtInicioColuna;
    @FXML
    private TableColumn<ModeloListarPlanoAlimentar, String> objetivoColuna;

    @FXML
    private TextField txtQuantidadePlanos;
    @FXML
    private DatePicker myDatePicker;
    @FXML
    private ComboBox<String> selectPlano;

    @FXML
    private void initialize(){
        ObservableList<String> listaEscolha = FXCollections.observableArrayList("Plano Alimentar", "Plano De Treino");
        selectPlano.setItems(listaEscolha);
    }


    public void updateListaPlanoAlimentar(){
        PlanoAlimentar p1 = new PlanoAlimentar();
        p1.setDataInicio(LocalDate.of(2002, 02, 3));
        p1.setDataFim(LocalDate.of(2003, 02, 3));
        p1.setObjetivoAlimentar(ObjetivoAlimentar.SUPLEMENTACAO_ALIMENTAR);

        PlanoAlimentar p2 = new PlanoAlimentar();
        p1.setDataInicio(LocalDate.of(2004, 07, 22));
        p1.setDataFim(LocalDate.of(2005, 07, 22));
        p1.setObjetivoAlimentar(ObjetivoAlimentar.SUPLEMENTACAO_ALIMENTAR);

        PlanoAlimentar p3 = new PlanoAlimentar();
        p1.setDataInicio(LocalDate.of(2010, 05, 13));
        p1.setDataFim(LocalDate.of(2011, 05, 13));
        p1.setObjetivoAlimentar(ObjetivoAlimentar.SUPLEMENTACAO_ALIMENTAR);


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
        tblPlanos.setItems(result);
    }

    public void updateListaPlanoTreino(){
        PlanoTreino pt1;
        {
            try {
                pt1 = new PlanoTreino((Cliente) Fachada.getInstance().buscarUsuario("joao").get(0), LocalDate.of(2022,3,4),
                        LocalDate.of(2022,3,9), ObjetivoTreino.GANHAR_MASSA);
            } catch (ObjetoNaoExisteException e) {
                throw new RuntimeException(e);
            }
        }

        /*
        * PlanoAlimentar p2 = new PlanoAlimentar();
        p1.setDataInicio(LocalDate.of(2004, 07, 22));
        p1.setDataFim(LocalDate.of(2005, 07, 22));
        p1.setObjetivoAlimentar(ObjetivoAlimentar.SUPLEMENTACAO_ALIMENTAR);

        PlanoAlimentar p3 = new PlanoAlimentar();
        p1.setDataInicio(LocalDate.of(2010, 05, 13));
        p1.setDataFim(LocalDate.of(2011, 05, 13));
        p1.setObjetivoAlimentar(ObjetivoAlimentar.SUPLEMENTACAO_ALIMENTAR);
        * */


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
        tblPlanos.setItems(result);
    }

    @FXML
    void btnCadastrarPressed(ActionEvent event) {
        GerenciadorTelas.getInstance().trocarTela("popupPlanos");
    }



    @FXML
    void btnEscolherPlanoPressed(ActionEvent event) {

    }

    @FXML
    void btnPeriodoPressed(ActionEvent event) {
        LocalDate minhaData = myDatePicker.getValue();
        System.out.println(minhaData.toString());
    }

    @FXML
    void btnQuantidadeDePlanosPressed(ActionEvent event) {

    }

    @FXML
    void btnVoltarPressed(ActionEvent event) {

    }
}
