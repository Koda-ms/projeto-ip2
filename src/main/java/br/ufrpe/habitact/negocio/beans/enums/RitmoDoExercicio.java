package br.ufrpe.habitact.negocio.beans.enums;

public enum RitmoDoExercicio {
    BAIXO ("Baixo"),
    MEDIO ("Médio"),
    ALTO ("Alto");

    private String ritmo;

    RitmoDoExercicio(String ritmo){
        this.ritmo = ritmo;
    }

	public String getRitmo() {
		return ritmo;
	}
}
