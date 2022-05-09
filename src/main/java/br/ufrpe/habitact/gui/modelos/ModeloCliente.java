package br.ufrpe.habitact.gui.modelos;

import br.ufrpe.habitact.negocio.beans.Cliente;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class ModeloCliente {
    private final SimpleStringProperty nome;
    private final SimpleLongProperty idade;
    private final SimpleStringProperty genero;

    public ModeloCliente(Cliente cliente){
        this.nome = new SimpleStringProperty(cliente.getNome());
        this.idade = new SimpleLongProperty(cliente.getIdade());
        this.genero = new SimpleStringProperty(cliente.getGenero());
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

    public long getIdade() {
        return idade.get();
    }

    public SimpleLongProperty idadeProperty() {
        return idade;
    }

    public void setIdade(long idade) {
        this.idade.set(idade);
    }

    public String getGenero() {
        return genero.get();
    }

    public SimpleStringProperty generoProperty() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero.set(genero);
    }
}
