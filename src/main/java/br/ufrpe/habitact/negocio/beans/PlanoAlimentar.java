package br.ufrpe.habitact.negocio.beans;

import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.negocio.beans.enums.ObjetivoAlimentar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class PlanoAlimentar {
	private Cliente cliente;
	private ArrayList<Alimento> alimentos;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private ObjetivoAlimentar objetivoAlimentar;

	public PlanoAlimentar(Cliente cliente, LocalDate dataInicio, LocalDate dataFim,
						  ObjetivoAlimentar objetivoAlimentar) {
		this.cliente = cliente;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.objetivoAlimentar = objetivoAlimentar;
		this.alimentos = new ArrayList<Alimento>();
	}

	public PlanoAlimentar(){}

	public void cadastrarAlimentos(Alimento alimento) throws ObjetoDuplicadoException {
		if (!alimentos.contains(alimento)) {
			alimentos.add(alimento);
		} else {
			throw new ObjetoDuplicadoException("Alimento já existe no plano");
		}
	}

	public void removerAlimento(Alimento alimento) throws ObjetoNaoExisteException {
		if (!this.alimentos.contains(alimento)) {
			throw new ObjetoNaoExisteException("Alimento não existe no plano");
		} else {
			this.alimentos.remove(alimento);
		}
	}

	public double calcularCalorias(){
		double totalCalorias = 0;
		for (Alimento a : this.alimentos){
			totalCalorias += a.getCalorias();
		}
		return totalCalorias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, dataFim, dataInicio, objetivoAlimentar);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PlanoAlimentar))
			return false;
		PlanoAlimentar other = (PlanoAlimentar) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(dataFim, other.dataFim)
				&& Objects.equals(dataInicio, other.dataInicio) && objetivoAlimentar == other.objetivoAlimentar;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Alimento> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(ArrayList<Alimento> alimentos) {
		this.alimentos = alimentos;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public ObjetivoAlimentar getObjetivoAlimentar() {
		return objetivoAlimentar;
	}

	public void setObjetivoAlimentar(ObjetivoAlimentar objetivoAlimentar) {
		this.objetivoAlimentar = objetivoAlimentar;
	}

}