package br.ufrpe.habitact.negocio;

import br.ufrpe.habitact.dados.IRepositorio;
import br.ufrpe.habitact.dados.Repositorio;
import br.ufrpe.habitact.excecoes.MaisDeUmTreinoNoMesmoDiaException;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.negocio.beans.Cliente;
import br.ufrpe.habitact.negocio.beans.Exercicio;
import br.ufrpe.habitact.negocio.beans.PlanoTreino;
import br.ufrpe.habitact.negocio.beans.Treino;
import br.ufrpe.habitact.negocio.beans.enums.CategoriaTreino;
import br.ufrpe.habitact.negocio.beans.enums.TipoExercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControladorTreino {
    private IRepositorio<Treino> repositorioTreino;

    public ControladorTreino(){
      this.repositorioTreino = new Repositorio<>();
    }

    public void inserirTreino(Treino treino) throws ObjetoDuplicadoException {
        this.repositorioTreino.inserir(treino);
    }

    public void inserirExercicio(Treino treino, Exercicio novoExercicio) throws ObjetoDuplicadoException, ObjetoNaoExisteException{
        Treino treinoAntigo = treino;
        treino.inserirExercicio(novoExercicio);
        this.repositorioTreino.atualizar(treinoAntigo, treino);
    }

    public void removerExercicio(Treino treino, Exercicio exercicioAlvo) throws ObjetoNaoExisteException{
        Treino treinoNovo = treino;
        treinoNovo.removerExercicio(exercicioAlvo);
        this.repositorioTreino.atualizar(treino, treinoNovo);
    }

    public void removerTreino(Treino treino) throws ObjetoNaoExisteException {
        this.repositorioTreino.remover(treino);
    }

    public List<Treino> buscarTreino(CategoriaTreino categoria) throws ObjetoNaoExisteException {
        List<Treino> treinoList = new ArrayList<>(this.repositorioTreino.listar());
        List<Treino> lista = treinoList.stream()
				.filter(plano -> plano.getModalidade().equals(categoria)).collect(Collectors.toList());
		return lista;
    }

    public void alterarTreino(Treino treinoAntigo, Treino novoTreino) throws ObjetoNaoExisteException {
        this.repositorioTreino.atualizar(treinoAntigo, novoTreino);
    }

    public List<Treino> listarTreino(Treino treinoAntigo, Treino treinoNovo){
        return repositorioTreino.listar();
    }
}