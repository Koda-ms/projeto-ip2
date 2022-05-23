package br.ufrpe.habitact.gui.modelos;

import br.ufrpe.habitact.negocio.beans.Exercicio;
import br.ufrpe.habitact.negocio.beans.Treino;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.format.DateTimeFormatter;

public class ModeloPlanoTreinoCliente {
    private final SimpleBooleanProperty check;
    private final SimpleDoubleProperty calorias;
    private final SimpleStringProperty categoria;
    private final SimpleDoubleProperty duracao;
    private final SimpleStringProperty data;

    public ModeloPlanoTreinoCliente(Treino treino){
        this.check = new SimpleBooleanProperty(false);
        this.categoria = new SimpleStringProperty(treino.getModalidade().getCategoria());
        this.calorias = new SimpleDoubleProperty(treino.estimarQtdDeCaloriasGastas());
        this.duracao = new SimpleDoubleProperty(treino.duracaoTotal());
        String dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(treino.getDiaFeito());
        this.data = new SimpleStringProperty(dataFormatada);
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

    public double getCalorias() {
        return calorias.get();
    }

    public SimpleDoubleProperty caloriasProperty() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias.set(calorias);
    }

    public String getCategoria() {
        return categoria.get();
    }

    public SimpleStringProperty categoriaProperty() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria.set(categoria);
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

    public String getData() {
        return data.get();
    }

    public SimpleStringProperty dataProperty() {
        return data;
    }

    public void setData(String data) {
        this.data.set(data);
    }
}
