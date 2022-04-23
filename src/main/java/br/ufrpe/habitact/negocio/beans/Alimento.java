package br.ufrpe.habitact.negocio.beans;

import java.util.Objects;

public class Alimento {
	private String nome;
	private double calorias;
	
	public Alimento(String nome, double calorias) {
		this.nome = nome;
		this.calorias = calorias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(calorias, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Alimento))
			return false;
		Alimento other = (Alimento) obj;
		return Double.doubleToLongBits(calorias) == Double.doubleToLongBits(other.calorias)
				&& Objects.equals(nome, other.nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getCalorias() {
		return calorias;
	}

	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}
	
	
}
