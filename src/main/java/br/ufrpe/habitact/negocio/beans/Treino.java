package br.ufrpe.habitact.negocio.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Treino {
    private ArrayList<Exercicio> exercicios;
    private double duracao;
    private TipoExercicio tipo;

    public void adicionar_exercicio(Exercicio exercicio){
        this.exercicios.add(exercicio);
    }

    public double duracao_total(){
        double SomaTotal = 0;
        for(int i = 0; i < this.exercicios.size(); i++){
            SomaTotal = SomaTotal + this.exercicios.get(i).getDuracaoExercicio();
        }
        return SomaTotal;
    }
}
