package br.ufrpe.habitact.negocio.beans.enums;

public enum ObjetivoAlimentar {
	MELHORAR_ALIMENTACAO("Melhorar Alimentação"), SUPLEMENTACAO_ALIMENTAR("Suplementação Alimentar"), OUTROS("Outro");

	private String objetivo;

	ObjetivoAlimentar(String objetivo) {
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
