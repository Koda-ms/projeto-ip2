package br.ufrpe.habitact.negocio;

import br.ufrpe.habitact.dados.IRepositorio;
import br.ufrpe.habitact.dados.Repositorio;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.negocio.beans.Exercicio;
import br.ufrpe.habitact.negocio.beans.PlanoTreino;
import br.ufrpe.habitact.negocio.beans.enums.TipoExercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControladorExercicio {
	private IRepositorio<Exercicio> repoExercicio;
	private static ControladorExercicio instance;

	private ControladorExercicio() {
		this.repoExercicio = new Repositorio<>();
	}
	
	public static ControladorExercicio getInstance() {
        if (instance == null) {
            instance = new ControladorExercicio();
        }
        return instance;
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

	public List<Exercicio> buscarExercicio(TipoExercicio tipo) throws ObjetoNaoExisteException {
		List<Exercicio> exercicioList = new ArrayList<>(this.repoExercicio.listar());
		List<Exercicio> lista = exercicioList.stream()
				.filter(plano -> plano.getNome().equals(tipo)).collect(Collectors.toList());
		return lista;
	}

	public List<Exercicio> listarExercicios() {
		return this.repoExercicio.listar();
	}
}
