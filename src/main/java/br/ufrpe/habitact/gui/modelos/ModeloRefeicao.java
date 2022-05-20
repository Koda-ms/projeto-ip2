package br.ufrpe.habitact.gui.modelos;

import br.ufrpe.habitact.negocio.beans.Alimento;
import javafx.beans.property.SimpleStringProperty;

public class ModeloRefeicao {
    private SimpleStringProperty cafeDaManha;
    private SimpleStringProperty almoco;
    private SimpleStringProperty lanche;
    private SimpleStringProperty jantar;

    public ModeloRefeicao(Alimento alimento){
        String ref = alimento.getRefeicao().getRefeicao();
        switch(ref){
            case "Café da manhã": this.cafeDaManha = new SimpleStringProperty(alimento.getNome()); break;
            case "Almoço": this.almoco = new SimpleStringProperty(alimento.getNome()); break;
            case "Lanche": this.lanche = new SimpleStringProperty(alimento.getNome()); break;
            case "Jantar": this.jantar = new SimpleStringProperty(alimento.getNome()); break;
        }
    }

    public String getCafeDaManha() {
        return cafeDaManha.get();
    }

    public SimpleStringProperty cafeDaManhaProperty() {
        return cafeDaManha;
    }

    public void setCafeDaManha(String cafeDaManha) {
        this.cafeDaManha.set(cafeDaManha);
    }

    public String getAlmoco() {
        return almoco.get();
    }

    public SimpleStringProperty almocoProperty() {
        return almoco;
    }

    public void setAlmoco(String almoco) {
        this.almoco.set(almoco);
    }

    public String getLanche() {
        return lanche.get();
    }

    public SimpleStringProperty lancheProperty() {
        return lanche;
    }

    public void setLanche(String lanche) {
        this.lanche.set(lanche);
    }

    public String getJantar() {
        return jantar.get();
    }

    public SimpleStringProperty jantarProperty() {
        return jantar;
    }

    public void setJantar(String jantar) {
        this.jantar.set(jantar);
    }
}
