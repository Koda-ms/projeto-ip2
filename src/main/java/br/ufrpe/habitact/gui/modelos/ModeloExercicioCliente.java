package br.ufrpe.habitact.gui.modelos;

import br.ufrpe.habitact.negocio.beans.Exercicio;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class ModeloExercicioCliente {
    private final SimpleStringProperty ritmo;
    private final SimpleStringProperty exercicio;
    private final SimpleDoubleProperty duracao;

    public ModeloExercicioCliente(Exercicio exercicio) {
        this.duracao = new SimpleDoubleProperty(exercicio.getDuracaoExercicio());
        this.ritmo = new SimpleStringProperty(exercicio.getRitmo().getRitmo());
        this.exercicio = new SimpleStringProperty(exercicio.getNome().getNome());
    }

    public String getRitmo() {
        return ritmo.get();
    }

    public SimpleStringProperty ritmoProperty() {
        return ritmo;
    }

    public void setRitmo(String ritmo) {
        this.ritmo.set(ritmo);
    }

    public String getExercicio() {
        return exercicio.get();
    }

    public SimpleStringProperty exercicioProperty() {
        return exercicio;
    }

    public void setExercicio(String exercicio) {
        this.exercicio.set(exercicio);
    }

    public double getDuracao() {
        return duracao.get();
    }

    public SimpleDoubleProperty duracaoProperty() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao.set(duracao);
    }
}
