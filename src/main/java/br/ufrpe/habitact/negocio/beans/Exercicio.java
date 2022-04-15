package br.ufrpe.habitact.negocio.beans;

import java.time.LocalDateTime;

public class Exercicio {
	private TipoExercicio nome;
	private LocalDateTime horarioInicio;
	private LocalDateTime horarioTermino;
	private double caloriasGastas;
	
	public Exercicio(TipoExercicio nome, LocalDateTime horarioInicio, LocalDateTime horarioTermino) {
		this.nome = nome;
		this.horarioInicio = horarioInicio;
		this.horarioTermino = horarioTermino;
	}
}
