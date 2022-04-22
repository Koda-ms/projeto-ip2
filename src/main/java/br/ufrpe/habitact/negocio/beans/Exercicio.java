package br.ufrpe.habitact.negocio.beans;

import java.time.LocalDateTime;

public class Exercicio {
	private TipoExercicio nome;
	private double duracaoExercicio;
	private double caloriasGastas;
	private RitmoDoExercicio ritmo;
	
	public Exercicio(TipoExercicio nome, double duracaoExercicio, RitmoDoExercicio ritmo) {
		this.nome = nome;
		this.duracaoExercicio = duracaoExercicio;
		this.ritmo = ritmo;
	}

	public void estimarQtdDeCaloriasGastas(){
		//TODO Para efetuar essa estimativa serão necessárias as seguines informações:
		// - Peso, duração do exercício e o tipo do exercício
	}

	public double getDuracaoExercicio() {
		return duracaoExercicio;
	}
}
