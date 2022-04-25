package br.ufrpe.habitact.negocio.beans.enums;

public enum TipoExercicio {
	CAMINHADA ("Caminhada"), 
	CORRIDA ("Corrida"), 
	NATACAO ("Natação"),
	CICLISMO ("Ciclismo"), 
	MUSCULACAO ("Musculação"), 
	ARTES_MARCIAIS ("Artes Marciais"), 
	TENIS_DE_MESA ("Tenis de Mesa"), 
	OUTROS ("");
	
    private String tipo;

	TipoExercicio(String nome) {
        this.tipo = nome;
    }

	public String getNome() {
		return tipo;
	}
}
