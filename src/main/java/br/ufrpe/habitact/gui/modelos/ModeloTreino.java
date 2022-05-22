package br.ufrpe.habitact.gui.modelos;

import br.ufrpe.habitact.negocio.beans.Exercicio;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class ModeloTreino {
    private final SimpleBooleanProperty check;
    private final SimpleStringProperty nome;
    private final SimpleStringProperty ritmo;
    private final SimpleDoubleProperty duracao;

    public ModeloTreino(Exercicio exercicio){
        this.check = new SimpleBooleanProperty(false);
        this.nome = new SimpleStringProperty(exercicio.getNome().getNome());
        this.ritmo = new SimpleStringProperty(exercicio.getRitmo().getRitmo());
        this.duracao = new SimpleDoubleProperty(exercicio.getDuracaoExercicio());
    }

    public boolean isCheck() {
        return check.get();
    }

    public SimpleBooleanProperty checkProperty() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check.set(check);
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
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
