package br.ufrpe.habitact.negocio.beans.enums;

public enum TipoExercicio {
	CAMINHADA ("Caminhada"), 
	CORRIDA ("Corrida"), 
	NATACAO ("Natação"),
	CICLISMO ("Ciclismo"), 
	MUSCULACAO ("Musculação"), 
	JIU_JITSU ("Jiu-Jitsu"),
	TENIS_DE_MESA ("Tenis de Mesa"),
	OUTRO("Outro");
	
    private String tipo;

	TipoExercicio(String nome) {
        this.tipo = nome;
    }

	public String getNome() {
		return tipo;
	}

	@Override
	public String toString() {
		return this.tipo;
	}
}
