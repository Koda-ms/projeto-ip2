package br.ufrpe.habitact.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TelaDeListarDadosController {
    @FXML
    private TableColumn<?, ?> clientesColuna;

    @FXML
    private TableColumn<?, ?> dtFimColuna;

    @FXML
    private TableColumn<?, ?> dtInicioColuna;
    @FXML
    private TableColumn<?, ?> objetivoColuna;

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
