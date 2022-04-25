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

public class CrudTreino {
    private IRepositorio<Treino> repositorioTreino;
    private static long qtdDeExecicios;

    public CrudTreino(){
      this.repositorioTreino = new Repositorio<>();
    }

    public void inserirTreino(Treino treino) throws ObjetoDuplicadoException {
        this.repositorioTreino.inserir(treino);
        qtdDeExecicios = qtdDeExecicios + 1;
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
        qtdDeExecicios = qtdDeExecicios - 1;
    }

    public void removerTreino(Treino treino) throws ObjetoNaoExisteException {
        this.repositorioTreino.remover(treino);
    }

    public Treino buscarTreino(CategoriaTreino categoria) throws ObjetoNaoExisteException {
        List<Treino> treinoList = new ArrayList<>(this.repositorioTreino.listar());
        return treinoList.stream().filter(treino -> treino.getModalidade().equals(categoria)).reduce((a, b) -> b)
                .orElse(null);
    }

    public void alterarTreino(Treino treinoAntigo, Treino novoTreino) throws ObjetoNaoExisteException {
        this.repositorioTreino.atualizar(treinoAntigo, novoTreino);
    }

    public List<Treino> listarTreino(Treino treinoAntigo, Treino treinoNovo){
        return repositorioTreino.listar();
    }
}