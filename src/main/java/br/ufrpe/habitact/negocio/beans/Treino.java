package br.ufrpe.habitact.negocio.beans;

import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.negocio.beans.enums.CategoriaTreino;
import br.ufrpe.habitact.negocio.beans.enums.TipoExercicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Treino {
	private LocalDate diaFeito;
	private ArrayList<Exercicio> exercicios;
	private double duracao;
	private double queimaCaloricaTotal;
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

	//TODO o método será usado no controller da tela de cadastro de treino
	public void estimarQtdDeCaloriasGastas(TipoExercicio exercicio) {

		//Queima calórica por MINUTO
		switch (exercicio.getNome()){
			case "Caminhada": this.queimaCaloricaTotal = this.duracao * 5.5; break;
			case "Corrida": this.queimaCaloricaTotal = this.duracao * 10; break;
			case "Natação": this.queimaCaloricaTotal = this.duracao * 9; break;
			case "Ciclismo": this.queimaCaloricaTotal = this.duracao * 6; break;
			case "Musculação": this.queimaCaloricaTotal = this.duracao * 5; break;
			case "Jiu-Jitsu": this.queimaCaloricaTotal = this.duracao * 12; break;
			case "Tenis de Mesa": this.queimaCaloricaTotal = this.duracao * 8; break;
			default: System.out.println("Para outros tipos de treinos, por favor, procure um especialista.");
		}
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

	public double getQueimaCaloricaTotal() {
		return queimaCaloricaTotal;
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
