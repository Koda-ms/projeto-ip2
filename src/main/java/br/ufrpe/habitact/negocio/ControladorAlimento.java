package br.ufrpe.habitact.negocio;

import br.ufrpe.habitact.dados.IRepositorio;
import br.ufrpe.habitact.dados.Repositorio;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.negocio.beans.Alimento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControladorAlimento {
	private IRepositorio<Alimento> repositorioAlimento;
	private static ControladorAlimento instance;

	private ControladorAlimento() {
		this.repositorioAlimento = new Repositorio<>();
	}
	
	public static ControladorAlimento getInstance() {
        if (instance == null) {
            instance = new ControladorAlimento();
        }
        return instance;
    }

	public void adicionarAlimento(Alimento alimento) throws ObjetoDuplicadoException {
		this.repositorioAlimento.inserir(alimento);
	}

	public List<Alimento> buscarAlimento(String nome) throws ObjetoNaoExisteException {
		List<Alimento> alimentoList = new ArrayList<>(this.repositorioAlimento.listar());
		List<Alimento> lista = alimentoList.stream()
				.filter(alimento -> alimento.getNome().equals(nome)).collect(Collectors.toList());
		return lista;
	}

	public void removerAlimento(Alimento alimento) throws ObjetoNaoExisteException {
		this.repositorioAlimento.remover(alimento);

	}

	public List<Alimento> listarAlimento() {
		return repositorioAlimento.listar();
	}
}
