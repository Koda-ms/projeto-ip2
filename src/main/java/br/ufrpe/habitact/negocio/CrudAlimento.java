package br.ufrpe.habitact.negocio;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.habitact.dados.IRepositorio;
import br.ufrpe.habitact.dados.Repositorio;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.negocio.beans.Alimento;

public class CrudAlimento {
	// atributos
	private IRepositorio<Alimento> repositorioAlimento;
	private static long quantidadeAlimento;

	// constructor default
	public CrudAlimento() {
		this.repositorioAlimento = new Repositorio<>();
	}

	// método para adicionar alimento no sistema
	public void adicionarAlimento(Alimento alimento) throws ObjetoDuplicadoException {
		this.repositorioAlimento.inserir(alimento);
		quantidadeAlimento = quantidadeAlimento + 1;
	}

	public Alimento buscarAlimento(String nome) throws ObjetoNaoExisteException {
		List<Alimento> alimentoList = new ArrayList<>(this.repositorioAlimento.listar());
		return alimentoList.stream().filter(alimento -> alimento.getNome().equals(nome)).reduce((a, b) -> b)
				.orElse(null);
	}

	public void removerAlimento(Alimento alimento) throws ObjetoNaoExisteException {
		this.repositorioAlimento.remover(alimento);

	}

	public List<Alimento> listarAlimento() {
		return repositorioAlimento.listar();
	}
}
