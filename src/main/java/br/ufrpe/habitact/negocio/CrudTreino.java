package br.ufrpe.habitact.negocio;

import br.ufrpe.habitact.dados.IRepositorio;
import br.ufrpe.habitact.dados.Repositorio;
import br.ufrpe.habitact.excecoes.MaisDeUmTreinoNoMesmoDiaException;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.negocio.beans.Exercicio;
import br.ufrpe.habitact.negocio.beans.Treino;

import java.util.List;

public class CrudTreino {
    private IRepositorio<Treino> repositorioTreino;
    private static long qtdDeExecicios;

    public CrudTreino(){
      this.repositorioTreino = new Repositorio<>();
    }

    public void inserirTreino(Treino treino) throws MaisDeUmTreinoNoMesmoDiaException{
        try{
            this.repositorioTreino.inserir(treino);
            qtdDeExecicios = qtdDeExecicios + 1;
        }catch (ObjetoDuplicadoException e){
            throw new MaisDeUmTreinoNoMesmoDiaException("Só pode haver um treino por dia");
        }
    }

    public List<Treino> listarTreino(Treino treinoAntigo, Treino treinoNovo){
        return repositorioTreino.listar();
    }
}