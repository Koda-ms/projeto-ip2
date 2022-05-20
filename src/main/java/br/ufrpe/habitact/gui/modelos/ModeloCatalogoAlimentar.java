package br.ufrpe.habitact.gui.modelos;

import br.ufrpe.habitact.negocio.beans.Alimento;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class ModeloCatalogoAlimentar {
    private SimpleBooleanProperty check;
    private SimpleStringProperty nome;
    private SimpleDoubleProperty quantidade;
    private SimpleDoubleProperty calorias;

    public ModeloCatalogoAlimentar(Alimento alimento){
        this.check = new SimpleBooleanProperty(false);
        this.nome = new SimpleStringProperty(alimento.getNome());
        this.quantidade = new SimpleDoubleProperty(alimento.getQtdGrama());
        this.calorias = new SimpleDoubleProperty(alimento.getCalorias());
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

    public double getQuantidade() {
        return quantidade.get();
    }

    public SimpleDoubleProperty quantidadeProperty() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade.set(quantidade);
    }

    public double getCalorias() {
        return calorias.get();
    }

    public SimpleDoubleProperty caloriasProperty() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias.set(calorias);
    }
}
