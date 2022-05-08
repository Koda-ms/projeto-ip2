package br.ufrpe.habitact.negocio.beans;

import br.ufrpe.habitact.negocio.beans.enums.Refeicao;

import java.time.LocalDate;
import java.util.Objects;

public class Alimento {
	private LocalDate diaDoAlimento;
	private Refeicao refeicao;
	private String nome;
	private String qtdGrama;
	private String calorias;

	public Alimento(String nome, String qtdGrama, String calorias, Refeicao refeicao, LocalDate diaDoAlimento) {
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
		return diaDoAlimento.equals(alimento.diaDoAlimento) && refeicao == alimento.refeicao
				&& nome.equals(alimento.nome) && qtdGrama.equals(alimento.qtdGrama) && calorias.equals(alimento.calorias);
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

	public String getQtdGrama() {
		return qtdGrama;
	}

	public void setQtdGrama(String qtdGrama) {
		this.qtdGrama = qtdGrama;
	}

	public String getCalorias() {
		return calorias;
	}

	public void setCalorias(String calorias) {
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
