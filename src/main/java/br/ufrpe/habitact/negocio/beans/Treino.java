package br.ufrpe.habitact.negocio.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.negocio.beans.enums.CategoriaTreino;

public class Treino {
	private LocalDate diaFeito;
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

	public void inserirExercicio(Exercicio exercicio) throws ObjetoDuplicadoException {
		if (!this.exercicios.contains(exercicio)) {
			this.exercicios.add(exercicio);
		} else {
			throw new ObjetoDuplicadoException("Exercício já existe no treino");
		}
	}

	public void removerExercicio(Exercicio exercicio) throws ObjetoNaoExisteException{
		if(!this.exercicios.contains(exercicio)){
			throw new ObjetoNaoExisteException("Exercício não existe");
		}
		else{
			this.exercicios.remove(exercicio);
		}
	}

	public LocalDate getDiaFeito() {
		return diaFeito;
	}

	public void setDiaFeito(LocalDate diaFeito) {
		this.diaFeito = diaFeito;
	}
}
