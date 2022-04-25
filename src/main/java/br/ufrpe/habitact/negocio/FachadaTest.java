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

public class FachadaTest implements IFachada {
	
	ControladorPlanoAlimentar planoA;
	ControladorExercicio exerc;
	
	@Override
	public void cadastrarPlanoAlimentar(PlanoAlimentar planoAlimentar)
			throws ObjetoDuplicadoException, MaisDeUmPlanoNoMesmoPeriodoException {
		planoA.cadastrarPlanoAlimentar(planoAlimentar);
	}
	@Override
	public void inserirAlimentoNoPlano(PlanoAlimentar planoAlimentar, Alimento novoAlimento)
			throws ObjetoDuplicadoException, ObjetoNaoExisteException {
		planoA.inserirAlimentoNoPlano(planoAlimentar, novoAlimento);
	}
	@Override
	public void removerAlimentoNoPlano(PlanoAlimentar planoAlimentar, Alimento alimentoAlvo)
			throws ObjetoNaoExisteException {
		planoA.removerAlimentoNoPlano(planoAlimentar, alimentoAlvo);
	}
	@Override
	public void alterarPlanoAlimentar(PlanoAlimentar planoAlimentarAnterior, PlanoAlimentar planoAlimentarAtual)
			throws ObjetoNaoExisteException {
		planoA.alterarPlanoAlimentar(planoAlimentarAnterior, planoAlimentarAtual);
	}
	@Override
	public void removerPlanoALimentar(PlanoAlimentar planoAlimento) throws ObjetoNaoExisteException {
		planoA.removerPlanoALimentar(planoAlimento);
	}
	@Override
	public List<PlanoAlimentar> listarPlanoAlimentar() {
		return planoA.listarPlanoAlimentar();
	}
	@Override
	public void inserirExercicios(Exercicio exec) throws ObjetoDuplicadoException {
		exerc.inserirExercicios(exec);
	}
	@Override
	public void alterarExercicio(Exercicio oldExec, Exercicio newExec) throws ObjetoNaoExisteException {
		exerc.alterarExercicio(oldExec, newExec);
	}
	@Override
	public void removerExercicios(Exercicio exec) throws ObjetoNaoExisteException {
		exerc.removerExercicios(exec);
	}
	@Override
	public List<Exercicio> listarExercicios() {
		return exerc.listarExercicios();
	}
	
	

}
