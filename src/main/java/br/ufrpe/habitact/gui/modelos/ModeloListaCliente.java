package br.ufrpe.habitact.gui.modelos;

import br.ufrpe.habitact.negocio.beans.Cliente;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class ModeloListaCliente {
    private final SimpleStringProperty nome;
    private final SimpleStringProperty email;
    private final SimpleBooleanProperty check;

    public ModeloListaCliente(Cliente cliente) {
        this.nome = new SimpleStringProperty(cliente.getNome());
        this.email = new SimpleStringProperty(cliente.getEmail());
        this.check = new SimpleBooleanProperty(false);
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

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
}
