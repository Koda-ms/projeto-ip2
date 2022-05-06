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

public class Fachada implements IFachada {

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

    @Override
    public void adicionarAlimento(Alimento alimento) throws ObjetoDuplicadoException {
        alimentos.adicionarAlimento(alimento);
    }

    @Override
    public List<Alimento> buscarAlimento(String nome) throws ObjetoNaoExisteException {
        return alimentos.buscarAlimento(nome);
    }

    @Override
    public void removerAlimento(Alimento alimento) throws ObjetoNaoExisteException {
        alimentos.removerAlimento(alimento);
    }

    @Override
    public List<Alimento> listarAlimento() {
        return alimentos.listarAlimento();
    }

    @Override
    public void inserirExercicios(Exercicio exec) throws ObjetoDuplicadoException {
        exercicios.inserirExercicios(exec);
    }

    @Override
    public void alterarExercicio(Exercicio oldExec, Exercicio newExec) throws ObjetoNaoExisteException {
        exercicios.alterarExercicio(oldExec, newExec);
    }

    @Override
    public void removerExercicios(Exercicio exec) throws ObjetoNaoExisteException {
        exercicios.removerExercicios(exec);
    }

    @Override
    public List<Exercicio> buscarExercicio(TipoExercicio tipo) throws ObjetoNaoExisteException {
        return exercicios.buscarExercicio(tipo);
    }

    @Override
    public List<Exercicio> listarExercicios() {
        return exercicios.listarExercicios();
    }

    @Override
    public void cadastrarPlanoAlimentar(PlanoAlimentar planoAlimentar)
            throws ObjetoDuplicadoException, MaisDeUmPlanoNoMesmoPeriodoException {
        planosAlimentares.cadastrarPlanoAlimentar(planoAlimentar);
    }

    @Override
    public void inserirAlimentoNoPlano(PlanoAlimentar planoAlimentar, Alimento novoAlimento)
            throws ObjetoDuplicadoException, ObjetoNaoExisteException {
        planosAlimentares.inserirAlimentoNoPlano(planoAlimentar, novoAlimento);
    }

    @Override
    public void removerAlimentoNoPlano(PlanoAlimentar planoAlimentar, Alimento alimentoAlvo)
            throws ObjetoNaoExisteException {
        planosAlimentares.removerAlimentoNoPlano(planoAlimentar, alimentoAlvo);
    }

    @Override
    public void alterarPlanoAlimentar(PlanoAlimentar planoAlimentarAnterior, PlanoAlimentar planoAlimentarAtual)
            throws ObjetoNaoExisteException {
        planosAlimentares.alterarPlanoAlimentar(planoAlimentarAnterior, planoAlimentarAtual);
    }

    @Override
    public void removerPlanoALimentar(PlanoAlimentar planoAlimento) throws ObjetoNaoExisteException {
        planosAlimentares.removerPlanoALimentar(planoAlimento);
    }

    @Override
    public List<PlanoAlimentar> buscarPlanoAlimentar(Cliente cliente) throws ObjetoNaoExisteException {
        return planosAlimentares.buscarPlanoAlimentar(cliente);
    }

    @Override
    public List<PlanoAlimentar> listarPlanoAlimentar() {
        return planosAlimentares.listarPlanoAlimentar();
    }

    @Override
    public void cadastrarPlanoTreino(PlanoTreino planoTreino)
            throws ObjetoDuplicadoException, MaisDeUmPlanoNoMesmoPeriodoException {
        planosTreinos.cadastrarPlanoTreino(planoTreino);
    }

    @Override
    public void inserirTreinoNoPlano(PlanoTreino planoTreino, Treino novoTreino)
            throws ObjetoDuplicadoException, ObjetoNaoExisteException, MaisDeUmTreinoNoMesmoDiaException {
        planosTreinos.inserirTreinoNoPlano(planoTreino, novoTreino);
    }

    @Override
    public void removerTreinoNoPlano(PlanoTreino planoTreino, Treino treinoAlvo) throws ObjetoNaoExisteException {
        planosTreinos.removerTreinoNoPlano(planoTreino, treinoAlvo);
    }

    @Override
    public void alterarPlanoDeTreino(PlanoTreino planoAntigo, PlanoTreino planoNovo) throws ObjetoNaoExisteException {
        planosTreinos.alterarPlanoDeTreino(planoAntigo, planoNovo);
    }

    @Override
    public List<PlanoTreino> buscarPlanoTreino(Cliente cliente) throws ObjetoNaoExisteException {
        return planosTreinos.buscarPlanoTreino(cliente);
    }

    @Override
    public void removerPlanoTreino(PlanoTreino treino) throws ObjetoNaoExisteException {
        planosTreinos.removerPlanoTreino(treino);
    }

    @Override
    public List<PlanoTreino> listarPlanoTreino() {
        return planosTreinos.listarPlanoTreino();
    }

    @Override
    public void inserirTreino(Treino treino) throws ObjetoDuplicadoException {
        treinos.inserirTreino(treino);
    }

    @Override
    public void inserirExercicio(Treino treino, Exercicio novoExercicio)
            throws ObjetoDuplicadoException, ObjetoNaoExisteException {
        treinos.inserirExercicio(treino, novoExercicio);
    }

    @Override
    public void removerExercicio(Treino treino, Exercicio exercicioAlvo) throws ObjetoNaoExisteException {
        treinos.removerExercicio(treino, exercicioAlvo);
    }

    @Override
    public void removerTreino(Treino treino) throws ObjetoNaoExisteException {
        treinos.removerTreino(treino);
    }

    @Override
    public List<Treino> buscarTreino(CategoriaTreino categoria) throws ObjetoNaoExisteException {
        return treinos.buscarTreino(categoria);
    }

    @Override
    public void alterarTreino(Treino treinoAntigo, Treino novoTreino) throws ObjetoNaoExisteException {
        treinos.alterarTreino(treinoAntigo, novoTreino);
    }

    @Override
    public List<Treino> listarTreino(Treino treinoAntigo, Treino treinoNovo) {
        return treinos.listarTreino(treinoAntigo, treinoNovo);
    }

    @Override
    public void cadastrarUsuario(Usuario u) throws ObjetoDuplicadoException {
        usuarios.cadastrarUsuario(u);
    }

    @Override
    public Usuario autenticarUsuario(String email, String senha) {
        return usuarios.autenticarUsuario(email, senha);
    }

    @Override
    public void alterarDados(Usuario usuarioAntigo, Usuario usuarioNovo, String senha)
            throws SenhaIncorretaException, ObjetoNaoExisteException {
        usuarios.alterarDados(usuarioAntigo, usuarioNovo, senha);
    }

    @Override
    public List<Usuario> buscarUsuario(String nome) throws ObjetoNaoExisteException {
        return usuarios.buscarUsuario(nome);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarios.listarUsuarios();
    }

}