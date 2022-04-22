package br.ufrpe.habitact.negocio.beans;

public enum RitmoDoExercicio {
    BAIXO (1),
    MEDIO (2),
    ALTO (3);

    private int ritmo;

    RitmoDoExercicio(int ritmo){
        this.ritmo = ritmo;
    }
}
