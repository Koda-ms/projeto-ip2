package br.ufrpe.habitact.negocio;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.habitact.dados.IRepositorio;
import br.ufrpe.habitact.dados.Repositorio;
import br.ufrpe.habitact.excecoes.MaisDeUmPlanoNoMesmoPeriodoException;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.negocio.beans.Alimento;
import br.ufrpe.habitact.negocio.beans.Cliente;
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

	// método para inserir um Alimento em um PlanoAlimentar
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

	// método para remover alimento do plano
	public void removerAlimentoDoPlano(PlanoAlimentar alimento) throws ObjetoNaoExisteException {

		this.repositorioPlanoAlimentar.remover(alimento);

	}

	public void removerPlanoALimentar(PlanoAlimentar planoAlimento) throws ObjetoNaoExisteException {

		this.repositorioPlanoAlimentar.remover(planoAlimento);

	}

	public PlanoAlimentar buscarPlanoAlimentar(Cliente cliente) throws ObjetoNaoExisteException {
		List<PlanoAlimentar> listarPlanoAlimentar = new ArrayList<>(this.repositorioPlanoAlimentar.listar());
		return listarPlanoAlimentar.stream().filter(plano -> plano.getCliente().equals(cliente)).reduce((a, b) -> b)
				.orElse(null);
	}

	// método para listar o plano de alimento no sistema
	public List<PlanoAlimentar> listarPlanoAlimentar() {
		return repositorioPlanoAlimentar.listar();
	}

}
