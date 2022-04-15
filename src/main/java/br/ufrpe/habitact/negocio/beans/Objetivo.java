package br.ufrpe.habitact.negocio.beans;

public enum Objetivo {
	PERDER_MASSA ("Perder Massa"), 
	GANHAR_MASSA ("Ganhar Massa"),
	FORTALECER_MUSCULOS ("Fortalecer Músculos"), 
	MELHORAR_CONDICIONAMENTO ("Melhorar Condicionamento Físico"),
	MELHORAR_ALIMENTACAO("Melhorar Alimentação"),
	SUPLEMENTACAO_ALIMENTAR("Suplementação Alimentar"),
	OUTROS ("");
	
    private String objetivo;

	Objetivo(String objetivo) {
        this.objetivo = objetivo;
	}
}
