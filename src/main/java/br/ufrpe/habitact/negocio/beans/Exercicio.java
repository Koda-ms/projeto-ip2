package br.ufrpe.habitact.negocio.beans;

public class Exercicio {
	private TipoExercicio nome;
	private double duracaoExercicio;
	private double caloriasGastas;
	
	public Exercicio(TipoExercicio nome, double duracaoExercicio) {
		this.nome = nome;
		this.duracaoExercicio = duracaoExercicio;
	}

	public double estimarQtdDeCaloriasGastas(){
		//TODO Para efetuar essa estimativa serão necessárias as seguines informações:
		// - Peso, duração do exercício e o tipo do exercício
		return 0;
	}
}
