package br.ufrpe.habitact.negocio;

import br.ufrpe.habitact.dados.IRepositorio;
import br.ufrpe.habitact.dados.Repositorio;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.negocio.beans.Exercicio;
import br.ufrpe.habitact.negocio.beans.enums.TipoExercicio;

import java.util.ArrayList;
import java.util.List;

public class CrudExercicio {
	private IRepositorio<Exercicio> repoExercicio;

	public CrudExercicio() {
		this.repoExercicio = new Repositorio<>();
	}

	public void inserirExercicios(Exercicio exec) throws ObjetoDuplicadoException {
		this.repoExercicio.inserir(exec);
	}

	public void alterarExercicio(Exercicio oldExec, Exercicio newExec) throws ObjetoNaoExisteException {
		this.repoExercicio.atualizar(oldExec, newExec);
	}

	public void removerExercicios(Exercicio exec) throws ObjetoNaoExisteException {
		this.repoExercicio.remover(exec);
	}

	public Exercicio buscarExercicio(TipoExercicio tipo) throws ObjetoNaoExisteException {
		List<Exercicio> exercicioList = new ArrayList<>(this.repoExercicio.listar());
		return exercicioList.stream().filter(exercicio -> exercicio.getNome().equals(tipo)).reduce((a, b) -> b)
				.orElse(null);
	}

	public List<Exercicio> listarExercicios() {
		return this.repoExercicio.listar();
	}
}
