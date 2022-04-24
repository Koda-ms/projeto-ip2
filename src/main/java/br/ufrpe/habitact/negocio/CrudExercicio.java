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

    public CrudExercicio(){
        this.repoExercicio = new Repositorio<>();
    }

    public void inserirExercicios(Exercicio exec) throws ObjetoDuplicadoException {
        try {
            this.repoExercicio.inserir(exec);
        } catch (ObjetoDuplicadoException error) {
            throw new ObjetoDuplicadoException("Exercicio já cadastrado na base de dados");
        }
    }

    public void alterarExercicio(Exercicio oldExec, Exercicio newExec) throws ObjetoNaoExisteException {
        boolean isFound = false;

        List<Exercicio> exercicioList = this.repoExercicio.listar();
        for (int index = 0; index < exercicioList.size() && !isFound; index += 1) {
            if (exercicioList.get(index).equals(oldExec)) {
                try{
                    this.repoExercicio.atualizar(oldExec, newExec);
                } catch (ObjetoNaoExisteException error){
                    throw new ObjetoNaoExisteException("Exercicio não encontrado na base de dados");
                }
                isFound = true;
            }
        }
    }

    public void removerExercicios(Exercicio exec) throws ObjetoNaoExisteException {
        try {
            this.repoExercicio.remover(exec);
        } catch (ObjetoNaoExisteException error){
            throw new ObjetoNaoExisteException("Exercicio não encontrado na base de dados");
        }
    }

    public Exercicio buscarExercicio(TipoExercicio tipo) throws ObjetoNaoExisteException {
        List<Exercicio> exercicioList = new ArrayList<>(this.repoExercicio.listar());
        return exercicioList.stream()
                .filter(exercicio -> exercicio.getNome().equals(tipo))
                .reduce((a, b) -> b)
                .orElse(null);
    }

    public List<Exercicio> listarExercicios() {
        return this.repoExercicio.listar();
    }
}
