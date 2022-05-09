package br.ufrpe.habitact.gui.modelos;

import br.ufrpe.habitact.negocio.beans.PlanoAlimentar;
import javafx.beans.property.SimpleStringProperty;

import java.time.format.DateTimeFormatter;

public class ModeloPlanoAlimentar {
    private final SimpleStringProperty cliente;
    private final SimpleStringProperty dtInicio;
    private final SimpleStringProperty dtFim;

    public ModeloPlanoAlimentar(PlanoAlimentar planoAlimentar){
        this.cliente = new SimpleStringProperty(planoAlimentar.getCliente().getNome());
        String dataInicioFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(planoAlimentar.getDataInicio());
        this.dtInicio = new SimpleStringProperty(dataInicioFormatada);
        String dataFimFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(planoAlimentar.getDataFim());
        this.dtFim = new SimpleStringProperty(dataFimFormatada);
    }

    public String getCliente() {
        return cliente.get();
    }

    public SimpleStringProperty clienteProperty() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente.set(cliente);
    }

    public String getDtInicio() {
        return dtInicio.get();
    }

    public SimpleStringProperty dtInicioProperty() {
        return dtInicio;
    }

    public void setDtInicio(String dtInicio) {
        this.dtInicio.set(dtInicio);
    }

    public String getDtFim() {
        return dtFim.get();
    }

    public SimpleStringProperty dtFimProperty() {
        return dtFim;
    }

    public void setDtFim(String dtFim) {
        this.dtFim.set(dtFim);
    }
}
