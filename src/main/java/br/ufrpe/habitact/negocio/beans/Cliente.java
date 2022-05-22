package br.ufrpe.habitact.negocio.beans;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
