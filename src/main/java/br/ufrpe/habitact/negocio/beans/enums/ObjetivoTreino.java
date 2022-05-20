package br.ufrpe.habitact.negocio.beans.enums;

public enum ObjetivoTreino {
	PERDER_MASSA("Perder Massa"), GANHAR_MASSA("Ganhar Massa"), FORTALECER_MUSCULOS("Fortalecer Músculos"),
	MELHORAR_CONDICIONAMENTO("Melhorar Condicionamento Físico"), OUTRO("Outro");

	private String objetivo;

	ObjetivoTreino(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getObjetivo() {
		return objetivo;
	}

	@Override
	public String toString() {
		return this.objetivo;
	}
}
