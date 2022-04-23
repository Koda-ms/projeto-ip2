package br.ufrpe.habitact.excecoes;

public class SenhaIncorretaException extends Exception {
	public SenhaIncorretaException(String aviso) {
		super(aviso);
	}
}
