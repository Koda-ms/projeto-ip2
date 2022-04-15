package br.ufrpe.habitact.negocio.beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class PlanoTreino {
	private ArrayList<Exercicio> exercicios;
	private LocalDate diaInicio;
	private LocalDate diaFim;
	private Objetivo objetivo;
	
	public PlanoTreino(LocalDate diaInicio, LocalDate diaFim, Objetivo objetivo) {
		this.exercicios = new ArrayList<Exercicio>();
		this.diaInicio = diaInicio;
		this.diaFim = diaFim;
		this.objetivo = objetivo;
	}
}