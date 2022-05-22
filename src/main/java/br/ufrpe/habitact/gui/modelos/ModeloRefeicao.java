package br.ufrpe.habitact.gui.modelos;

import br.ufrpe.habitact.negocio.beans.Alimento;
import javafx.beans.property.SimpleStringProperty;

public class ModeloRefeicao {
    private SimpleStringProperty cafe;
    private SimpleStringProperty almoco;
    private SimpleStringProperty lanche;
    private SimpleStringProperty jantar;

    public ModeloRefeicao(Alimento alimento){
        String ref = alimento.getRefeicao().getRefeicao();
        switch(ref){
            case "Café da manhã": this.cafe = new SimpleStringProperty(alimento.getNome()); break;
            case "Almoço": this.almoco = new SimpleStringProperty(alimento.getNome()); break;
            case "Lanche": this.lanche = new SimpleStringProperty(alimento.getNome()); break;
            case "Jantar": this.jantar = new SimpleStringProperty(alimento.getNome()); break;
        }
    }

    public String getCafe() {
        return cafe.get();
    }

    public SimpleStringProperty cafeProperty() {
        return cafe;
    }

    public void setCafe(String cafe) {
        this.cafe.set(cafe);
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
