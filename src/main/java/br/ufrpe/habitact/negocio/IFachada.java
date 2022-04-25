package br.ufrpe.habitact.negocio;

import java.util.List;

import br.ufrpe.habitact.excecoes.MaisDeUmPlanoNoMesmoPeriodoException;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.negocio.beans.Alimento;
import br.ufrpe.habitact.negocio.beans.Cliente;
import br.ufrpe.habitact.negocio.beans.Exercicio;
import br.ufrpe.habitact.negocio.beans.PlanoAlimentar;
import br.ufrpe.habitact.negocio.beans.enums.TipoExercicio;

public interface IFachada {

	void cadastrarPlanoAlimentar(PlanoAlimentar planoAlimentar)
			throws ObjetoDuplicadoException, MaisDeUmPlanoNoMesmoPeriodoException;

	void inserirAlimentoNoPlano(PlanoAlimentar planoAlimentar, Alimento novoAlimento)
			throws ObjetoDuplicadoException, ObjetoNaoExisteException;

	void removerAlimentoNoPlano(PlanoAlimentar planoAlimentar, Alimento alimentoAlvo) throws ObjetoNaoExisteException;

	void alterarPlanoAlimentar(PlanoAlimentar planoAlimentarAnterior, PlanoAlimentar planoAlimentarAtual)
			throws ObjetoNaoExisteException;

	void removerPlanoALimentar(PlanoAlimentar planoAlimento) throws ObjetoNaoExisteException;

	PlanoAlimentar buscarPlanoAlimentar(Cliente cliente) throws ObjetoNaoExisteException;

	List<PlanoAlimentar> listarPlanoAlimentar();

	void inserirExercicios(Exercicio exec) throws ObjetoDuplicadoException;

	void alterarExercicio(Exercicio oldExec, Exercicio newExec) throws ObjetoNaoExisteException;

	void removerExercicios(Exercicio exec) throws ObjetoNaoExisteException;

	Exercicio buscarExercicio(TipoExercicio tipo) throws ObjetoNaoExisteException;

	List<Exercicio> listarExercicios();

}