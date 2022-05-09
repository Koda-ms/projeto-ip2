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
import br.ufrpe.habitact.excecoes.*;
import br.ufrpe.habitact.negocio.beans.*;
import br.ufrpe.habitact.negocio.beans.enums.CategoriaTreino;
import br.ufrpe.habitact.negocio.beans.enums.TipoExercicio;

import java.util.List;

public interface IFachada {

	void adicionarAlimento(Alimento alimento) throws ObjetoDuplicadoException;

	List<Alimento> buscarAlimento(String nome) throws ObjetoNaoExisteException;

	void removerAlimento(Alimento alimento) throws ObjetoNaoExisteException;

	List<Alimento> listarAlimento();

	void inserirExercicios(Exercicio exec) throws ObjetoDuplicadoException;

	void alterarExercicio(Exercicio oldExec, Exercicio newExec) throws ObjetoNaoExisteException;

	void removerExercicios(Exercicio exec) throws ObjetoNaoExisteException;

	List<Exercicio> buscarExercicio(TipoExercicio tipo) throws ObjetoNaoExisteException;

	List<Exercicio> listarExercicios();

	void cadastrarPlanoAlimentar(PlanoAlimentar planoAlimentar)
			throws ObjetoDuplicadoException, MaisDeUmPlanoNoMesmoPeriodoException;

	void inserirAlimentoNoPlano(PlanoAlimentar planoAlimentar, Alimento novoAlimento)
			throws ObjetoDuplicadoException, ObjetoNaoExisteException;

	void removerAlimentoNoPlano(PlanoAlimentar planoAlimentar, Alimento alimentoAlvo) throws ObjetoNaoExisteException;

	void alterarPlanoAlimentar(PlanoAlimentar planoAlimentarAnterior, PlanoAlimentar planoAlimentarAtual)
			throws ObjetoNaoExisteException;

	void removerPlanoALimentar(PlanoAlimentar planoAlimento) throws ObjetoNaoExisteException;

	List<PlanoAlimentar> buscarPlanoAlimentar(Cliente cliente) throws ObjetoNaoExisteException;

	List<PlanoAlimentar> listarPlanoAlimentar();

	void cadastrarPlanoTreino(PlanoTreino planoTreino)
			throws ObjetoDuplicadoException, MaisDeUmPlanoNoMesmoPeriodoException;

	void inserirTreinoNoPlano(PlanoTreino planoTreino, Treino novoTreino)
			throws ObjetoDuplicadoException, ObjetoNaoExisteException, MaisDeUmTreinoNoMesmoDiaException;

	void removerTreinoNoPlano(PlanoTreino planoTreino, Treino treinoAlvo) throws ObjetoNaoExisteException;

	void alterarPlanoDeTreino(PlanoTreino planoAntigo, PlanoTreino planoNovo) throws ObjetoNaoExisteException;

	List<PlanoTreino> buscarPlanoTreino(Cliente cliente) throws ObjetoNaoExisteException;

	void removerPlanoTreino(PlanoTreino treino) throws ObjetoNaoExisteException;

	List<PlanoTreino> listarPlanoTreino();

	void inserirTreino(Treino treino) throws ObjetoDuplicadoException;

	void inserirExercicio(Treino treino, Exercicio novoExercicio)
			throws ObjetoDuplicadoException, ObjetoNaoExisteException;

	void removerExercicio(Treino treino, Exercicio exercicioAlvo) throws ObjetoNaoExisteException;

	void removerTreino(Treino treino) throws ObjetoNaoExisteException;

	List<Treino> buscarTreino(CategoriaTreino categoria) throws ObjetoNaoExisteException;

	void alterarTreino(Treino treinoAntigo, Treino novoTreino) throws ObjetoNaoExisteException;

	List<Treino> listarTreino();

	void cadastrarUsuario(Usuario u) throws ObjetoDuplicadoException;

	Usuario autenticarUsuario(String email, String senha);

	void alterarDados(Usuario usuarioAntigo, Usuario usuarioNovo, String senha)
			throws SenhaIncorretaException, ObjetoNaoExisteException;

	List<Usuario> buscarUsuario(String nome) throws ObjetoNaoExisteException;

	List<Usuario> listarUsuarios();

}