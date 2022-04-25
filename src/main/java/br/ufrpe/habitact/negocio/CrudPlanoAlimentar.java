package br.ufrpe.habitact.negocio;

import java.util.List;

import br.ufrpe.habitact.dados.IRepositorio;
import br.ufrpe.habitact.dados.Repositorio;
import br.ufrpe.habitact.excecoes.MaisDeUmPlanoNoMesmoPeriodoException;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.negocio.beans.Alimento;
import br.ufrpe.habitact.negocio.beans.PlanoAlimentar;

public class CrudPlanoAlimentar {
	// atributos
	private IRepositorio<PlanoAlimentar> repositorioPlanoAlimentar;

	// construtor default
	public CrudPlanoAlimentar() {
		this.repositorioPlanoAlimentar = new Repositorio<>();
	}

	// método para cadastrar o plano de alimento no sistema
	public void cadastrarPlanoAlimentar(PlanoAlimentar planoAlimentar)
			throws ObjetoDuplicadoException, MaisDeUmPlanoNoMesmoPeriodoException {
		for (PlanoAlimentar p : this.listarPlanoAlimentar()) {
			if (p.getCliente().equals(planoAlimentar.getCliente())
					&& (p.getDataInicio().equals(planoAlimentar.getDataInicio())
							| p.getDataFim().equals(planoAlimentar.getDataFim())
							| ((p.getDataFim().isBefore(planoAlimentar.getDataFim()))
									&& (p.getDataInicio().isAfter(planoAlimentar.getDataInicio()))))) {
				throw new MaisDeUmPlanoNoMesmoPeriodoException("Cliente já tem um plano neste período");
			}
		}
		this.repositorioPlanoAlimentar.inserir(planoAlimentar);
	}

	public void inserirAlimentoNoPlano(PlanoAlimentar planoAlimentar, Alimento novoAlimento)
			throws ObjetoDuplicadoException, ObjetoNaoExisteException {
		PlanoAlimentar planoAntigo = planoAlimentar;
		planoAlimentar.cadastrarAlimentos(novoAlimento);
		repositorioPlanoAlimentar.atualizar(planoAntigo, planoAlimentar);
	}

	// método para modificar o plano de alimento no sistema
	public void alterarPlanoAlimentar(PlanoAlimentar planoAlimentarAnterior, PlanoAlimentar planoAlimentarAtual)
			throws ObjetoNaoExisteException {
		repositorioPlanoAlimentar.atualizar(planoAlimentarAnterior, planoAlimentarAtual);
	}

	// método para modificar o plano de alimento no sistema
	public List<PlanoAlimentar> listarPlanoAlimentar() {
		return repositorioPlanoAlimentar.listar();
	}

}
