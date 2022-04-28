package br.ufrpe.habitact.negocio.beans.enums;

public enum Refeicao {
    CAFÉ_DA_MANHÃ ("Café da manhã"),
    LANCHE_DA_MANHÃ ("Lanche da manhã"),
    ALMOÇO ("Almoço"),
    LANCHE_DA_TARDE ("Lanche da tarde"),
    JANTAR ("Jantar");

    private String refeicao;

    Refeicao(String refeicao){
        this.refeicao = refeicao;
    }

    public String getRefeicao() {
        return refeicao;
    }
}
