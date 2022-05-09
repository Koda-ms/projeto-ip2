package br.ufrpe.habitact.gui.modelos;

import br.ufrpe.habitact.negocio.beans.PlanoAlimentar;
import javafx.beans.property.SimpleStringProperty;

public class ModeloListarDados {
    private final SimpleStringProperty nomeCliente;
    private final SimpleStringProperty dtInicio;
    private final SimpleStringProperty dtFim;
    private final SimpleStringProperty objetivo;


    public ModeloListarDados(PlanoAlimentar planoAlimentar) {
        this.nomeCliente = new SimpleStringProperty(nomeCliente.ge);
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.objetivo = objetivo;
    }
}
