package br.ufrpe.habitact.negocio.beans;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Cliente extends Usuario {
	private String genero;
	private double peso;
	private double altura;
	private double imc;
	private long idade;


	public Cliente(String nome, String email, String senha, LocalDate dtNascimento, String genero, double peso,
				   double altura) {
		super(nome, email, senha, dtNascimento);
		this.genero = genero;
		this.peso = peso;
		this.altura = altura;
		this.calcularIMC(peso, altura);
		this.calcularIdade(dtNascimento);
	}

	public Cliente(){}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(altura, genero, idade, imc, peso);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Cliente))
			return false;
		Cliente other = (Cliente) obj;
		return Double.doubleToLongBits(altura) == Double.doubleToLongBits(other.altura)
				&& Objects.equals(genero, other.genero) && idade == other.idade
				&& Double.doubleToLongBits(imc) == Double.doubleToLongBits(other.imc)
				&& Double.doubleToLongBits(peso) == Double.doubleToLongBits(other.peso);
	}

	private void calcularIMC(double peso, double altura) {
		this.imc = peso / (altura * altura);
	}
	
	private void calcularIdade(LocalDate dtNascimento) {
		this.idade =  dtNascimento.until(LocalDate.now(), ChronoUnit.YEARS);
	}
	
	public double quantidadeDeAguaParaBeber(double peso) {
		return this.peso * 0.05;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public long getIdade() {
		return idade;
	}

	public void setIdade(long idade) {
		this.idade = idade;
	}
	
	
}
