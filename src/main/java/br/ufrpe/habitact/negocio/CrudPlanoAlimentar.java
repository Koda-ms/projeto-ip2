package br.ufrpe.habitact.negocio;

import java.util.List;

import br.ufrpe.habitact.negocio.beans.Alimento;
import br.ufrpe.habitact.negocio.beans.Cliente;
import br.ufrpe.habitact.negocio.beans.PlanoAlimentar;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.dados.IRepositorio;
import br.ufrpe.habitact.dados.Repositorio;
import br.ufrpe.habitact.excecoes.MaisDeUmPlanoNoMesmoPeriodoException;
import br.ufrpe.habitact.excecoes.AlimentoComMesmoNomeException;

public class CrudPlanoAlimentar {
	//atributos
	private IRepositorio<PlanoAlimentar> repositorioPlanoAlimentar;
	private IRepositorio<Alimento> repositorioAlimento;

	//construtor default
	public CrudPlanoAlimentar() {
		this.repositorioPlanoAlimentar = new Repositorio<>();
	}
	
	//método para cadastrar o plano de alimento no sistema
	public void cadastrarPlanoAlimentar(PlanoAlimentar plano_alimentar) throws ObjetoDuplicadoException, MaisDeUmPlanoNoMesmoPeriodoException{
		
		List<PlanoAlimentar> lista_de_alimentos = this.listarPlanoAlimentar();
		boolean clienteIgual = false;
		for(PlanoAlimentar p : lista_de_alimentos) {
			if(p.getCliente().equals(plano_alimentar.getCliente())) {
				clienteIgual = true;
			}
		}
		
		if(!clienteIgual) {
			this.repositorioPlanoAlimentar.inserir(plano_alimentar);
		}
	}
	
	public void inserirAlimentoNoPlano(PlanoAlimentar plano_alimentar) {
		
		List<Alimento> alimentosParaOPlano = plano_alimentar.getAlimentos();
		plano_alimentar.setAlimentos(alimentosParaOPlano);
	}
	
	//método para modificar o plano de alimento no sistema
	public void mudarAlimento(PlanoAlimentar planoAlimentarAnterior, PlanoAlimentar planoAlimentarAtual) throws ObjetoNaoExisteException{
		
		try {
			this.repositorioPlanoAlimentar.atualizar(planoAlimentarAnterior, planoAlimentarAtual);
		} catch (ObjetoNaoExisteException e) {
			throw new ObjetoNaoExisteException("O plano alimentar inserido não foi encontrado");
		}
	}
	
	//método para modificar o plano de alimento no sistema
	public List<PlanoAlimentar> listarPlanoAlimentar(){
		return repositorioPlanoAlimentar.listar();
	}
	
}
