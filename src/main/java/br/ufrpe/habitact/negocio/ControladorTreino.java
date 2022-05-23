package br.ufrpe.habitact.negocio;

import br.ufrpe.habitact.dados.IRepositorio;
import br.ufrpe.habitact.dados.Repositorio;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.negocio.beans.Exercicio;
import br.ufrpe.habitact.negocio.beans.Treino;
import br.ufrpe.habitact.negocio.beans.enums.CategoriaTreino;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControladorTreino {
    private IRepositorio<Treino> repositorioTreino;
    private static ControladorTreino instance;

    private ControladorTreino(){
      this.repositorioTreino = new Repositorio<>();
    }

    public void inserirTreino(Treino treino) throws ObjetoDuplicadoException {
        this.repositorioTreino.inserir(treino);
    }
    
    public static ControladorTreino getInstance() {
        if (instance == null) {
            instance = new ControladorTreino();
        }
        return instance;
    }

    public void inserirExercicioNoTreino(Treino treino, Exercicio novoExercicio) throws ObjetoDuplicadoException, ObjetoNaoExisteException{
        Treino treinoAntigo = treino;
        treino.inserirExercicio(novoExercicio);
        this.repositorioTreino.atualizar(treinoAntigo, treino);
    }

    public void removerExercicioDoTreino(Treino treino, Exercicio exercicioAlvo) throws ObjetoNaoExisteException{
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
				.filter(treino -> treino.getModalidade().equals(categoria)).collect(Collectors.toList());
		return lista;
    }

    public void alterarTreino(Treino treinoAntigo, Treino novoTreino) throws ObjetoNaoExisteException {
        this.repositorioTreino.atualizar(treinoAntigo, novoTreino);
    }

    public List<Treino> listarTreino(){
        return repositorioTreino.listar();
    }
}