package br.ufrpe.habitact.negocio.beans;

import java.util.ArrayList;
import java.util.List;

public class Treino {
	private List<Exercicio> exercicios;
	private double duracao;
	private CategoriaTreino modalidade;

	public Treino(ArrayList<Exercicio> exercicios, double duracao, CategoriaTreino modalidade) {
		this.exercicios = new ArrayList<>();
		this.duracao = duracao;
		this.modalidade = modalidade;
	}

	public void adicionar_exercicio(Exercicio exercicio) {
		this.exercicios.add(exercicio);
	}

	public void duracao_total() {
		double SomaTotal = 0;
		for (int i = 0; i < this.exercicios.size(); i++) {
			SomaTotal = SomaTotal + this.exercicios.get(i).getDuracaoExercicio();
		}
		this.duracao = SomaTotal;
	}
}
