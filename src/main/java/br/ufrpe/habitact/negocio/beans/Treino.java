package br.ufrpe.habitact.negocio.beans;

import java.util.ArrayList;
import java.util.Objects;

import br.ufrpe.habitact.negocio.beans.enums.CategoriaTreino;

public class Treino {
	private ArrayList<Exercicio> exercicios;
	private double duracao;
	private CategoriaTreino modalidade;

	public Treino(ArrayList<Exercicio> exercicios, CategoriaTreino modalidade) {
		this.exercicios = new ArrayList<>();
		this.duracaoTotal();
		this.modalidade = modalidade;
	}

	public void duracaoTotal() {
		double soma = 0;
		for (Exercicio e : exercicios) {
			soma = soma + e.getDuracaoExercicio();
		}
		this.duracao = soma;
	}

	@Override
	public int hashCode() {
		return Objects.hash(duracao, exercicios, modalidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Treino))
			return false;
		Treino other = (Treino) obj;
		return Double.doubleToLongBits(duracao) == Double.doubleToLongBits(other.duracao)
				&& Objects.equals(exercicios, other.exercicios) && modalidade == other.modalidade;
	}

	public ArrayList<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(ArrayList<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	public CategoriaTreino getModalidade() {
		return modalidade;
	}

	public void setModalidade(CategoriaTreino modalidade) {
		this.modalidade = modalidade;
	}

}
