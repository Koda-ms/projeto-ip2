package br.ufrpe.habitact.negocio.beans;

public class Exercicio {
	private TipoExercicio nome;
	private double duracaoExercicio;
	private double caloriasGastas;
	private RitmoDoExercicio ritmo;
	private int repeticoes;
	private int series;

	public Exercicio(TipoExercicio nome, double duracaoExercicio, double caloriasGastas, RitmoDoExercicio ritmo,
			int repeticoes, int series) {
		this.nome = nome;
		this.duracaoExercicio = duracaoExercicio;
		this.caloriasGastas = caloriasGastas;
		this.ritmo = ritmo;
		this.repeticoes = repeticoes;
		this.series = series;
	}

	public void estimarQtdDeCaloriasGastas() {
		// TODO Para efetuar essa estimativa serão necessárias as seguines informações:
		// - Peso, duração do exercício e o tipo do exercício
	}

	public double getDuracaoExercicio() {
		return duracaoExercicio;
	}
}
