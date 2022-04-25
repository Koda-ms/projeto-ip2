package br.ufrpe.habitact.negocio.beans;

import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.negocio.beans.enums.ObjetivoTreino;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class PlanoTreino {
	private Cliente cliente;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private ObjetivoTreino objetivoTreino;
	private ArrayList<Treino> treinos;

	public PlanoTreino(Cliente cliente, LocalDate dataInicio, LocalDate dataFim, ObjetivoTreino objetivoTreino) {
		this.cliente = cliente;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.objetivoTreino = objetivoTreino;
		this.treinos = new ArrayList<>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, dataFim, dataInicio, objetivoTreino, treinos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PlanoTreino))
			return false;
		PlanoTreino other = (PlanoTreino) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(dataFim, other.dataFim)
				&& Objects.equals(dataInicio, other.dataInicio) && objetivoTreino == other.objetivoTreino
				&& Objects.equals(treinos, other.treinos);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public ObjetivoTreino getObjetivoTreino() {
		return objetivoTreino;
	}

	public void setObjetivoTreino(ObjetivoTreino objetivoTreino) {
		this.objetivoTreino = objetivoTreino;
	}

	public ArrayList<Treino> getTreinos() {
		return treinos;
	}

	public void setTreinos(ArrayList<Treino> treinos) {
		this.treinos = treinos;
	}

	public void cadastrarTreino(Treino treino) throws ObjetoDuplicadoException {
		if (!this.treinos.contains(treino)) {
			this.treinos.add(treino);
		} else {
			throw new ObjetoDuplicadoException("Treino já existe no plano");
		}
	}

	public void removerTreino(Treino treino) throws ObjetoNaoExisteException {
		if(!this.treinos.contains(treino)){
			throw new ObjetoNaoExisteException("Treino não existe no plano");
		}
		else{
			this.treinos.remove(treino);
		}
	}
}