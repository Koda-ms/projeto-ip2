package br.ufrpe.habitact.negocio.beans.enums;

public enum RitmoDoExercicio {
    BAIXO (1),
    MEDIO (2),
    ALTO (3);

    private int ritmo;

    RitmoDoExercicio(int ritmo){
        this.ritmo = ritmo;
    }

	public int getRitmo() {
		return ritmo;
	}
}
