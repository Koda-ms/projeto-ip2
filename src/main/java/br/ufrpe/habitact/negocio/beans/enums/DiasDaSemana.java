package br.ufrpe.habitact.negocio.beans.enums;

public enum DiasDaSemana {
    SEGUNDA_FEIRA("Segunda-feira"),
    TERCA_FEIRA("Terça-feira"),
    QUARTA_FEIRA("Quarta-feira"),
    QUINTA_FEIRA("Quinta-feira"),
    SEXTA_FEIRA("Sexta-feira"),
    SABADO("Sábado"),
    DOMINGO("Domingo");

    private String diaDaSemana;

    DiasDaSemana(String dia) {
        this.diaDaSemana = dia;
    }

    @Override
    public String toString() {
        return this.diaDaSemana;
    }
}
