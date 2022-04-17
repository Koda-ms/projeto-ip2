package br.ufrpe.habitact.negocio.beans;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Cliente extends Usuario {
	private String genero;
	private double peso;
	private double altura;
	private double imc;
	private PlanoTreino planoDeTreino;
	private PlanoAlimentar planoAlimentar;

	public Cliente(String nome, String email, String senha, LocalDate dtNascimento, String genero, double peso,
			double altura, boolean jaFazExercicio) {
		super(nome, email, senha, dtNascimento);
		this.genero = genero;
		this.peso = peso;
		this.altura = altura;
		this.calcularIMC(peso, altura);
	}

	private void calcularIMC(double peso, double altura) {
		this.imc = peso / (altura * altura);
	}
	
	private int calcularIdade() {
		return 0;
	}
	
	public double quantidadeDeAguaParaBeber(double peso) {
		return this.peso * 0.05;
	}
}
