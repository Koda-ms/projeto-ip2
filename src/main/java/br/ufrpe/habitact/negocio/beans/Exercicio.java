package br.ufrpe.habitact.negocio.beans;

import java.util.Objects;

import br.ufrpe.habitact.negocio.beans.enums.RitmoDoExercicio;
import br.ufrpe.habitact.negocio.beans.enums.TipoExercicio;

public class Exercicio {
	private TipoExercicio nome;
	private RitmoDoExercicio ritmo;
	private double duracaoExercicio;
	private int repeticoes;
	private int series;
	private double caloriasGastas;

	public Exercicio(TipoExercicio nome, RitmoDoExercicio ritmo, double duracaoExercicio, int repeticoes, int series,
			double caloriasGastas) {
		this.nome = nome;
		this.ritmo = ritmo;
		this.duracaoExercicio = duracaoExercicio;
		this.repeticoes = repeticoes;
		this.series = series;
		this.estimarQtdDeCaloriasGastas(ritmo, duracaoExercicio);

	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Exercicio))
			return false;
		Exercicio other = (Exercicio) obj;
		return nome == other.nome;
	}

	public void estimarQtdDeCaloriasGastas(RitmoDoExercicio ritmo, double duracaoExercicio) {
		// TODO Para efetuar essa estimativa serão necessárias as seguines informações:
		// - Peso, duração do exercício e o tipo do exercício
		this.caloriasGastas = duracaoExercicio * ritmo.getRitmo();
	}

	public TipoExercicio getNome() {
		return nome;
	}

	public void setNome(TipoExercicio nome) {
		this.nome = nome;
	}

	public double getDuracaoExercicio() {
		return duracaoExercicio;
	}

	public void setDuracaoExercicio(double duracaoExercicio) {
		this.duracaoExercicio = duracaoExercicio;
	}

	public double getCaloriasGastas() {
		return caloriasGastas;
	}

	public void setCaloriasGastas(double caloriasGastas) {
		this.caloriasGastas = caloriasGastas;
	}

	public RitmoDoExercicio getRitmo() {
		return ritmo;
	}

	public void setRitmo(RitmoDoExercicio ritmo) {
		this.ritmo = ritmo;
	}

	public int getRepeticoes() {
		return repeticoes;
	}

	public void setRepeticoes(int repeticoes) {
		this.repeticoes = repeticoes;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

}
