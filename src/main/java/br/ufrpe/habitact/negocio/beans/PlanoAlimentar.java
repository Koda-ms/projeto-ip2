package br.ufrpe.habitact.negocio.beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class PlanoAlimentar {
	private ArrayList<Alimento> alimentos;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Objetivo objetivoAlimentar;
    
    public PlanoAlimentar(LocalDate dataInicio, LocalDate dataFim, Objetivo objetivoAlimentar) {
    	this.alimentos = new ArrayList<Alimento>();
    	this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.objetivoAlimentar = objetivoAlimentar;
    }
}