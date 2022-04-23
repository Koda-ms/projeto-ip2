package br.ufrpe.habitact.negocio.beans.enums;

public enum CategoriaTreino {
	AEROBICO("Aeróbico"), ANAEROBICO("Anaeróbico");

	private String categoria;

	CategoriaTreino(String categoria) {
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}
}
