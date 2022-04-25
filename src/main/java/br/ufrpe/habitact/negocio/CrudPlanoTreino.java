package br.ufrpe.habitact.negocio;

import br.ufrpe.habitact.dados.IRepositorio;
import br.ufrpe.habitact.dados.Repositorio;
import br.ufrpe.habitact.excecoes.MaisDeUmPlanoNoMesmoPeriodoException;
import br.ufrpe.habitact.excecoes.MaisDeUmTreinoNoMesmoDiaException;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.negocio.beans.*;

import java.util.List;

public class CrudPlanoTreino{
    private IRepositorio<PlanoTreino> repositorioPlanoTreino;

    public CrudPlanoTreino(){
        this.repositorioPlanoTreino = new Repositorio<>();
    }

    public void cadastrarPlanoTreino(PlanoTreino plano) throws MaisDeUmPlanoNoMesmoPeriodoException, ObjetoDuplicadoException {
        List<PlanoTreino> lista = this.listarPlanoTreino();
        boolean clienteRepetido = false;
        for(PlanoTreino p : lista){
            if(p.getCliente().equals(plano.getCliente())){
                clienteRepetido = true;
            }
        }

        if(!clienteRepetido){
            this.repositorioPlanoTreino.inserir(plano);
        }
    }

    public void adicionarExercicio(Cliente x, Exercicio exercicio){

    }

    public void alterarTreino(PlanoTreino planoAntigo, PlanoTreino planoNovo) throws ObjetoNaoExisteException {
        try {
            this.repositorioPlanoTreino.atualizar(planoAntigo, planoNovo);
        }
        catch (ObjetoNaoExisteException e) {
            throw new ObjetoNaoExisteException("O plano inserido não existe");
        }
    }

    public List<PlanoTreino> listarPlanoTreino(){
        return repositorioPlanoTreino.listar();
    }
}