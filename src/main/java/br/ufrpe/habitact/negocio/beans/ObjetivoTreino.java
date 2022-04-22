package br.ufrpe.habitact.negocio.beans;

public enum ObjetivoTreino {
	PERDER_MASSA("Perder Massa"), GANHAR_MASSA("Ganhar Massa"), FORTALECER_MUSCULOS("Fortalecer Músculos"),
	MELHORAR_CONDICIONAMENTO("Melhorar Condicionamento Físico"), OUTROS("");

	private String objetivo;

	ObjetivoTreino(String objetivo) {
		this.objetivo = objetivo;
	}
}
