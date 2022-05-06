package br.ufrpe.habitact.gui;

import br.ufrpe.habitact.negocio.beans.enums.ObjetivoTreino;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class TelaCadastroPlanoTreinoController {

    @FXML private DatePicker dtFim;
    @FXML private DatePicker dtInicio;
    @FXML private TableColumn<?, ?> nomeTreino;
    @FXML private TableColumn<?, ?> detalheExercicio;
    @FXML private ComboBox<ObjetivoTreino> objetivo;
    @FXML private TextField textOutro;

    @FXML
    void optOutrosSelecionado(ActionEvent event) {

        //Habilita o campo Outro para digitação
        if(objetivo.getValue().getObjetivo().equalsIgnoreCase("")){
            this.textOutro.setDisable(false);
            //TODO Como seria pra armazenar esse valor em Objetivo?
        }
    }

    @FXML
    void btnAddTreino(ActionEvent event) {

    }

    @FXML
    void btnCadastrarPressed(ActionEvent event) {

    }

}

