package br.ufrpe.habitact.gui.modelos;

import br.ufrpe.habitact.negocio.beans.PlanoAlimentar;
import br.ufrpe.habitact.negocio.beans.PlanoTreino;
import javafx.beans.property.SimpleStringProperty;

import java.time.format.DateTimeFormatter;

public class ModeloListarPlanoTreino {
    private final SimpleStringProperty dtInicio;
    private final SimpleStringProperty dtFim;
    private final SimpleStringProperty objetivo;


    public ModeloListarPlanoTreino(PlanoTreino planoTreino) {
        String dataFormatadaInicio = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(planoTreino.getDataInicio());
        String dataFormatadaFim = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(planoTreino.getDataFim());
        this.dtInicio = new SimpleStringProperty(dataFormatadaInicio);
        this.dtFim = new SimpleStringProperty(dataFormatadaFim);
        this.objetivo = new SimpleStringProperty(planoTreino.getObjetivoTreino().getObjetivo());
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
