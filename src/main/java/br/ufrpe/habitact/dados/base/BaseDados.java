package br.ufrpe.habitact.dados.base;

import br.ufrpe.habitact.excecoes.EmailDuplicadoException;
import br.ufrpe.habitact.excecoes.MaisDeUmPlanoNoMesmoPeriodoException;
import br.ufrpe.habitact.excecoes.ObjetoDuplicadoException;
import br.ufrpe.habitact.negocio.Fachada;
import br.ufrpe.habitact.negocio.beans.*;
import br.ufrpe.habitact.negocio.beans.enums.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class BaseDados {
    public BaseDados(){
        Usuario c1 = new Cliente("Apolo", "a", "a",
                LocalDate.of(2000, 06, 03), "Masculine", 114, 1.79 );
        Usuario c2 = new Cliente("July", "j", "j",
                LocalDate.of(2000, 05, 03), "Feminine", 70, 1.70 );
        Usuario c3 = new Cliente("João", "v", "v",
                LocalDate.of(2000, 04, 03), "Masculine", 80, 1.80 );
        Usuario c4 = new Cliente("Matheus", "m", "m",
                LocalDate.of(2000, 03, 03), "Masculine", 100, 1.90 );

        Usuario c5 = new Administrador("Apolo", "b", "b", LocalDate.of(2000, 06, 03), "a" );
        Usuario c6 = new Administrador("July", "c", "c", LocalDate.of(2000, 05, 03), "b" );

        try {
            Fachada.getInstance().cadastrarUsuario(c1);
            Fachada.getInstance().cadastrarUsuario(c2);
            Fachada.getInstance().cadastrarUsuario(c3);
            Fachada.getInstance().cadastrarUsuario(c4);
            Fachada.getInstance().cadastrarUsuario(c5);
            Fachada.getInstance().cadastrarUsuario(c6);
        } catch (ObjetoDuplicadoException | EmailDuplicadoException e) {
            e.printStackTrace();
        }

        Alimento a1 = new Alimento(Refeicao.CAFÉ_DA_MANHÃ, "Pão", 10, 15 );
        Alimento a2 = new Alimento(Refeicao.ALMOÇO, "Feijão", 10, 15 );
        Alimento a3 = new Alimento(Refeicao.JANTAR, "Sopa", 10, 15 );
        Alimento a4 = new Alimento(Refeicao.LANCHE, "Goiaba", 10, 15 );

        try {
            Fachada.getInstance().adicionarAlimento(a1);
            Fachada.getInstance().adicionarAlimento(a2);
            Fachada.getInstance().adicionarAlimento(a3);
            Fachada.getInstance().adicionarAlimento(a4);
        } catch (ObjetoDuplicadoException e) {
            e.printStackTrace();
        }

        PlanoAlimentar pa1 = new PlanoAlimentar((Cliente) c1,LocalDate.of(2022, 05, 15),
                LocalDate.of(2022, 05, 25), ObjetivoAlimentar.SUPLEMENTACAO_ALIMENTAR );
        try {
            pa1.cadastrarAlimentos(a1);
            pa1.cadastrarAlimentos(a2);
            pa1.cadastrarAlimentos(a3);
            pa1.cadastrarAlimentos(a4);
        } catch (ObjetoDuplicadoException e) {
            e.printStackTrace();
        }

        PlanoAlimentar pa2 = new PlanoAlimentar((Cliente) c2,LocalDate.of(2022, 05, 15),
                LocalDate.of(2022, 05, 25), ObjetivoAlimentar.MELHORAR_ALIMENTACAO );
        try {
            pa2.cadastrarAlimentos(a1);
            pa2.cadastrarAlimentos(a2);
            pa2.cadastrarAlimentos(a3);
            pa2.cadastrarAlimentos(a4);
        } catch (ObjetoDuplicadoException e) {
            e.printStackTrace();
        }

        PlanoAlimentar pa3 = new PlanoAlimentar((Cliente) c3,LocalDate.of(2022, 05, 15),
                LocalDate.of(2022, 05, 25), ObjetivoAlimentar.SUPLEMENTACAO_ALIMENTAR );
        try {
            pa3.cadastrarAlimentos(a1);
            pa3.cadastrarAlimentos(a2);
            pa3.cadastrarAlimentos(a3);
            pa3.cadastrarAlimentos(a4);
        } catch (ObjetoDuplicadoException e) {
            e.printStackTrace();
        }

        PlanoAlimentar pa4 = new PlanoAlimentar((Cliente) c4,LocalDate.of(2022, 05, 15),
                LocalDate.of(2022, 05, 25), ObjetivoAlimentar.MELHORAR_ALIMENTACAO );
        try {
            pa4.cadastrarAlimentos(a1);
            pa4.cadastrarAlimentos(a2);
            pa4.cadastrarAlimentos(a3);
            pa4.cadastrarAlimentos(a4);
        } catch (ObjetoDuplicadoException e) {
            e.printStackTrace();
        }

        try {
            Fachada.getInstance().cadastrarPlanoAlimentar(pa1);
            Fachada.getInstance().cadastrarPlanoAlimentar(pa2);
            Fachada.getInstance().cadastrarPlanoAlimentar(pa3);
            Fachada.getInstance().cadastrarPlanoAlimentar(pa4);
        } catch (ObjetoDuplicadoException | MaisDeUmPlanoNoMesmoPeriodoException e) {
            e.printStackTrace();
        }

        Exercicio e1 = new Exercicio(TipoExercicio.CAMINHADA, RitmoDoExercicio.BAIXO, 10, 3, 3);
        Exercicio e2 = new Exercicio(TipoExercicio.CICLISMO, RitmoDoExercicio.MEDIO, 10, 3, 3);
        Exercicio e3 = new Exercicio(TipoExercicio.CORRIDA, RitmoDoExercicio.ALTO, 10, 3, 3);
        Exercicio e4 = new Exercicio(TipoExercicio.HIDROGINASTICA, RitmoDoExercicio.BAIXO, 10, 3, 3);
        Exercicio e5 = new Exercicio(TipoExercicio.JIU_JITSU, RitmoDoExercicio.MEDIO, 10, 3, 3);
        Exercicio e6 = new Exercicio(TipoExercicio.MUSCULACAO, RitmoDoExercicio.ALTO, 10, 3, 3);
        Exercicio e7 = new Exercicio(TipoExercicio.NATACAO, RitmoDoExercicio.BAIXO, 10, 3, 3);

        try {
            Fachada.getInstance().inserirExercicios(e1);
            Fachada.getInstance().inserirExercicios(e2);
            Fachada.getInstance().inserirExercicios(e3);
            Fachada.getInstance().inserirExercicios(e4);
            Fachada.getInstance().inserirExercicios(e5);
            Fachada.getInstance().inserirExercicios(e6);
            Fachada.getInstance().inserirExercicios(e7);
        } catch (ObjetoDuplicadoException e) {
            e.printStackTrace();
        }

        ArrayList<Exercicio> exers = new ArrayList<>();
        exers.add(e1);
        exers.add(e2);
        exers.add(e3);
        exers.add(e4);

        ArrayList<Exercicio> exers2 = new ArrayList<>();
        exers2.add(e5);
        exers2.add(e6);
        exers2.add(e7);

        Treino t1 = new Treino(exers, CategoriaTreino.AEROBICO, LocalDate.of(2022, 05, 22));
        Treino t2 = new Treino(exers2, CategoriaTreino.ANAEROBICO, LocalDate.of(2022, 05, 23));

        try {
            Fachada.getInstance().inserirTreino(t1);
            Fachada.getInstance().inserirTreino(t2);
        } catch (ObjetoDuplicadoException e) {
            e.printStackTrace();
        }

        PlanoTreino pt1 = new PlanoTreino((Cliente) c1,LocalDate.of(2022, 05, 15),
                LocalDate.of(2022, 05, 25), ObjetivoTreino.FORTALECER_MUSCULOS);
        try {
            pt1.cadastrarTreino(t1);
            pt1.cadastrarTreino(t2);
        } catch (ObjetoDuplicadoException e) {
            e.printStackTrace();
        }

        PlanoTreino pt2 = new PlanoTreino((Cliente) c2,LocalDate.of(2022, 05, 15),
                LocalDate.of(2022, 05, 25), ObjetivoTreino.GANHAR_MASSA);
        try {
            pt2.cadastrarTreino(t1);
            pt2.cadastrarTreino(t2);
        } catch (ObjetoDuplicadoException e) {
            e.printStackTrace();
        }

        PlanoTreino pt3 = new PlanoTreino((Cliente) c3,LocalDate.of(2022, 05, 15),
                LocalDate.of(2022, 05, 25), ObjetivoTreino.MELHORAR_CONDICIONAMENTO);
        try {
            pt3.cadastrarTreino(t1);
            pt3.cadastrarTreino(t2);
        } catch (ObjetoDuplicadoException e) {
            e.printStackTrace();
        }

        PlanoTreino pt4 = new PlanoTreino((Cliente) c4,LocalDate.of(2022, 05, 15),
                LocalDate.of(2022, 05, 25), ObjetivoTreino.PERDER_MASSA);
        try {
            pt4.cadastrarTreino(t1);
            pt4.cadastrarTreino(t2);
        } catch (ObjetoDuplicadoException e) {
            e.printStackTrace();
        }

        try {
            Fachada.getInstance().cadastrarPlanoTreino(pt1);
            Fachada.getInstance().cadastrarPlanoTreino(pt2);
            Fachada.getInstance().cadastrarPlanoTreino(pt3);
            Fachada.getInstance().cadastrarPlanoTreino(pt4);
        } catch (ObjetoDuplicadoException | MaisDeUmPlanoNoMesmoPeriodoException e) {
            e.printStackTrace();
        }
    }
}
