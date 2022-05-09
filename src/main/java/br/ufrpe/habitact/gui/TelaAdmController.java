package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.excecoes.MaisDeUmPlanoNoMesmoPeriodoException;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.gui.modelos.ModeloCliente;
import br.ufrpe.habitact.gui.modelos.ModeloPlanoAlimentar;
import br.ufrpe.habitact.gui.modelos.ModeloPlanoTreino;
import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.Cliente;
import br.ufrpe.habitact.negocio.beans.PlanoAlimentar;
import br.ufrpe.habitact.negocio.beans.PlanoTreino;
import br.ufrpe.habitact.negocio.beans.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.List;

import static br.ufrpe.habitact.negocio.beans.enums.ObjetivoAlimentar.MELHORAR_ALIMENTACAO;
import static br.ufrpe.habitact.negocio.beans.enums.ObjetivoTreino.PERDER_MASSA;

public class TelaAdmController {

    @FXML private Button bottonCadastrarPlanos;
    @FXML private Button bottonGerarRelatórios;
    @FXML private Button bottonSair;

    @FXML private TableColumn<ModeloPlanoAlimentar, String> colunaClientePlanoAlimentar;
    @FXML private TableColumn<ModeloPlanoAlimentar, String> colunaDtInicioPlanoAlimentar;
    @FXML private TableColumn<ModeloPlanoAlimentar, String> colunaDtFimPlanoAlimentar;
    @FXML private TableView<ModeloPlanoAlimentar> tablePlanosAlimentares;

    @FXML private TableColumn<ModeloPlanoTreino, String> colunaClientePlanoTreino;
    @FXML private TableColumn<ModeloPlanoTreino, String> colunaDtInicioPlanoTreino;
    @FXML private TableColumn<ModeloPlanoTreino, String> colunaDtFimPlanoTreino;
    @FXML private TableView<ModeloPlanoTreino> tablePlanosTreinos;

    @FXML private TableColumn<ModeloCliente, String> colunaGeneroClientes;
    @FXML private TableColumn<ModeloCliente, Long> colunaIdadeClientes;
    @FXML private TableColumn<ModeloCliente, String> colunaNomeClientes;
    @FXML private TableView<ModeloCliente> tableClientes;

    @FXML
    public void initialize(){
        colunaGeneroClientes.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colunaIdadeClientes.setCellValueFactory(new PropertyValueFactory<>("idade"));
        colunaNomeClientes.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.updateListaClientes();

        colunaClientePlanoAlimentar.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colunaDtInicioPlanoAlimentar.setCellValueFactory(new PropertyValueFactory<>("dtInicio"));
        colunaDtFimPlanoAlimentar.setCellValueFactory(new PropertyValueFactory<>("dtFim"));
        try {
            this.updateListaPlanoAlimentar();
        } catch (ObjetoNaoExisteException e) {
            e.printStackTrace();
        }

        colunaClientePlanoTreino.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colunaDtInicioPlanoTreino.setCellValueFactory(new PropertyValueFactory<>("dtInicio"));
        colunaDtFimPlanoTreino.setCellValueFactory(new PropertyValueFactory<>("dtFim"));
        try {
            this.updateListaPlanoTreino();
        } catch (ObjetoNaoExisteException e) {
            e.printStackTrace();
        }

    }

    public void updateListaClientes() {
        Usuario c1 = new Cliente("Apolo","apolo.com","apolo", LocalDate.of(2000,06,03),
                "Masculine",114.00,1.79, true);
        Usuario c2 = new Cliente("July","july.com","apolo", LocalDate.of(2001,06,03),
                "Feminine",114.00,1.79, true);
        Usuario c3 = new Cliente("Lays","lays.com","apolo", LocalDate.of(2002,06,03),
                "Feminine",114.00,1.79, true);
        Usuario c4 = new Cliente("Teteu","teteu.com","apolo", LocalDate.of(2003,06,03),
                "Masculine",114.00,1.79, true);
        Usuario c5 = new Cliente("Joao","joao.com","apolo", LocalDate.of(2004,06,03),
                "Masculine",114.00,1.79, true);
        try {
            Fachada.getInstance().cadastrarUsuario(c1);
            Fachada.getInstance().cadastrarUsuario(c2);
            Fachada.getInstance().cadastrarUsuario(c3);
            Fachada.getInstance().cadastrarUsuario(c4);
            Fachada.getInstance().cadastrarUsuario(c5);
        } catch (ObjetoDuplicadoException e) {
            e.printStackTrace();
        }

        ObservableList<ModeloCliente> result = FXCollections.observableArrayList();
        List<Usuario> listaUsuarios = Fachada.getInstance().listarUsuarios();
        for(Usuario u: listaUsuarios){
            if (u instanceof Cliente){
                result.add(new ModeloCliente((Cliente) u));
            }
        }
        tableClientes.setItems(result);
    }

    public void updateListaPlanoAlimentar() throws ObjetoNaoExisteException {
        PlanoAlimentar p1 = new PlanoAlimentar((Cliente)Fachada.getInstance().buscarUsuario("Apolo").get(0),
                LocalDate.of(2022,05,01), LocalDate.of(2022,05,07), MELHORAR_ALIMENTACAO);
        PlanoAlimentar p2 = new PlanoAlimentar((Cliente)Fachada.getInstance().buscarUsuario("July").get(0),
                LocalDate.of(2022,05,01), LocalDate.of(2022,05,07), MELHORAR_ALIMENTACAO);
        PlanoAlimentar p3 = new PlanoAlimentar((Cliente)Fachada.getInstance().buscarUsuario("Lays").get(0),
                LocalDate.of(2022,05,01), LocalDate.of(2022,05,07), MELHORAR_ALIMENTACAO);
        PlanoAlimentar p4 = new PlanoAlimentar((Cliente)Fachada.getInstance().buscarUsuario("Teteu").get(0),
                LocalDate.of(2022,05,01), LocalDate.of(2022,05,07), MELHORAR_ALIMENTACAO);
        PlanoAlimentar p5 = new PlanoAlimentar((Cliente)Fachada.getInstance().buscarUsuario("Joao").get(0),
                LocalDate.of(2022,05,01), LocalDate.of(2022,05,07), MELHORAR_ALIMENTACAO);
        try {
            Fachada.getInstance().cadastrarPlanoAlimentar(p1);
            Fachada.getInstance().cadastrarPlanoAlimentar(p2);
            Fachada.getInstance().cadastrarPlanoAlimentar(p3);
            Fachada.getInstance().cadastrarPlanoAlimentar(p4);
            Fachada.getInstance().cadastrarPlanoAlimentar(p5);
        } catch (MaisDeUmPlanoNoMesmoPeriodoException | ObjetoDuplicadoException e) {
            e.printStackTrace();
        }

        ObservableList<ModeloPlanoAlimentar> result = FXCollections.observableArrayList();
        List<PlanoAlimentar> listaPlanos = Fachada.getInstance().listarPlanoAlimentar();
        for (PlanoAlimentar p: listaPlanos){
            result.add(new ModeloPlanoAlimentar(p));
        }
        tablePlanosAlimentares.setItems(result);
    }

    public void updateListaPlanoTreino() throws ObjetoNaoExisteException {
        PlanoTreino p1 = new PlanoTreino((Cliente)Fachada.getInstance().buscarUsuario("Apolo").get(0),
                LocalDate.of(2022,05,01), LocalDate.of(2022,05,07), PERDER_MASSA);
        PlanoTreino p2 = new PlanoTreino((Cliente)Fachada.getInstance().buscarUsuario("July").get(0),
                LocalDate.of(2022,05,01), LocalDate.of(2022,05,07), PERDER_MASSA);
        PlanoTreino p3 = new PlanoTreino((Cliente)Fachada.getInstance().buscarUsuario("Lays").get(0),
                LocalDate.of(2022,05,01), LocalDate.of(2022,05,07), PERDER_MASSA);
        PlanoTreino p4 = new PlanoTreino((Cliente)Fachada.getInstance().buscarUsuario("Teteu").get(0),
                LocalDate.of(2022,05,01), LocalDate.of(2022,05,07), PERDER_MASSA);
        PlanoTreino p5 = new PlanoTreino((Cliente)Fachada.getInstance().buscarUsuario("Joao").get(0),
                LocalDate.of(2022,05,01), LocalDate.of(2022,05,07), PERDER_MASSA);
        PlanoTreino p6 = new PlanoTreino((Cliente)Fachada.getInstance().buscarUsuario("Joao").get(0),
                LocalDate.of(2022,04,01), LocalDate.of(2022,04,07), PERDER_MASSA);
        PlanoTreino p7 = new PlanoTreino((Cliente)Fachada.getInstance().buscarUsuario("Joao").get(0),
                LocalDate.of(2022,03,01), LocalDate.of(2022,03,07), PERDER_MASSA);
        PlanoTreino p8 = new PlanoTreino((Cliente)Fachada.getInstance().buscarUsuario("Joao").get(0),
                LocalDate.of(2022,02,01), LocalDate.of(2022,02,07), PERDER_MASSA);
        PlanoTreino p9 = new PlanoTreino((Cliente)Fachada.getInstance().buscarUsuario("Joao").get(0),
                LocalDate.of(2022,01,01), LocalDate.of(2022,01,07), PERDER_MASSA);
        try {
            Fachada.getInstance().cadastrarPlanoTreino(p1);
            Fachada.getInstance().cadastrarPlanoTreino(p2);
            Fachada.getInstance().cadastrarPlanoTreino(p3);
            Fachada.getInstance().cadastrarPlanoTreino(p4);
            Fachada.getInstance().cadastrarPlanoTreino(p5);
            Fachada.getInstance().cadastrarPlanoTreino(p6);
            Fachada.getInstance().cadastrarPlanoTreino(p7);
            Fachada.getInstance().cadastrarPlanoTreino(p8);
            Fachada.getInstance().cadastrarPlanoTreino(p9);
        } catch (MaisDeUmPlanoNoMesmoPeriodoException | ObjetoDuplicadoException e) {
            e.printStackTrace();
        }

        ObservableList<ModeloPlanoTreino> result = FXCollections.observableArrayList();
        List<PlanoTreino> listaPlanos = Fachada.getInstance().listarPlanoTreino();
        for (PlanoTreino p: listaPlanos){
            result.add(new ModeloPlanoTreino(p));
        }
        tablePlanosTreinos.setItems(result);
    }
}
