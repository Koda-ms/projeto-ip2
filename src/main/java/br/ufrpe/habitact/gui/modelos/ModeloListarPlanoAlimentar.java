package br.ufrpe.habitact.gui.modelos;

import br.ufrpe.habitact.negocio.beans.PlanoAlimentar;
import javafx.beans.property.SimpleStringProperty;

import java.time.format.DateTimeFormatter;

public class ModeloListarPlanoAlimentar {
    private final SimpleStringProperty dtInicio;
    private final SimpleStringProperty dtFim;
    private final SimpleStringProperty objetivo;


    public ModeloListarPlanoAlimentar(PlanoAlimentar planoAlimentar) {
        String dataFormatadaInicio = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(planoAlimentar.getDataInicio());
        String dataFormatadaFim = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(planoAlimentar.getDataFim());
        this.dtInicio = new SimpleStringProperty(dataFormatadaInicio);
        this.dtFim = new SimpleStringProperty(dataFormatadaFim);
        this.objetivo = new SimpleStringProperty(planoAlimentar.getObjetivoAlimentar().getObjetivo());
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

    public String getObjetivo() {
        return objetivo.get();
    }

    public SimpleStringProperty objetivoProperty() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo.set(objetivo);
    }
}
