package br.ufrpe.habitact.negocio.beans;

import br.ufrpe.habitact.negocio.beans.enums.RitmoDoExercicio;
import br.ufrpe.habitact.negocio.beans.enums.TipoExercicio;

import java.util.Objects;

public class Exercicio {
	private TipoExercicio nome;
	private RitmoDoExercicio ritmo;
	private double duracaoExercicio;
	private int repeticoes;
	private int series;

	public Exercicio(TipoExercicio nome, RitmoDoExercicio ritmo, double duracaoExercicio, int repeticoes, int series) {
		this.nome = nome;
		this.ritmo = ritmo;
		this.duracaoExercicio = duracaoExercicio;
		this.repeticoes = repeticoes;
		this.series = series;
	}

	public Exercicio(){}

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
