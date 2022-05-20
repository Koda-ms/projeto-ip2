package br.ufrpe.habitact.gui.modelos;

import br.ufrpe.habitact.negocio.beans.Alimento;
import br.ufrpe.habitact.negocio.beans.Treino;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class ModeloTreinoGui {
    private final SimpleBooleanProperty check;
    private final SimpleStringProperty modalidade;

    public ModeloTreinoGui(Treino treino) {
        this.check = new SimpleBooleanProperty(false);
        this.modalidade = new SimpleStringProperty(treino.getModalidade().getCategoria());
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

    public String getModalidade() {
        return modalidade.get();
    }

    public SimpleStringProperty modalidadeProperty() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade.set(modalidade);
    }
}
