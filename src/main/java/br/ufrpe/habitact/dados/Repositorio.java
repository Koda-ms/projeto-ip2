package br.ufrpe.habitact.dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;

public class Repositorio<T> implements IRepositorio<T> {
	protected List<T> elementos;

    public Repositorio() {
        this.elementos = new ArrayList<>();
    }

	@Override
	public void inserir(T elem) throws ObjetoDuplicadoException {
		if (!this.elementos.contains(elem)) {
            this.elementos.add(elem);
        } else {
            throw new ObjetoDuplicadoException("Elemento já existe no repositório");
        }
	}

	@Override
	public List<T> listar() {
		return Collections.unmodifiableList(this.elementos);
	}

	@Override
	public void atualizar(T elem1, T elem2) throws ObjetoNaoExisteException {
		if (this.elementos.contains(elem2)) {
			this.elementos.set(this.elementos.indexOf(elem1), elem2);
        } else {
			throw new ObjetoNaoExisteException("Nenhum dado foi atualizado.");
        }	
	}

	@Override
	public void remover(T elem) throws ObjetoNaoExisteException {
		if (this.elementos.contains(elem)) {
            this.elementos.remove(this.elementos.indexOf(elem));
        } else {
            throw new ObjetoNaoExisteException("Elemento não pode ser removido, pois não existe no repositório");
        }
		
	}
	
}
