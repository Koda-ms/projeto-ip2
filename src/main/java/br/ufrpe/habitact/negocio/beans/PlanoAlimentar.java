package br.ufrpe.habitact.negocio.beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class PlanoAlimentar {
	private ArrayList<Alimento> alimentos;
	private LocalDate diaInicio;
	private LocalDate diaFim;
	private Objetivo objetivo;
    
    public PlanoAlimentar(LocalDate diaInicio, LocalDate diaFim, Objetivo objetivo) {
    	this.alimentos = new ArrayList<Alimento>();
    	this.diaInicio = diaInicio;
		this.diaFim = diaFim;
		this.objetivo = objetivo;
    }
}