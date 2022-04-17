package br.ufrpe.habitact.negocio.beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class PlanoTreino {
	private ArrayList<Exercicio> exercicios;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Objetivo objetivoTreino;
	
	public PlanoTreino(LocalDate dataInicio, LocalDate dataFim, Objetivo objetivoTreino) {
		this.exercicios = new ArrayList<Exercicio>();
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.objetivoTreino = objetivoTreino;
	}
}