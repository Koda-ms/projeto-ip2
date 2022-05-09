package br.ufrpe.habitact.negocio.beans;

import br.ufrpe.habitact.negocio.beans.enums.Refeicao;

import java.time.LocalDate;
import java.util.Objects;

public class Alimento {
	private LocalDate diaDoAlimento;
	private Refeicao refeicao;
	private String nome;
	private double qtdGrama;
	private double calorias;

	public Alimento(String nome, double qtdGrama, double calorias, Refeicao refeicao, LocalDate diaDoAlimento) {
		this.diaDoAlimento = diaDoAlimento;
		this.refeicao = refeicao;
		this.nome = nome;
		this.qtdGrama = qtdGrama;
		this.calorias = calorias;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Alimento alimento = (Alimento) o;
		return Double.compare(alimento.qtdGrama, qtdGrama) == 0 && Double.compare(alimento.calorias, calorias) == 0 &&
				diaDoAlimento.equals(alimento.diaDoAlimento) && refeicao == alimento.refeicao && nome.equals(alimento.nome);
	}

	@Override
	public int hashCode() {
		return Objects.hash(diaDoAlimento, refeicao, nome, qtdGrama, calorias);
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

	public LocalDate getDiaDoAlimento() {
		return diaDoAlimento;
	}

	public void setDiaDoAlimento(LocalDate diaDoAlimento) {
		this.diaDoAlimento = diaDoAlimento;
	}

	public Refeicao getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}
}
