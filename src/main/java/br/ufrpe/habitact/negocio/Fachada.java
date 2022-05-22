package br.ufrpe.habitact.negocio;

import java.util.List;

import br.ufrpe.habitact.excecoes.MaisDeUmPlanoNoMesmoPeriodoException;
import br.ufrpe.habitact.excecoes.MaisDeUmTreinoNoMesmoDiaException;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.excecoes.ObjetoNaoExisteException;
import br.ufrpe.habitact.excecoes.SenhaIncorretaException;
import br.ufrpe.habitact.negocio.beans.Alimento;
import br.ufrpe.habitact.negocio.beans.Cliente;
import br.ufrpe.habitact.negocio.beans.Exercicio;
import br.ufrpe.habitact.negocio.beans.PlanoAlimentar;
import br.ufrpe.habitact.negocio.beans.PlanoTreino;
import br.ufrpe.habitact.negocio.beans.Treino;
import br.ufrpe.habitact.negocio.beans.Usuario;
import br.ufrpe.habitact.negocio.beans.enums.CategoriaTreino;
import br.ufrpe.habitact.negocio.beans.enums.TipoExercicio;
import br.ufrpe.habitact.negocio.beans.*;

public class Fachada {

	private ControladorAlimento alimentos;
	private ControladorExercicio exercicios;
	private ControladorPlanoAlimentar planosAlimentares;
	private ControladorPlanoTreino planosTreinos;
	private ControladorTreino treinos;
	private ControladorUsuario usuarios;

	private static Fachada instance;

	@SuppressWarnings("static-access")
	private Fachada() {
		this.alimentos = alimentos.getInstance();
		this.exercicios = exercicios.getInstance();
		this.planosAlimentares = planosAlimentares.getInstance();
		this.planosTreinos = planosTreinos.getInstance();
		this.treinos = treinos.getInstance();
		this.usuarios = usuarios.getInstance();
	}

	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	public void adicionarAlimento(Alimento alimento) throws ObjetoDuplicadoException {
		alimentos.adicionarAlimento(alimento);
	}

	public List<Alimento> buscarAlimento(String nome) throws ObjetoNaoExisteException {
		return alimentos.buscarAlimento(nome);
	}

	public void removerAlimento(Alimento alimento) throws ObjetoNaoExisteException {
		alimentos.removerAlimento(alimento);
	}

	public List<Alimento> listarAlimento() {
		return alimentos.listarAlimento();
	}

	public void inserirExercicios(Exercicio exec) throws ObjetoDuplicadoException {
		exercicios.inserirExercicios(exec);
	}

	public void alterarExercicio(Exercicio oldExec, Exercicio newExec) throws ObjetoNaoExisteException {
		exercicios.alterarExercicio(oldExec, newExec);
	}

	public void removerExercicios(Exercicio exec) throws ObjetoNaoExisteException {
		exercicios.removerExercicios(exec);
	}

	public List<Exercicio> buscarExercicio(TipoExercicio tipo) throws ObjetoNaoExisteException {
		return exercicios.buscarExercicio(tipo);
	}

	public List<Exercicio> listarExercicios() {
		return exercicios.listarExercicios();
	}

	public void cadastrarPlanoAlimentar(PlanoAlimentar planoAlimentar)
			throws ObjetoDuplicadoException, MaisDeUmPlanoNoMesmoPeriodoException {
		planosAlimentares.cadastrarPlanoAlimentar(planoAlimentar);
	}

	public void inserirAlimentoNoPlano(PlanoAlimentar planoAlimentar, Alimento novoAlimento)
			throws ObjetoDuplicadoException, ObjetoNaoExisteException {
		planosAlimentares.inserirAlimentoNoPlano(planoAlimentar, novoAlimento);
	}

	public void removerAlimentoNoPlano(PlanoAlimentar planoAlimentar, Alimento alimentoAlvo)
			throws ObjetoNaoExisteException {
		planosAlimentares.removerAlimentoNoPlano(planoAlimentar, alimentoAlvo);
	}

	public void alterarPlanoAlimentar(PlanoAlimentar planoAlimentarAnterior, PlanoAlimentar planoAlimentarAtual)
			throws ObjetoNaoExisteException {
		planosAlimentares.alterarPlanoAlimentar(planoAlimentarAnterior, planoAlimentarAtual);
	}

	public void removerPlanoALimentar(PlanoAlimentar planoAlimento) throws ObjetoNaoExisteException {
		planosAlimentares.removerPlanoALimentar(planoAlimento);
	}

	public List<PlanoAlimentar> buscarPlanoAlimentar(Cliente cliente) throws ObjetoNaoExisteException {
		return planosAlimentares.buscarPlanoAlimentar(cliente);
	}

	public List<PlanoAlimentar> listarPlanoAlimentar() {
		return planosAlimentares.listarPlanoAlimentar();
	}

	public void cadastrarPlanoTreino(PlanoTreino planoTreino)
			throws ObjetoDuplicadoException, MaisDeUmPlanoNoMesmoPeriodoException {
		planosTreinos.cadastrarPlanoTreino(planoTreino);
	}

	public void inserirTreinoNoPlano(PlanoTreino planoTreino, Treino novoTreino)
			throws ObjetoDuplicadoException, ObjetoNaoExisteException, MaisDeUmTreinoNoMesmoDiaException {
		planosTreinos.inserirTreinoNoPlano(planoTreino, novoTreino);
	}

	public void removerTreinoNoPlano(PlanoTreino planoTreino, Treino treinoAlvo) throws ObjetoNaoExisteException {
		planosTreinos.removerTreinoNoPlano(planoTreino, treinoAlvo);
	}

	public void alterarPlanoDeTreino(PlanoTreino planoAntigo, PlanoTreino planoNovo) throws ObjetoNaoExisteException {
		planosTreinos.alterarPlanoDeTreino(planoAntigo, planoNovo);
	}

	public List<PlanoTreino> buscarPlanoTreino(Cliente cliente) throws ObjetoNaoExisteException {
		return planosTreinos.buscarPlanoTreino(cliente);
	}

	public void removerPlanoTreino(PlanoTreino treino) throws ObjetoNaoExisteException {
		planosTreinos.removerPlanoTreino(treino);
	}

	public List<PlanoTreino> listarPlanoTreino() {
		return planosTreinos.listarPlanoTreino();
	}

	public void inserirTreino(Treino treino) throws ObjetoDuplicadoException {
		treinos.inserirTreino(treino);
	}

	public void inserirExercicioNoTreino(Treino treino, Exercicio novoExercicio)
			throws ObjetoDuplicadoException, ObjetoNaoExisteException {
		treinos.inserirExercicioNoTreino(treino, novoExercicio);
	}

	public void removerExercicioDoTreino(Treino treino, Exercicio exercicioAlvo) throws ObjetoNaoExisteException {
		treinos.removerExercicioDoTreino(treino, exercicioAlvo);
	}

	public void removerTreino(Treino treino) throws ObjetoNaoExisteException {
		treinos.removerTreino(treino);
	}

	public List<Treino> buscarTreino(CategoriaTreino categoria) throws ObjetoNaoExisteException {
		return treinos.buscarTreino(categoria);
	}

	public void alterarTreino(Treino treinoAntigo, Treino novoTreino) throws ObjetoNaoExisteException {
		treinos.alterarTreino(treinoAntigo, novoTreino);
	}

	public List<Treino> listarTreino() {
		return treinos.listarTreino();
	}

	public void cadastrarUsuario(Usuario u) throws ObjetoDuplicadoException {
		usuarios.cadastrarUsuario(u);
	}

	public Usuario autenticarUsuario(String email, String senha) {
		return usuarios.autenticarUsuario(email, senha);
	}

	public void alterarDados(Usuario usuarioAntigo, Usuario usuarioNovo, String senha)
			throws SenhaIncorretaException, ObjetoNaoExisteException {
		usuarios.alterarDados(usuarioAntigo, usuarioNovo, senha);
	}

	public List<Usuario> buscarUsuario(String nome) throws ObjetoNaoExisteException {
		return usuarios.buscarUsuario(nome);
	}

	public List<Usuario> listarUsuarios() {
		return usuarios.listarUsuarios();
	}

	public List<Cliente> listarClientes() {
		return usuarios.listarClientes();
	}

	public List<Administrador> listarAdms() {
		return usuarios.listarAdms();
	}
}
