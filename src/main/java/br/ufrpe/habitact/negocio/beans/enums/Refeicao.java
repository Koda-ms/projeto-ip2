package br.ufrpe.habitact.negocio.beans.enums;

public enum Refeicao {
    CAFÉ_DA_MANHÃ ("Café da manhã"),
    LANCHE ("Lanche"),
    ALMOÇO ("Almoço"),
    JANTAR ("Jantar");

    private String refeicao;

    Refeicao(String refeicao){
        this.refeicao = refeicao;
    }

    public String getRefeicao() {
        return refeicao;
    }
}
