package br.ufrpe.habitact.sessao;

import br.ufrpe.habitact.negocio.beans.*;

public class Sessao {
    private static Sessao instance;
    private Usuario usuario;
    private PlanoAlimentar planoAlimentar;
    private PlanoTreino planoTreino;
    private Treino treino;
    private Exercicio exercicio;

    public static Sessao getInstance() {
        if (instance == null) {
            instance = new Sessao();
        }
        return instance;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public PlanoAlimentar getPlanoAlimentar() {
        return planoAlimentar;
    }

    public void setPlanoAlimentar(PlanoAlimentar planoAlimentar) {
        this.planoAlimentar = planoAlimentar;
    }

    public PlanoTreino getPlanoTreino() {
        return planoTreino;
    }

    public void setPlanoTreino(PlanoTreino planoTreino) {
        this.planoTreino = planoTreino;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }
}
