package br.ufrpe.habitact.negocio.beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class PlanoAlimentar {
	private Cliente cliente;
	private ArrayList<Alimento> alimentos;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private ObjetivoAlimentar objetivoAlimentar;
    
    public PlanoAlimentar(Cliente cliente,LocalDate dataInicio, LocalDate dataFim, ObjetivoAlimentar objetivoAlimentar) {
    	this.cliente = cliente;
		this.alimentos = new ArrayList<Alimento>();
    	this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.objetivoAlimentar = objetivoAlimentar;
    }
}