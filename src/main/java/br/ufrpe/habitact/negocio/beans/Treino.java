package br.ufrpe.habitact.negocio.beans;

import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.negocio.beans.enums.CategoriaTreino;
import br.ufrpe.habitact.negocio.beans.enums.TipoExercicio;
import br.ufrpe.habitact.sessao.Sessao;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Treino {
	private LocalDate diaFeito;
	private List<Exercicio> exercicios;
	private double duracao;
	private double queimaCaloricaTotal;
	private CategoriaTreino modalidade;

	public Treino() {}

	public Treino(List<Exercicio> exercicios, CategoriaTreino modalidade, LocalDate diaFeito) {
		this.diaFeito = diaFeito;
		this.exercicios = new ArrayList<>();
		this.duracaoTotal();
		this.modalidade = modalidade;
	}

	public double duracaoTotal() {
		double soma = 0;
		for (Exercicio e : this.exercicios) {
			soma = soma + e.getDuracaoExercicio();
		}
		this.duracao = soma;
		return soma;
	}

	//Queima calórica KCAL/MINUTO
	public double estimarQtdDeCaloriasGastas() {
		DecimalFormat formato = new DecimalFormat("##.##");
		switch (this.modalidade.getCategoria()){
			case "Aeróbico": return Double.parseDouble(formato.format(this.queimaCaloricaTotal = this.duracao * 0.5));
			case "Anaeróbico": return Double.parseDouble(formato.format(this.queimaCaloricaTotal = this.duracao * 0.2));
		}
		return Double.parseDouble(formato.format(this.queimaCaloricaTotal));
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

	public List<Exercicio> getExercicios() {
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

	public double getQueimaCaloricaTotal() {
		return queimaCaloricaTotal;
	}

	public void setQueimaCaloricaTotal(double queimaCaloricaTotal) {
		this.queimaCaloricaTotal = queimaCaloricaTotal;
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

	public void removerExercicio(Exercicio exercicio) throws ObjetoNaoExisteException {
		if (!this.exercicios.contains(exercicio)) {
			throw new ObjetoNaoExisteException("Exercício não existe");
		} else {
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
