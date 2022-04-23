package br.ufrpe.habitact.dados;

import java.util.List;

import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;

public interface IRepositorio<T> {
	public void inserir(T elem) throws ObjetoDuplicadoException;

	public List<T> listar();

	public void atualizar(T elem1, T elem2) throws ObjetoNaoExisteException;

	public void remover(T elem) throws ObjetoNaoExisteException;
}
