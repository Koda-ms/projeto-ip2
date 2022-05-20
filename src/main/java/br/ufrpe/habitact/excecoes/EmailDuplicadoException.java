package br.ufrpe.habitact.excecoes;

public class EmailDuplicadoException extends Exception {
    public EmailDuplicadoException(String aviso) {
        super(aviso);
    }
}
