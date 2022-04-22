package br.ufrpe.habitact.negocio.beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class PlanoTreino {
	private Cliente cliente;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private ObjetivoTreino objetivoTreino;
	private ArrayList<Treino> Treinos;
	
	public PlanoTreino(Cliente cliente ,LocalDate dataInicio, LocalDate dataFim, ObjetivoTreino objetivoTreino) {
		this.cliente = cliente;
		//this.exercicio = new ArrayList<Exercicio>();
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.objetivoTreino = objetivoTreino;
	}
}