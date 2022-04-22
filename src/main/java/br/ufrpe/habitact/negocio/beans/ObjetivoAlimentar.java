package br.ufrpe.habitact.negocio.beans;

public enum ObjetivoAlimentar {
    MELHORAR_ALIMENTACAO("Melhorar Alimentação"),
    SUPLEMENTACAO_ALIMENTAR("Suplementação Alimentar"),
    OUTROS ("");

    private String objetivo;

    ObjetivoAlimentar(String objetivo){
        this.objetivo = objetivo;
    }
}
