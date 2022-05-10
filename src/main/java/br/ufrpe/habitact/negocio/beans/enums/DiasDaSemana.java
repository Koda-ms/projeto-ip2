package br.ufrpe.habitact.negocio.beans.enums;

public class DiasDaSemana {
    public enum Refeicao {
        SEGUNDA_FEIRA ("Segunda-feira"),
        TERCA_FEIRA ("Terça-feira"),
        QUARTA_FEIRA ("Quarta-feira"),
        QUINTA_FEIRA ("Quinta-feira"),
        SEXTA_FEIRA ("Sexta-feira"),
        SABADO ("Sábado"),
        DOMINGO ("Domingo");

        private String diaDaSemana;

        Refeicao(String diaDaSemana){
            this.diaDaSemana = diaDaSemana;
        }

        public String getRefeicao() {
            return diaDaSemana;
        }

        @Override
        public String toString() {
            return this.diaDaSemana;
        }
    }
}
