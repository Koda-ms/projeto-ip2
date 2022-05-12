package br.ufrpe.habitact.negocio.beans;

import br.ufrpe.habitact.negocio.beans.enums.Refeicao;

import java.time.LocalDate;
import java.util.Objects;

public class Alimento {
	private Refeicao refeicao;
	private String nome;
	private double qtdGrama;
	private double calorias;

	public Alimento(Refeicao refeicao, String nome, double qtdGrama, double calorias) {
		super();
		this.refeicao = refeicao;
		this.nome = nome;
		this.qtdGrama = qtdGrama;
		this.calorias = calorias;
	}

	public Alimento(){}

	@Override
	public int hashCode() {
		return Objects.hash(calorias, nome, qtdGrama, refeicao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Alimento))
			return false;
		Alimento other = (Alimento) obj;
		return Double.doubleToLongBits(calorias) == Double.doubleToLongBits(other.calorias)
				&& Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(qtdGrama) == Double.doubleToLongBits(other.qtdGrama)
				&& refeicao == other.refeicao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getQtdGrama() {
		return qtdGrama;
	}

	public void setQtdGrama(double qtdGrama) {
		this.qtdGrama = qtdGrama;
	}

	public double getCalorias() {
		return calorias;
	}

	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}

	public Refeicao getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}
}
