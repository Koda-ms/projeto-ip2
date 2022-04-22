package br.ufrpe.habitact.negocio.beans;

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
