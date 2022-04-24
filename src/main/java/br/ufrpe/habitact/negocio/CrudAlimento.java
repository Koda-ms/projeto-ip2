package br.ufrpe.habitact.negocio;

import java.util.List;

import br.ufrpe.habitact.dados.IRepositorio;
import br.ufrpe.habitact.dados.Repositorio;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
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
		try {
			this.repositorioAlimento.inserir(alimento);
			quantidadeAlimento = quantidadeAlimento + 1;
		} catch (ObjetoDuplicadoException e) {
			throw new ObjetoDuplicadoException("Este alimento já foi cadastrado no sistema.");
		}
	}

	public List<Alimento> listarAlimento() {
		return repositorioAlimento.listar();
	}
}
